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
    private JPanel gamePanel;

    public MainWindow() {
        frame = new JFrame("Nikoli games");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        JMenuItem loadGame = new JMenuItem("Load...");
        menu.add(loadGame);
        menuBar.add(menu);
        Dimension dimension = new Dimension(400, 400);
        frame.setMinimumSize(dimension);
        //frame.setSize(400, 400);
        //frame.setResizable(false);
        frame.setJMenuBar(menuBar);
        loadGame.addActionListener(new LoadGameActionListener());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
    }

    public void show() {
        frame.setVisible(true);
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
                    Game game = parser.getGame();
                    frame.setTitle("Nikoli Games - " + game.getName());
                    BoardViewCreator boardViewCreator = new BoardViewCreator();
                    BoardGameView boardGameView = boardViewCreator.createBoard(game);
                    gamePanel = boardGameView.getPanel();
                    frame.setContentPane(gamePanel);
                    frame.pack();
                } catch (Exception ex) {
                    JFrame frame = new JFrame();
                    JOptionPane optionPane = new JOptionPane();
                    optionPane.setMessage("Error: could not load game.");
                    JDialog dialog = optionPane.createDialog(frame, "Error");
                    dialog.setVisible(true);
                }
            }
        }
    }
}
