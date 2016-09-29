package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.grid.Grid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GridParser {

    private String path;

    public GridParser(String filePath) {
        this.path = filePath;
    }

    public void loadGridFromFile(Grid grid) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonGame = (JSONObject) parser.parse(this.path);
        System.out.print(jsonGame);
        // TODO: Make a pipeline after reading game name
    }


}
