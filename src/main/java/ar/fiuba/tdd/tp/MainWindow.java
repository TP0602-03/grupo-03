package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.parser.Parser;
import ar.fiuba.tdd.tp.view.BoardGameView;
import ar.fiuba.tdd.tp.view.BoardViewCreator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainWindow {

    private JFrame frame;
    private JPanel gamePanel = new JPanel();
    private Game game = null;
    private BoardGameView boardGameView;

    public MainWindow() {
        frame = new JFrame("Nikoli Games");
        Dimension dimension = new Dimension(400, 400);
        frame.setMinimumSize(dimension);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.add(gamePanel, BorderLayout.CENTER);
        JButton undoButton = new JButton("Undo");
        JButton loadButton = new JButton("Load...");
        loadButton.setFocusPainted(false);
        loadButton.addActionListener(new LoadGameActionListener());
        undoButton.setFocusPainted(false);
        undoButton.addActionListener(new UndoPlayActionListener());
        JPanel auxPanel = new JPanel(new FlowLayout());
        auxPanel.add(loadButton);
        auxPanel.add(undoButton);
        frame.add(auxPanel, BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
    }

    private void showErrorDialog() {
        JFrame frame = new JFrame();
        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage("Error: could not load game.");
        JDialog dialog = optionPane.createDialog(frame, "Error");
        dialog.setVisible(true);
    }

    private class LoadGameActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
            int returnVal = fileChooser.showOpenDialog(frame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
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
                    showErrorDialog();
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

}
