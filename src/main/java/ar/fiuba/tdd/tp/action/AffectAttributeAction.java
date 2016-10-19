package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GraphVertex;
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

    private boolean withinGraph(GridGraph graph, Coord dstCoord) {
        if (dstCoord.getX() < 0 || dstCoord.getX() >= graph.getHeight()) {
            return false;
        }
        if (dstCoord.getY() < 0 || dstCoord.getY() >= graph.getWidth()) {
            return false;
        }
        return true;
    }

    @Override
    public void run(GridGraph graph, int row, int col) {
        Coord dstCoord = parseCoord(row, col, dst);
        if (!withinGraph(graph, dstCoord)) {
            return;
        }
        GraphVertex dstVertex = graph.getVertex(dstCoord.getX(), dstCoord.getY());
        dstVertex.setAttribute(attribute, value);
    }
}
