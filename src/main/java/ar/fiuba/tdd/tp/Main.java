package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.parser.Parser;
import ar.fiuba.tdd.tp.view.BoardViewCreator;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new MainRun());
    }

    private static class MainRun implements Runnable {
        private final BoardViewCreator boardViewCreator = new BoardViewCreator();

        @Override
        public void run() {
            try {
                Parser parser = new Parser("gameFiles/a.json");
                boardViewCreator.createBoard(parser.getGame());
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
    }
}
