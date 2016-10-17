package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Objects;
import java.util.Set;

public class GraphVertexParser {
    public void loadGrid(Game game, JSONObject grid) {
        JSONArray verticesJson = (JSONArray) grid.get("vertices");
        if (verticesJson != null) {
            loadAll(game, verticesJson, "vertices");
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
            int x = ((Long) vertex.get("x")).intValue();
            int y = ((Long) vertex.get("y")).intValue();
            JSONObject attributesJson = (JSONObject) vertex.get("attributes");
            loadAttributes(getGraphVertex(game, x, y, type), attributesJson);
        }
    }

    private GraphVertex getGraphVertex(Game game, int x, int y, String type) {
        if (Objects.equals(type, "vertices")) {
            return game.getNode(x, y);
        } else {
            // cells
            return game.getCell(x, y);
        }
    }

    private void loadAttributes(GraphVertex vertex, JSONObject attributesJson) {
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
