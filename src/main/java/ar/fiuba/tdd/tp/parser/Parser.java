package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.Game;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Parser {
    private String path;
    private JSONObject jsonGame;
    //private String gameName;
    private int width;
    private int height;
    private Game game;

    public Parser(String filePath) throws ParseException, IOException, org.json.simple.parser.ParseException {
        this.path = filePath;
        JSONParser parser = new JSONParser();
        this.jsonGame = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(this.path), "UTF-8"));
        //this.gameName = (String) this.jsonGame.get("name");
        JSONObject size = (JSONObject) this.jsonGame.get("size");
        width = ((Long) size.get("width")).intValue();
        height = ((Long) size.get("height")).intValue();

        game = new Game(width, height);

        CellParser cellParser = new CellParser();
        JSONArray jsonCells = (JSONArray) jsonGame.get("cells");
        cellParser.loadCells(game, jsonCells);

        RegionParser regionParser = new RegionParser();
        JSONArray jsonRegions = (JSONArray) jsonGame.get("regions");
        regionParser.loadRegions(game, jsonRegions);

    }

    public Game getGame() {
        return game;
    }

}
