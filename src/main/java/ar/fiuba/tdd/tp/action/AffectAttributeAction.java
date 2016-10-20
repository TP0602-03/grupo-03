package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.graph.GridGraph;

public class AffectAttributeAction extends Action {
    private String dst;
    private String attribute;
    private String value;

    public AffectAttributeAction(String dst, String attribute, String value) {
        this.dst = dst;
        this.attribute = attribute;
        this.value = value;
    }

    @Override
    public void run(GridGraph graph, int row, int col) {
        Coord dstCoord = parseCoord(row, col, dst);
        System.out.println("affecting attribute: " + this.attribute + "of cell " + dstCoord.getX() + " , " + dstCoord.getY());
        if (!graph.contains(dstCoord)) {
            System.out.println("*************out of range**************");
            return;
        }
        GraphVertex dstVertex = graph.getVertex(dstCoord.getX(), dstCoord.getY());
        dstVertex.setAttribute(attribute, value);
    }
}
