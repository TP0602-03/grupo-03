package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Objects;
import java.util.Set;

public class GraphVertexParser {
    public void loadGrid(Game game, JSONObject grid) {
        JSONArray verticesJson = (JSONArray) grid.get("corners");
        if (verticesJson != null) {
            loadAll(game, verticesJson, "corners");
        }
        JSONArray cellsJson = (JSONArray) grid.get("cells");
        if (cellsJson != null) {
            loadAll(game, cellsJson, "cells");
        }
    }

    private void loadAll(Game game, JSONArray verticesJson, String type) {
        for (Object obj :
                verticesJson) {
            JSONObject vertex = (JSONObject) obj;
            int row = ((Long) vertex.get("x")).intValue();
            int col = ((Long) vertex.get("y")).intValue();
            JSONObject attributesJson = (JSONObject) vertex.get("attributes");
            loadAttributes(getGraphVertex(game, row, col, type), attributesJson);
        }
    }

    private GraphVertex getGraphVertex(Game game, int row, int col, String type) {
        if (Objects.equals(type, "corners")) {
            return game.getCorner(row, col);
        } else {
            // cells
            return game.getCell(row, col);
        }
    }

    private void loadAttributes(GraphVertex vertex, JSONObject attributesJson) {
        Set attributes = attributesJson.keySet();
        for (Object attribute :
                attributes) {
            String attributeName = (String) attribute;
            Object value = attributesJson.get(attributeName);
            vertex.setAttribute(attributeName, value.toString());
        }
    }
}
