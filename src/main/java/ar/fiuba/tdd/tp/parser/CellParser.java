package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CellParser {
    public void loadCells(Game game, JSONArray cells) {
        for (Object o :
                cells) {
            JSONObject cell = (JSONObject) o;
            int row = ((Long) cell.get("x")).intValue();
            int col = ((Long) cell.get("y")).intValue();
            GraphVertex vertex = game.getCell(row, col);
            JSONArray attributes = (JSONArray) cell.get("attributes");
            for (Object e :
                    attributes) {
                JSONObject attribute = (JSONObject) e;
                String name = (String) attribute.get("name");
                Object value = attribute.get("value");
                if(value.getClass() == Long.class){
                    value = ((Long)value).intValue();
                }
                vertex.setAttribute(name, value);
            }
        }
    }
}
