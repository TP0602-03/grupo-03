package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GridGraph;

public class AffectAttributeAction extends Action {
    private String dst;
    private String attribute;
    private Object value;

    public AffectAttributeAction(String dst, String attribute, Object value) {
        this.dst = dst;
        this.attribute = attribute;
        this.value = value;
    }

    @Override
    public void run(GridGraph graph, int x, int y) {
        Coord dstCoord = parseCoord(x, y, dst);
        if (dstCoord.getCoordinateX() < 0 || dstCoord.getCoordinateX() >= graph.getHeight()) {
            return;
        }
        if (dstCoord.getCoordinateY() < 0 || dstCoord.getCoordinateY() >= graph.getWidth()) {
            return;
        }
        graph.getVertex(dstCoord.getCoordinateX(), dstCoord.getCoordinateY()).setAttribute(attribute, value);
    }
}
