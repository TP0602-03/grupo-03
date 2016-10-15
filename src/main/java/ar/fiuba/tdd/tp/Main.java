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

                BoardGameView board = new BoardGameView(5, 5);

            }catch (Exception ex){

            }
        }
    }
}