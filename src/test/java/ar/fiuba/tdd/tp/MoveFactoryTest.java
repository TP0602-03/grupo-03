package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.move.InvalidMove;
import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.MoveFactory;
import ar.fiuba.tdd.tp.move.ValidMove;
import javafx.util.Pair;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class MoveFactoryTest {

    HashMap<String, ArrayList<String>> valuesMap = new HashMap<String, ArrayList<String>>() {
        {
            put("num", new ArrayList<>(Arrays.asList("1", "2", "3")));
        }
    };

    HashMap<Pair<Integer, Integer>, ArrayList<String>> positionsMap = new HashMap<Pair<Integer, Integer>, ArrayList<String>>() {
        {

            put(new Pair<>(0, 0), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(0, 1), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(1, 0), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(1, 1), new ArrayList<>(Arrays.asList("num")));
        }
    };

    @Test
    public void validMoveCreationWithHashAsFactoryCreationParameter() {

        MoveFactory factory = new MoveFactory(valuesMap, positionsMap);

        Move move = factory.createMove(1, 0, 0, "num", "1");

        assertTrue(move.getClass() == ValidMove.class);

    }

    @Test
    public void invalidMoveCreationWithHashAsFactoryCreationParameter() {

        MoveFactory factory = new MoveFactory(valuesMap, positionsMap);

        Move move = factory.createMove(1, 0, 0, "num", "50");

        assertTrue(move.getClass() == InvalidMove.class);

    }

}

