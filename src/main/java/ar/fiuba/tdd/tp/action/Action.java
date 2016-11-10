package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GridGraph;

import java.util.HashMap;
import java.util.Map;

public abstract class Action {
    public abstract void run(GridGraph graph, int row, int col);

    private Map<String, Integer> loadRowOffsetMap() {
        Map<String, Integer> rowOffset = new HashMap<>();
        rowOffset.put("topLeft", -1);
        rowOffset.put("topRight", -1);
        rowOffset.put("bottomLeft", 1);
        rowOffset.put("bottomRight", 1);
        rowOffset.put("top", -2);
        rowOffset.put("bottom", +2);
        rowOffset.put("left", 0);
        rowOffset.put("right", 0);
        rowOffset.put("this", 0);
        rowOffset.put("topMiddle", -1);
        rowOffset.put("bottomMiddle", 1);
        rowOffset.put("middleLeft", 0);
        rowOffset.put("middleRight", 0);
        return rowOffset;
    }

    private Map<String, Integer> loadColOffset() {
        Map<String, Integer> colOffset = new HashMap<>();
        colOffset.put("topLeft", -1);
        colOffset.put("topRight", 1);
        colOffset.put("bottomLeft", -1);
        colOffset.put("bottomRight", 1);
        colOffset.put("top", 0);
        colOffset.put("bottom", 0);
        colOffset.put("left", -2);
        colOffset.put("right", 2);
        colOffset.put("this", 0);
        colOffset.put("topMiddle", 0);
        colOffset.put("bottomMiddle", 0);
        colOffset.put("middleLeft", -1);
        colOffset.put("middleRight", 1);
        return colOffset;
    }

    protected Coord parseCoord(int row, int col, String strCoord) {

        Map<String, Integer> rowOffset = loadRowOffsetMap();
        Map<String, Integer> colOffset = loadColOffset();

        Coord coord = new Coord(row + rowOffset.get(strCoord), col + colOffset.get(strCoord));

        return coord;
    }
}
