package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.parser.Parser;
import ar.fiuba.tdd.tp.view.BoardViewCreator;

import java.awt.*;
import ar.fiuba.tdd.tp.controller.ConsoleController;
import ar.fiuba.tdd.tp.move.InvalidMoveException;
import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.MoveFactory;
import javafx.util.Pair;

import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new MainRun());
    }

//    public static void main(String[] args) throws IOException {
//        HashMap<String, String> valuesMap = new HashMap<String, String>() {
//            {
//                put("1", "num");
//                put("2", "num");
//                put("3", "num");
//            }
//        };
//
//
//        HashMap<Pair<Integer, Integer>, Boolean> positionsMap = new HashMap<Pair<Integer, Integer>, Boolean>() {
//            {
//                put(new Pair<>(0, 0), Boolean.TRUE);
//                put(new Pair<>(0, 1), Boolean.TRUE);
//                put(new Pair<>(1, 0), Boolean.TRUE);
//                put(new Pair<>(1, 1), Boolean.TRUE);
//            }
//        };
//
//        MoveFactory factory = new MoveFactory(valuesMap, positionsMap);
//        ConsoleController controller = new ConsoleController(factory);
//
//        while (true) {
//
//            Move move = controller.getMove();
//            try {
//                System.out.println(Integer.toString(move.getId()) + Integer.toString(move.getX()) + Integer.toString(move.getY()) + move.getValue());
//            } catch (InvalidMoveException e) {
//                //
//            }
//
//        }
//    }
    private static class MainRun implements Runnable {
        private final BoardViewCreator boardViewCreator = new BoardViewCreator();

        @Override
        public void run() {
            try {
                Parser parser = new Parser("gameFiles/sudoku.json");
                boardViewCreator.CreateBoard(parser.getGame());

            } catch (Exception ex) {

            }
        }
    }
}
