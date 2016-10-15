package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.parser.Parser;
import ar.fiuba.tdd.tp.view.*;

import java.awt.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new MainRun());
    }

    private static class MainRun implements Runnable {
        @Override
        public void run() {
            try {
                Parser parser = new Parser("gameFiles/sudoku.json");
                Game game = parser.getGame();

                BoardGameView board = new BoardGameView();


                for (int i = 0; i < 4; i ++) {
                    for (int j = 0; j < 4; j ++) {
                        JPanel panel = new JPanel();
                        panel.setBorder(BorderFactory.createLineBorder(Color.black));
                        panel.add(new JLabel("Hola"));
                        board.set(i, j,50, 50, panel);
                    }
                }
            }catch (Exception ex){

            }
        }
    }
}
