package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Set;

public class CellParser {
    public void loadCells(Game game, JSONArray cells) {
        for (Object o :
                cells) {
            JSONObject cell = (JSONObject) o;
            int row = ((Long) cell.get("x")).intValue();
            int col = ((Long) cell.get("y")).intValue();
            GraphVertex vertex = game.getCell(row, col);
            JSONObject attributesJson = (JSONObject) cell.get("attributes");
            Set attributes = attributesJson.keySet();

            for (Object attribute :
                    attributes) {
                String attributeName = (String) attribute;
                Object value = attributesJson.get(attributeName);
                if (value.getClass() == Long.class) {
                    value = ((Long) value).intValue();
                }
                vertex.setAttribute(attributeName, value);
            }
        }
    }
}
