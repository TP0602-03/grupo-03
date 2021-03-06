package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.MoveFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by luciano on 15/10/16.
 */

public class JsonFileController {

    private ArrayList<Move> moves;
    private MoveFactory factory;

    public JsonFileController(MoveFactory newFactory) {
        factory = newFactory;
    }

    private Boolean isNumeric(String numberString) {
        try {
            Double.parseDouble(numberString);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void readFile(String fileName) throws org.json.simple.parser.ParseException, IOException {
        JSONParser parser = new JSONParser();
        JSONObject jsonFile = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
        JSONArray jsonPlays = (JSONArray) jsonFile.get("plays");
        moves = new ArrayList<>();

        loadMoves(jsonPlays);

        sortMoves();

    }

    private void loadMoves(JSONArray jsonPlays) {
        JSONObject jsonMove;
        JSONArray jsonPoint;
        int newX;
        int newY;
        int newId;
        String newAttribute;
        String newValue;

        for (Object jsonPlay : jsonPlays) {
            jsonMove = (JSONObject) jsonPlay;
            jsonPoint = (JSONArray) jsonMove.get("position");
            newX = ((Long) jsonPoint.get(0)).intValue();
            newY = ((Long) jsonPoint.get(1)).intValue();
            newId = ((Long) jsonMove.get("number")).intValue();
            newValue = (String) jsonMove.get("value");
            if (isNumeric(newValue)) {
                newAttribute = "num";
            } else {
                newAttribute = (String) jsonMove.get("attribute");
            }

            moves.add(factory.createMove(newId, newX, newY, newAttribute, newValue));
        }
    }

    public void sortMoves() {
        //Sort the array
        Comparator<Move> comparator = (Move move1, Move move2) -> (((Integer) move1.getId()).compareTo(move2.getId()));

        Collections.sort(moves, comparator);
    }

    public Move getMove() {
        if (moves.isEmpty()) {
            return null;
        }
        return moves.remove(0);

    }

}
