package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.controller.ConsoleController;
import ar.fiuba.tdd.tp.move.InvalidMoveException;
import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.MoveFactory;
import javafx.util.Pair;

import java.io.IOException;
import java.util.HashMap;

public class Main {


    public static void main(String[] args) throws IOException {
        HashMap<String, String> valuesMap = new HashMap<String, String>() {
            {
                put("1", "num");
                put("2", "num");
                put("3", "num");
            }
        };


        HashMap<Pair<Integer, Integer>, Boolean> positionsMap = new HashMap<Pair<Integer, Integer>, Boolean>() {
            {
                put(new Pair<>(0, 0), Boolean.TRUE);
                put(new Pair<>(0, 1), Boolean.TRUE);
                put(new Pair<>(1, 0), Boolean.TRUE);
                put(new Pair<>(1, 1), Boolean.TRUE);
            }
        };

        MoveFactory factory = new MoveFactory(valuesMap, positionsMap);
        ConsoleController controller = new ConsoleController(factory);

        while (true) {

            Move move = controller.getMove();
            try {
                String id = Integer.toString(move.getId());
                String row = Integer.toString(move.getX());
                String col = Integer.toString(move.getY());
                String value = move.getValue();
                System.out.println(id + row + col + value);
            } catch (InvalidMoveException e) {
                //
            }

        }

    }


}
