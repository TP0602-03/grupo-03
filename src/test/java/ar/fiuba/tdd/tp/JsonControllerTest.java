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

    HashMap<String,Boolean> valuesMap = new HashMap<String,Boolean>() {
        {
            put("1",Boolean.TRUE);
            put("2",Boolean.TRUE);
            put("3",Boolean.TRUE);
        }
    };


    HashMap<Pair<Integer,Integer>, Boolean> positionsMap = new HashMap<Pair<Integer,Integer>,Boolean>() {
        {

            put(new Pair<>(0,0),Boolean.TRUE);
            put(new Pair<>(0,1),Boolean.TRUE);
            put(new Pair<>(1,0),Boolean.TRUE);
            put(new Pair<>(1,1),Boolean.TRUE);
        }
    };

    MoveFactory factory = new MoveFactory(valuesMap,positionsMap);


    @Test
    public void testMovesCreationWithValidMoves() throws org.json.simple.parser.ParseException,IOException {

        JsonFileController controller = new JsonFileController(factory);
        controller.readFile(allValidMoves);

        ArrayList<Move> moves = controller.getMoves();

        for(Move move: moves) {
            assertTrue(move.getClass() == ValidMove.class);
        }


    }

    @Test
    public void testMovesCreationWithInvalidMoves() throws org.json.simple.parser.ParseException,IOException {

        JsonFileController controller = new JsonFileController(factory);
        controller.readFile(allInvalidMoves);

        ArrayList<Move> moves = controller.getMoves();

        for(Move move: moves) {
            assertTrue(move.getClass() == InvalidMove.class);
        }


    }

    @Test
    public void testMovesCreationWithEveryOtherValidMoves() throws org.json.simple.parser.ParseException,IOException {

        JsonFileController controller = new JsonFileController(factory);
        controller.readFile(everyOtherValidMoves);

        ArrayList<Move> moves = controller.getMoves();

        int index = 0;
        for(Move move: moves) {
            if (index % 2 == 0) {
                assertTrue(move.getClass() == ValidMove.class);
            } else{
                assertTrue(move.getClass() == InvalidMove.class);
            }
            index++;
        }


    }

}
