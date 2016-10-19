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
        Coord srcCoord = parseCoord(row, col, this.src);
        Coord dstCoord = parseCoord(row, col, this.dst);
        if (!withinGraph(graph, dstCoord)) {
            return;
        }

        if (!withinGraph(graph, srcCoord)) {
            return;
        }
        GraphVertex srcVertex = graph.getVertex(srcCoord.getX(), srcCoord.getY());
        GraphVertex dstVertex = graph.getVertex(dstCoord.getX(), dstCoord.getY());
        if (srcVertex.isAdjacent(dstVertex)) {
            graph.removeEdge(srcCoord, dstCoord);
        }
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
}
