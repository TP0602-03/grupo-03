package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.parser.Parser;
import ar.fiuba.tdd.tp.view.BoardViewCreator;

import java.awt.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new MainRun());
    }

    private static class MainRun implements Runnable {

        private final BoardViewCreator boardViewCreator = new BoardViewCreator();

        @Override
        public void run() {
            try {
                Parser parser = new Parser("gameFiles/sudoku.json");
                boardViewCreator.createBoard(parser.getGame());
            } catch (Exception ex) {
                JFrame frame = new JFrame();
                JOptionPane optionPane = new JOptionPane();
                optionPane.setMessage(ex.getMessage());
                JDialog dialog = optionPane.createDialog(frame, "Error");
                dialog.setVisible(true);
            }
        }
    }
}
