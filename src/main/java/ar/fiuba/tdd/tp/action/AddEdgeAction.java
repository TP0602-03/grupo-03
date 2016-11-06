package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.graph.GridGraph;

public class AddEdgeAction extends Action {
    private String src;
    private String dst;

    public AddEdgeAction(String src, String dst) {
        this.dst = dst;
        this.src = src;
    }

    private Boolean containsCoordinates(GridGraph graph, Coord srcCoordinates, Coord dstCoordinates) {
        return graph.contains(dstCoordinates) && graph.contains(srcCoordinates);
    }

    @Override
    public void run(GridGraph graph, int row, int col) {
        Coord srcCoord = parseCoord(row, col, this.src);
        Coord dstCoord = parseCoord(row, col, this.dst);
        GraphVertex sourceVertex;
        GraphVertex targetVertex;

        if (!containsCoordinates(graph, srcCoord, dstCoord)) {
            return;
        }

        sourceVertex = graph.getVertex(srcCoord.getX(), srcCoord.getY());
        targetVertex = graph.getVertex(dstCoord.getX(), dstCoord.getY());

        if (sourceVertex.isAdjacent(targetVertex)) {
            return;
        }

        graph.addEdge(srcCoord, dstCoord);
    }

}
