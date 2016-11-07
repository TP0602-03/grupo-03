package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.parser.Parser;
import ar.fiuba.tdd.tp.view.BoardGameView;
import ar.fiuba.tdd.tp.view.BoardViewCreator;
import ar.fiuba.tdd.tp.view.CellView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;
import java.util.Set;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainWindow {

    private JFrame frame;
    private JPanel gamePanel = new JPanel();
    private Game game = null;
    private BoardGameView boardGameView;

    public MainWindow() {
        frame = new JFrame("Nikoli games");
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

    private void drawCells() {
        for (int i = 0; i < game.getHeight(); i++) {
            for (int j = 0; j < game.getWidth(); j++) {
                CellView cell = (CellView) boardGameView.getCell(i, j);
                Set<Map.Entry<String, String>> atts = game.getCellKeysValues(i, j);
                drawCellView(cell, atts);
            }
        }
    }

    private void drawCellView(CellView cell, Set<Map.Entry<String, String>> atts) {
        for (Map.Entry<String, String> att : atts) {
            cell.setContent(att.getKey(), att.getValue());
        }
        cell.generateLabels();
        cell.revalidate();
        cell.repaint();
    }

    private void drawVertices() {
        for (int i = 0; i < game.getHeight() + 1; i++) {
            for (int j = 0; j < game.getWidth() + 1; j++) {
                CellView cell = (CellView) boardGameView.getVertex(i, j);
                //Para que no falle CDP :p
                drawCellView(cell, game.getVertexKeysValues(i, j));
            }
        }
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

                drawVertices();

                drawCells();
            }
        }
    }

}
