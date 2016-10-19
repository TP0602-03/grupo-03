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
        this.factory = newFactory;
    }

    public void readFile(String fileName) throws org.json.simple.parser.ParseException, IOException {
        JSONParser parser = new JSONParser();
        JSONObject jsonFile = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
        JSONArray jsonPlays = (JSONArray) jsonFile.get("plays");
        this.moves = new ArrayList<>();

        JSONObject jsonMove;
        JSONArray jsonPoint;
        int newX;
        int newY;
        int newId;
        String newAttirbute;
        String newValue;

        for (int i = 0; i < jsonPlays.size(); i++) {
            jsonMove = (JSONObject) jsonPlays.get(i);
            jsonPoint = (JSONArray) jsonMove.get("position");
            newX = ((Long) jsonPoint.get(0)).intValue();
            newY = ((Long) jsonPoint.get(1)).intValue();
            newId = ((Long) jsonMove.get("number")).intValue();
            newAttirbute  = (String) jsonMove.get("attribute");
            newValue = (String) jsonMove.get("value");
            this.moves.add(this.factory.createMove(newId, newX, newY,newAttirbute, newValue));
        }

        this.sortMoves();

    }

    public void sortMoves() {
        //Sort the array
        Comparator<Move> comparator = (Move move1, Move move2) -> {
            return (((Integer) move1.getId()).compareTo(move2.getId()));
        };
        Collections.sort(moves, comparator);
    }

    public Move getMove() {
        if (this.moves.isEmpty()) {
            return null;
        }
        return this.moves.remove(0);

    }


}
