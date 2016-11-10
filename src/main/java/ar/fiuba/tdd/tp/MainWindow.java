package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.controller.JsonFileController;
import ar.fiuba.tdd.tp.move.InvalidMove;
import ar.fiuba.tdd.tp.move.InvalidMoveException;
import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.MoveFactory;
import ar.fiuba.tdd.tp.parser.Parser;
import ar.fiuba.tdd.tp.view.BoardGameView;
import ar.fiuba.tdd.tp.view.BoardViewCreator;
import ar.fiuba.tdd.tp.view.JsonFileView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainWindow {

    private JFrame frame;
    private JPanel gamePanel = new JPanel();
    private Game game = null;
    private BoardGameView boardGameView;


    private JPanel createPanel() {
        JPanel auxPanel = new JPanel(new FlowLayout());
        auxPanel.add(this.createButton("Load...",new LoadGameActionListener()));
        auxPanel.add(this.createButton("Undo",new UndoPlayActionListener()));
        //auxPanel.add(this.createButton("Solve from file",new SolveFromFileActionListener()));
        return auxPanel;
    }

    private JButton createButton(String name,ActionListener listener) {
        JButton button = new JButton(name);
        button.setFocusPainted(false);
        button.addActionListener(listener);
        return button;
    }

    public MainWindow() {
        frame = new JFrame("Nikoli Games");
        Dimension dimension = new Dimension(400, 400);
        frame.setMinimumSize(dimension);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.add(gamePanel, BorderLayout.CENTER);

        frame.add(this.createPanel(), BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
    }

    private void showErrorDialog(String error) {
        JFrame frame = new JFrame();
        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(error);
        JDialog dialog = optionPane.createDialog(frame, "Error");
        dialog.setVisible(true);
    }

    private class LoadGameActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            File file = chooseFile(frame);
            if (file != null) {
                try {
                    Parser parser = new Parser(file.getAbsolutePath());
                    game = parser.getGame();
                    frame.setTitle("Nikoli Games - " + game.getName());
                    BoardViewCreator boardViewCreator = new BoardViewCreator();
                    boardGameView = boardViewCreator.createBoard(game);
                    frame.remove(gamePanel);
                    gamePanel = boardGameView.getPanel();
                    frame.add(gamePanel, BorderLayout.CENTER);
                    frame.pack();
                } catch (Exception ex) {
                    showErrorDialog("Error: could not load game.");
                }
            }
        }
    }

    private class UndoPlayActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (game != null) {
                game.undoPlay();

                boardGameView.update();
            }
        }
    }


    private void playGame(Game game,File file) throws ParseException,IOException,
            org.json.simple.parser.ParseException,InvalidMoveException {
        MoveFactory factory = new MoveFactory(game.getPossibleValues(),game.getAllowedPositions());
        JsonFileController controller = new JsonFileController(factory);
        controller.readFile(file.getPath());
        Move move;
        JsonFileView view = new JsonFileView("testFiles/test.json");




        while (true) {
            move = controller.getMove();

            if (move == null) {
                break;
            }
            view.add(move);
            try {
                game.playCell(move.getY(), move.getX(), move.getAttribute(), move.getValue());
            } catch (InvalidMoveException ex) {
                //do nothing
            }
        }
        view.add(game);
        view.write();
        boardGameView.update();
    }

    private File chooseFile(Frame frame) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
        int returnVal = fileChooser.showOpenDialog(frame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            return file;
        }
        return null;
    }

    private class SolveFromFileActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (game != null) {
                File file = chooseFile(frame);
                if (file != null) {
                    try {
                        playGame(game, file);
                    } catch (Exception ex) {
                        showErrorDialog("Error: Invalid move's file");
                    }
                }
            }
        }
    }

}
