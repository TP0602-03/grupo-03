package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.move.InvalidMove;
import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.MoveFactory;
import ar.fiuba.tdd.tp.move.ValidMove;
import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class MoveFactoryTest {


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

    ArrayList<String> valuesList = new ArrayList<String>() {
        {
            add("1");
            add("2");
            add("3");
        }
    };

    ArrayList<Pair<Integer, Integer>> positionsList = new ArrayList<Pair<Integer, Integer>>() {
        {
            add(new Pair<>(0, 0));
            add(new Pair<>(0, 1));
            add(new Pair<>(1, 0));
            add(new Pair<>(1, 1));
        }
    };


    @Test
    public void validMoveCreationWithHashAsFactoryCreationParameter() {

        MoveFactory factory = new MoveFactory(valuesMap, positionsMap);

        Move move = factory.createMove(1, 0, 0, "1");

        assertTrue(move.getClass() == ValidMove.class);


    }

    @Test
    public void invalidMoveCreationWithHashAsFactoryCreationParameter() {

        MoveFactory factory = new MoveFactory(valuesMap, positionsMap);

        Move move = factory.createMove(1, 0, 0, "50");

        assertTrue(move.getClass() == InvalidMove.class);


    }

}

