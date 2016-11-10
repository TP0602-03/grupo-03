package ar.fiuba.tdd.tp.parser;

import org.json.simple.JSONObject;

public class PositionParser {
    private JSONObject obj;

    public PositionParser(JSONObject obj) {
        this.obj = obj;
    }

    public int getRow() {
        return ((Long) obj.get("r")).intValue();
    }

    public int getCol() {
        return ((Long) obj.get("c")).intValue();
    }
}
