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

/**
 * Created by luciano on 15/10/16.
 */
public class MoveFactoryTest {

    HashMap<String, Boolean> valuesMap = new HashMap<String, Boolean>() {{
        put("1", Boolean.TRUE);
        put("2", Boolean.TRUE);
        put("3", Boolean.TRUE);
    }};


    HashMap<Pair<Integer, Integer>, Boolean> positionsMap = new HashMap<Pair<Integer, Integer>, Boolean>() {{
        put(new Pair<>(0, 0), Boolean.TRUE);
        put(new Pair<>(0, 1), Boolean.TRUE);
        put(new Pair<>(1, 0), Boolean.TRUE);
        put(new Pair<>(1, 1), Boolean.TRUE);
    }};

    ArrayList<String> valuesList = new ArrayList<String>() {{
        add("1");
        add("2");
        add("3");
    }};

    ArrayList<Pair<Integer, Integer>> positionsList = new ArrayList<Pair<Integer, Integer>>() {{
        add(new Pair<>(0, 0));
        add(new Pair<>(0, 1));
        add(new Pair<>(1, 0));
        add(new Pair<>(1, 1));
    }};

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

    @Test
    public void validMoveCreationWithListAsFactoryCreationParameter() {

        MoveFactory factory = new MoveFactory(valuesList, positionsList);

        Move move = factory.createMove(1, 0, 0, "1");

        assertTrue(move.getClass() == ValidMove.class);


    }

    @Test
    public void invalidMoveCreationWithListAsFactoryCreationParameter() {

        MoveFactory factory = new MoveFactory(valuesList, positionsList);

        Move move = factory.createMove(1, 0, 0, "50");

        assertTrue(move.getClass() == InvalidMove.class);


    }
}

