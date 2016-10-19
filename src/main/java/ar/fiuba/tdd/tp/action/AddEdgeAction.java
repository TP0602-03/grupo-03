package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.graph.GridGraph;

public class AddEdgeAction extends Action {
    private String src;
    private String dst;

    public AddEdgeAction(String src, String dst) {
        this.src = src;
        this.dst = dst;
    }

    @Override
    public void run(GridGraph graph, int row, int col) {
        Coord srcCoord = parseCoord(row, col, this.src);
        Coord dstCoord = parseCoord(row, col, this.dst);


        if (!graph.contains(dstCoord) || !graph.contains(srcCoord)) {
            return;
        }

        GraphVertex srcVertex = graph.getVertex(srcCoord.getX(), srcCoord.getY());
        GraphVertex dstVertex = graph.getVertex(dstCoord.getX(), dstCoord.getY());
        if (srcVertex.isAdjacent(dstVertex)) {
            return;
        }

        graph.addEdge(srcCoord, dstCoord);
    }


}
