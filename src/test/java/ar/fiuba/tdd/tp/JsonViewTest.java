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
import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by luciano on 16/10/16.
 */
public class JsonViewTest {

    String alreadyPrintedFile = "testFiles/jsonOutputCorrectFile.json";

    HashMap<String, ArrayList<String>> valuesMap = new HashMap<String, ArrayList<String>>() {
        {
            put("num", new ArrayList<>(Arrays.asList("1","2","3","4")));
        }
    };


    HashMap<Pair<Integer, Integer>, ArrayList<String>> positionsMap = new HashMap<Pair<Integer, Integer>, ArrayList<String>>() {
        {

            put(new Pair<>(0, 0), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(0, 1), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(0, 2), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(0, 3), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(1, 0), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(1, 1), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(1, 2), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(1, 3), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(2, 0), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(2, 1), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(2, 2), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(2, 3), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(3, 0), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(3, 1), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(3, 2), new ArrayList<>(Arrays.asList("num")));
            put(new Pair<>(3, 3), new ArrayList<>(Arrays.asList("num")));
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

        List<String> jsonList1 = Arrays.asList(jsonFile1.toString().split(","));
        List<String> jsonList2 = Arrays.asList(jsonFile2.toString().split(","));
        Collections.sort(jsonList1);
        Collections.sort(jsonList2);



        assertEquals(jsonList1,jsonList2);
    }


    @Test
    public void testGameWins() throws IOException, org.json.simple.parser.ParseException, java.text.ParseException, InvalidMoveException{

        Parser gParser = new Parser("testFiles/sudokuForJsonFileView.json");
        Game game = gParser.getGame();



        String newFile = "testFiles/jsonViewTestFileWon.json";
        JsonFileView view = new JsonFileView(newFile);
        MoveFactory factory = new MoveFactory(valuesMap, positionsMap);

        Move validMove = factory.createMove(1, 1, 0,"num","1");
        Move validMove1 = factory.createMove(2, 2, 0,"num","4");
        Move validMove2 = factory.createMove(3, 3, 0,"num","2");
        Move validMove3 = factory.createMove(4, 1, 2,"num","3");
        Move validMove4 = factory.createMove(5, 2, 1,"num","3");
        Move validMove5 = factory.createMove(6, 0, 3,"num","2");
        Move validMove6 = factory.createMove(7, 1, 3,"num","4");
        Move validMove7 = factory.createMove(8, 2, 3,"num","1");


        game.playCell(validMove.getY(),validMove.getX(),validMove.getAttribute(),validMove.getValue());
        game.playCell(validMove1.getY(),validMove1.getX(),validMove1.getAttribute(),validMove1.getValue());
        game.playCell(validMove2.getY(),validMove2.getX(),validMove2.getAttribute(),validMove2.getValue());
        game.playCell(validMove3.getY(),validMove3.getX(),validMove3.getAttribute(),validMove3.getValue());
        game.playCell(validMove4.getY(),validMove4.getX(),validMove4.getAttribute(),validMove4.getValue());
        game.playCell(validMove5.getY(),validMove5.getX(),validMove5.getAttribute(),validMove5.getValue());
        game.playCell(validMove6.getY(),validMove6.getX(),validMove6.getAttribute(),validMove6.getValue());
        game.playCell(validMove7.getY(),validMove7.getX(),validMove7.getAttribute(),validMove7.getValue());

        view.add(validMove);
        view.add(validMove1);
        view.add(validMove2);
        view.add(validMove3);
        view.add(validMove4);
        view.add(validMove5);
        view.add(validMove6);
        view.add(validMove7);

        view.add(game);

        view.write();

        JSONParser parser = new JSONParser();
        JSONObject jsonFile1 = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream("testFiles/testOutputWonGame.json"), "UTF-8"));
        JSONObject jsonFile2 = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(newFile), "UTF-8"));

        List<String> jsonList1 = Arrays.asList(jsonFile1.toString().split(","));
        List<String> jsonList2 = Arrays.asList(jsonFile2.toString().split(","));
        Collections.sort(jsonList1);
        Collections.sort(jsonList2);



        assertEquals(jsonList1,jsonList2);
    }

}
