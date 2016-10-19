package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GridGraph;

import java.util.HashMap;
import java.util.Map;

public abstract class Action {
    public abstract void run(GridGraph graph, int row, int col);

    protected Coord parseCoord(int row, int col, String strCoord) {

        Map<String, Integer> rowOffset = new HashMap<>();
        Map<String, Integer> colOffset = new HashMap<>();

        rowOffset.put("topLeft", -1);
        colOffset.put("topLeft", -1);

        rowOffset.put("topRight", -1);
        colOffset.put("topRight", 1);

        rowOffset.put("bottomLeft", 1);
        colOffset.put("bottomLeft", -1);

        rowOffset.put("bottomRight", 1);
        colOffset.put("bottomRight", 1);


        rowOffset.put("top", -2);
        colOffset.put("top", 0);

        rowOffset.put("bottom", +2);
        colOffset.put("bottom", 0);

        rowOffset.put("left", 0);
        colOffset.put("left", -2);

        rowOffset.put("right", 0);
        colOffset.put("right", 2);

        rowOffset.put("this", 0);
        colOffset.put("this", 0);

        rowOffset.put("topMiddle", -1);
        colOffset.put("topMiddle", 0);

        rowOffset.put("bottomMiddle", 1);
        colOffset.put("bottomMiddle", 0);

        rowOffset.put("middleLeft", 0);
        colOffset.put("middleLeft", -1);

        rowOffset.put("middleRight", 0);
        colOffset.put("middleRight", 1);

        Coord coord = new Coord(row + rowOffset.get(strCoord), col + colOffset.get(strCoord));

        return coord;
    }
}
