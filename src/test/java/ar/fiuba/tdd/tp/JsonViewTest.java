package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.move.InvalidMoveException;
import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.MoveFactory;
import ar.fiuba.tdd.tp.view.JsonFileView;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by luciano on 16/10/16.
 */
public class JsonViewTest {

    String alreadyPrintedFile = "testFiles/jsonOutputCorrectFile.json";

    HashMap<String, ArrayList<String>> valuesMap = new HashMap<String, ArrayList<String>>() {
        {
            put("num", new ArrayList<>(Arrays.asList("1", "2", "3", "4")));
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


//    @Test
//    public void testCorrectFileCreation() throws IOException, org.json.simple.parser.ParseException,
//            java.text.ParseException, InvalidMoveException {
//
//        Parser gameParser = new Parser("testFiles/sudokuForJsonFileView.json");
//        Game game = gameParser.getGame();
//
//        JsonFileView view = new JsonFileView("testFiles/jsonViewTestFile.json");
//        MoveFactory factory = new MoveFactory(valuesMap, positionsMap);
//
//        Move validMove = factory.createMove(1, 0, 0, "num", "1");
//        Move invalidMove = factory.createMove(2, 0, 1, "num", "38");
//
//        game.playCell(validMove.getY(), validMove.getX(), validMove.getAttribute(), validMove.getValue());
//
//        view.add(validMove);
//        view.add(invalidMove);
//        view.add(game);
//
//        view.write();
//
//        JSONParser parser = new JSONParser();
//        JSONObject jsonFile1 = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(alreadyPrintedFile), "UTF-8"));
//        JSONObject jsonFile2 = (JSONObject)
//                parser.parse(new InputStreamReader(new FileInputStream("testFiles/jsonViewTestFile.json"), "UTF-8"));
//
//        List<String> jsonList1 = Arrays.asList(jsonFile1.toString().split(","));
//        List<String> jsonList2 = Arrays.asList(jsonFile2.toString().split(","));
//        Collections.sort(jsonList1);
//        Collections.sort(jsonList2);
//
//
//        assertEquals(jsonList1, jsonList2);
//    }


    private void loadWinningGame(Game game, MoveFactory factory, JsonFileView view) throws InvalidMoveException {


        ArrayList<Move> array = new ArrayList<Move>() {
            {
                add(factory.createMove(1, 1, 0, "num", "1"));
                add(factory.createMove(2, 2, 0, "num", "4"));
                add(factory.createMove(3, 3, 0, "num", "2"));
                add(factory.createMove(4, 1, 2, "num", "3"));
                add(factory.createMove(5, 2, 1, "num", "3"));
                add(factory.createMove(6, 0, 3, "num", "2"));
                add(factory.createMove(7, 1, 3, "num", "4"));
                add(factory.createMove(8, 2, 3, "num", "1"));
            }
        };

        for (Move move : array) {
            game.playCell(move.getY(), move.getX(), move.getAttribute(), move.getValue());
            view.add(move);
        }

    }


//    @Test
//    public void testGameWins() throws IOException, org.json.simple.parser.ParseException, java.text.ParseException, InvalidMoveException {
//
//        Parser gameParser = new Parser("testFiles/sudokuForJsonFileView.json");
//        Game game = gameParser.getGame();
//
//
//        String newFile = "testFiles/jsonViewTestFileWon.json";
//        MoveFactory factory = new MoveFactory(valuesMap, positionsMap);
//
//
//        JsonFileView view = new JsonFileView(newFile);
//
//        loadWinningGame(game, factory, view);
//
//        view.add(game);
//
//        view.write();
//
//        JSONParser parser = new JSONParser();
//        JSONObject jsonFile1 =
//                (JSONObject) parser.parse(new InputStreamReader(new FileInputStream("testFiles/testOutputWonGame.json"), "UTF-8"));
//        JSONObject jsonFile2 = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(newFile), "UTF-8"));
//
//        List<String> jsonList1 = Arrays.asList(jsonFile1.toString().split(","));
//        List<String> jsonList2 = Arrays.asList(jsonFile2.toString().split(","));
//        Collections.sort(jsonList1);
//        Collections.sort(jsonList2);
//
//
//        assertEquals(jsonList1, jsonList2);
//    }

}
