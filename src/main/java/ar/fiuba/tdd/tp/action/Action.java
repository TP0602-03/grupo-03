package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GridGraph;

import java.util.Objects;

public abstract class Action {
    public abstract void run(GridGraph graph, int x, int y);

    protected Coord parseCoord(int x, int y, String strCoord) {
        Coord coord = null;
        if (Objects.equals(strCoord, "topLeft")) {
            coord = new Coord(x - 1, y - 1);
        }
        if (Objects.equals(strCoord, "topRight")) {
            coord = new Coord(x - 1, y + 1);
        }
        if (Objects.equals(strCoord, "bottomLeft")) {
            coord = new Coord(x + 1, y - 1);
        }
        if (Objects.equals(strCoord, "bottomRight")) {
            coord = new Coord(x + 1, y + 1);
        }
        if (Objects.equals(strCoord, "top")) {
            coord = new Coord(x - 2, y);
        }
        if (Objects.equals(strCoord, "bottom")) {
            coord = new Coord(x + 2, y);
        }
        if (Objects.equals(strCoord, "left")) {
            coord = new Coord(x, y - 2);
        }
        if (Objects.equals(strCoord, "right")) {
            coord = new Coord(x, y + 2);
        }
        if (Objects.equals(strCoord, "this")) {
            coord = new Coord(x, y);
        }
        if (Objects.equals(strCoord, "middleLeft")) {
            coord = new Coord(x, y - 1);
        }
        if (Objects.equals(strCoord, "middleRight")) {
            coord = new Coord(x, y + 1);
        }
        if (Objects.equals(strCoord, "bottomMiddle")) {
            coord = new Coord(x + 1, y);
        }
        if (Objects.equals(strCoord, "topMiddle")) {
            coord = new Coord(x - 1, y);
        }
        return coord;
    }
}
