package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.controller.JsonFileController;
import ar.fiuba.tdd.tp.move.InvalidMove;
import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.MoveFactory;
import ar.fiuba.tdd.tp.move.ValidMove;
import javafx.util.Pair;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

/**
 * Created by luciano on 15/10/16.
 */
public class JsonControllerTest {

    String folder = "testFiles/";
    String allValidMoves = folder + "JsonValidMoves.json";
    String allInvalidMoves = folder + "JsonInvalidMoves.json";
    String everyOtherValidMoves = folder + "JsonEveryOtherValidMove.json";

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


    @Test
    public void testMovesCreationWithValidMoves() throws org.json.simple.parser.ParseException, IOException {

        JsonFileController controller = new JsonFileController(factory);
        controller.readFile(allValidMoves);

        Move move;

        while(true) {
            move = controller.getMove();
            if( move == null) {
                break;
            }
            assertTrue(move.getClass() == ValidMove.class);
        }


    }

    @Test
    public void testMovesCreationWithInvalidMoves() throws org.json.simple.parser.ParseException, IOException {

        JsonFileController controller = new JsonFileController(factory);
        controller.readFile(allInvalidMoves);

        Move move;

        while(true) {
            move = controller.getMove();
            if( move == null) {
                break;
            }
            assertTrue(move.getClass() == InvalidMove.class);
        }


    }

    @Test
    public void testMovesCreationWithEveryOtherValidMoves() throws org.json.simple.parser.ParseException, IOException {

        JsonFileController controller = new JsonFileController(factory);
        controller.readFile(everyOtherValidMoves);


        int index = 0;
        Move move;
        while(true) {
            move = controller.getMove();
            if (move == null ) {
                break;
            }
            if (index % 2 == 0) {
                assertTrue(move.getClass() == ValidMove.class);
            } else {
                assertTrue(move.getClass() == InvalidMove.class);
            }
            index++;
        }


    }

}
