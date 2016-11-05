package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.graph.GridGraph;

public class RemoveEdgeAction extends Action {
    private String src;
    private String dst;

    public RemoveEdgeAction(String src, String dst) {
        this.src = src;
        this.dst = dst;
    }

    @Override
    public void run(GridGraph graph, int row, int col) {

        Coord targetCoord = parseCoord(row, col, this.dst);

        Coord sourceCoord = parseCoord(row, col, this.src);

        if (!graph.contains(sourceCoord) || !graph.contains(targetCoord)) {
            return;
        }

        GraphVertex dstVertex = graph.getVertex(targetCoord.getX(), targetCoord.getY());

        GraphVertex srcVertex = graph.getVertex(sourceCoord.getX(), sourceCoord.getY());

        if (srcVertex.isAdjacent(dstVertex)) {
            graph.removeEdge(sourceCoord, targetCoord);
        }
    }
}
