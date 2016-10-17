package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.MoveFactory;
import ar.fiuba.tdd.tp.view.JsonFileView;
import javafx.util.Pair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by luciano on 16/10/16.
 */
public class JsonViewTest {

    String alreadyPrintedFile = "testFiles/jsonOutputCorrectFile.json";

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

    @Test
    public void testCorrectFileCreatiion() throws IOException, ParseException {

        String newFile = "testFiles/jsonViewTestFile.json";
        JsonFileView view = new JsonFileView(newFile);
        MoveFactory factory = new MoveFactory(valuesMap, positionsMap);

        Move validMove = factory.createMove(1, 0, 0, "1");
        Move invalidMove = factory.createMove(2, 0, 1, "38");

        view.add(validMove);
        view.add(invalidMove);

        view.write();

        JSONParser parser = new JSONParser();
        JSONObject jsonFile1 = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(alreadyPrintedFile), "UTF-8"));
        JSONObject jsonFile2 = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(newFile), "UTF-8"));

        assertEquals(jsonFile1, jsonFile2);
    }


}
