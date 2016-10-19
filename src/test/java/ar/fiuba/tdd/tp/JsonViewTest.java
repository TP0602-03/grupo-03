package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.move.InvalidMoveException;
import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.MoveFactory;
import ar.fiuba.tdd.tp.parser.Parser;
import ar.fiuba.tdd.tp.view.JsonFileView;
import javafx.util.Pair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by luciano on 16/10/16.
 */
public class JsonViewTest {

    String alreadyPrintedFile = "testFiles/jsonOutputCorrectFile.json";

    HashMap<String, ArrayList<String>> valuesMap = new HashMap<String, ArrayList<String>>() {
        {
            put("num", new ArrayList<>(Arrays.asList("1","2","3")));
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
    public void testCorrectFileCreation() throws IOException, org.json.simple.parser.ParseException, java.text.ParseException, InvalidMoveException{

        Parser gParser = new Parser("testFiles/sudokuForJsonFileView.json");
        Game game = gParser.getGame();


        String newFile = "testFiles/jsonViewTestFile.json";
        JsonFileView view = new JsonFileView(newFile);
        MoveFactory factory = new MoveFactory(valuesMap, positionsMap);

        Move validMove = factory.createMove(1, 0, 0,"num","1");
        Move invalidMove = factory.createMove(2, 0, 1,"num","38");

        game.playCell(validMove.getY(),validMove.getX(),validMove.getAttribute(),validMove.getValue());

        view.add(validMove);
        view.add(invalidMove);
        view.add(game);

        view.write();

        JSONParser parser = new JSONParser();
        JSONObject jsonFile1 = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(alreadyPrintedFile), "UTF-8"));
        JSONObject jsonFile2 = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(newFile), "UTF-8"));

        assertEquals(jsonFile1, jsonFile2);
    }


}
