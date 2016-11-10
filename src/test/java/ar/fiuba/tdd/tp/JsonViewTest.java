package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.move.InvalidMoveException;
import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.MoveFactory;
import ar.fiuba.tdd.tp.parser.Parser;
import ar.fiuba.tdd.tp.view.JsonFileView;
import javafx.util.Pair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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






    private void loadWinningGame(Game game, MoveFactory factory, JsonFileView view) throws InvalidMoveException {


        ArrayList<Move> array = new ArrayList<Move>() {
            {
                add(factory.createMove(1, 0, 3, "num", "2"));
                add(factory.createMove(2, 1, 0, "num", "1"));
                add(factory.createMove(3, 1, 2, "num", "3"));
                add(factory.createMove(4, 1, 3, "num", "4"));
                add(factory.createMove(5, 2, 0, "num", "4"));
                add(factory.createMove(6, 2, 1, "num", "3"));
                add(factory.createMove(7, 2, 3, "num", "1"));
                add(factory.createMove(8, 3, 0, "num", "2"));
            }
        };

        for (Move move : array) {
            game.playCell(move.getX(), move.getY(), move.getAttribute(), move.getValue());
            view.add(move);
        }

    }

    @Test
    public void testGameWins() throws IOException, org.json.simple.parser.ParseException,
            java.text.ParseException, InvalidMoveException,java.lang.Exception {

        Parser gameParser = new Parser("testFiles/sudokuForJsonFileView.json");
        Game game = gameParser.getGame();


        String newFile = "testFiles/jsonViewTestFileWon.json";
        System.out.print(game.getAllowedPositions());
        MoveFactory factory = new MoveFactory(game.getPossibleValues(), game.getAllowedPositions());


        JsonFileView view = new JsonFileView(newFile);

        loadWinningGame(game, factory, view);

        view.add(game);

        view.write();

        JSONParser parser = new JSONParser();
        JSONObject jsonFile1 =
                (JSONObject) parser.parse(new InputStreamReader(new FileInputStream("testFiles/testOutputWonGame.json"), "UTF-8"));
        JSONObject jsonFile2 = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(newFile), "UTF-8"));

        List<String> jsonList1 = Arrays.asList(jsonFile1.toString().split(","));
        List<String> jsonList2 = Arrays.asList(jsonFile2.toString().split(","));
        //Collections.sort(jsonList1);
        //Collections.sort(jsonList2);


        assertEquals(jsonList1, jsonList2);
    }

}
