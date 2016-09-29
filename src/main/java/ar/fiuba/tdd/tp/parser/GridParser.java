package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.grid.Grid;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class GridParser {

    private String path;
    private FillerResolver fillerResolver;
    private JSONObject jsonGame;
    private String gameName;

    public GridParser(String filePath) throws ParseException, IOException {
        this.path = filePath;
        this.fillerResolver = new FillerResolver();
        JSONParser parser = new JSONParser();
        this.jsonGame = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(this.path), "UTF-8"));
        this.gameName = (String) this.jsonGame.get("name");
    }

    public String getGameName() {
        return this.gameName;
    }

    public void loadGridFromFile(Grid grid) throws ParseException {
        IFiller filler = this.fillerResolver.getFiller(this.gameName);
        filler.fill(grid, this.jsonGame);
    }

    public int getRowsCount() {
        return ((Long) this.jsonGame.get("rows")).intValue();
    }

    public int getColumnsCount() {
        return ((Long) this.jsonGame.get("columns")).intValue();
    }
}
