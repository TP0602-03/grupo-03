package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.MoveFactory;
import ar.fiuba.tdd.tp.parser.CellParser;
import ar.fiuba.tdd.tp.parser.RegionParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by luciano on 15/10/16.
 */
public class JsonFileController {

    private ArrayList<Move> moves;
    private MoveFactory factory;


    public JsonFileController(MoveFactory newFactory) {
        this.factory = newFactory;
    }

    public void readFile(String fileName) throws FileNotFoundException,UnsupportedEncodingException,org.json.simple.parser.ParseException,IOException {
        JSONParser parser = new JSONParser();
        JSONObject jsonFile = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
        JSONArray jsonPlays = (JSONArray) jsonFile.get("plays");

        JSONObject jsonMove;
        JSONArray jsonPoint;
        int newX;
        int newY;
        int newId;
        String newValue;

        for (int i = 0; i < jsonPlays.size(); i++) {
            jsonMove = (JSONObject) jsonPlays.get(i);
            jsonPoint = (JSONArray) jsonMove.get("position");
            newX = ((Long) jsonPoint.get(0)).intValue();
            newY = ((Long) jsonPoint.get(1)).intValue();
            newId = ((Long) jsonMove.get("number")).intValue();
            newValue = (String) jsonMove.get("value");
            this.moves.add(this.factory.createMove(newId,newX,newY,newValue));
        }

    }

    public ArrayList<Move> getMoves(){
        return this.moves;
    }



}
