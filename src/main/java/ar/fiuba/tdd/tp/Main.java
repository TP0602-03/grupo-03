package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.controller.JsonFileController;
import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.MoveFactory;
import ar.fiuba.tdd.tp.parser.Parser;
import ar.fiuba.tdd.tp.view.BoardViewCreator;
import javafx.util.Pair;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new MainRun());
    }

    private static class MainRun implements Runnable {
        private final BoardViewCreator boardViewCreator = new BoardViewCreator();


        HashMap<String, ArrayList<String>> valuesMap = new HashMap<String, ArrayList<String>>() {
            {
                put("num", new ArrayList<>(Arrays.asList("1", "2", "3","4","5")));
            }
        };


        HashMap<Pair<Integer, Integer>, ArrayList<String>> positionsMap = new HashMap<Pair<Integer, Integer>, ArrayList<String>>() {
            {

                put(new Pair<>(0, 0), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(0, 1), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(0, 2), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(0, 3), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(0, 4), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(1, 0), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(1, 1), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(1, 2), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(1, 3), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(1, 4), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(2, 0), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(2, 1), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(2, 2), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(2, 3), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(2, 4), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(3, 0), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(3, 1), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(3, 2), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(3, 3), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(3, 4), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(4, 0), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(4, 1), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(4, 2), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(4, 3), new ArrayList<>(Arrays.asList("num")));
                put(new Pair<>(4, 4), new ArrayList<>(Arrays.asList("num")));

            }
        };


        @Override
        public void run() {
            try {
                Parser parser = new Parser("gameFiles/inshiIteracion2.json");
                Game game = parser.getGame();
                MoveFactory factory = new MoveFactory(valuesMap,positionsMap);
                JsonFileController controller = new JsonFileController(factory);
                controller.readFile("testFiles/inshi.json");
                while(true) {
                    Move move = controller.getMove();
                    if( move == null ) {
                        break;
                    }
                    game.playCell(move.getY(),move.getX(),move.getAttribute(),move.getValue());
                }
                boardViewCreator.createBoard(parser.getGame());
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
    }
}
