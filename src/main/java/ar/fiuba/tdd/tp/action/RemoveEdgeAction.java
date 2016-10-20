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

        Coord dstCoord = parseCoord(row, col, this.dst);

        Coord srcCoord = parseCoord(row, col, this.src);

        if (!graph.contains(srcCoord) || !graph.contains(dstCoord)) {
            return;
        }

        GraphVertex dstVertex = graph.getVertex(dstCoord.getX(), dstCoord.getY());
        GraphVertex srcVertex = graph.getVertex(srcCoord.getX(), srcCoord.getY());

        //System.out.println("trying to remove edge");
        if (srcVertex.isAdjacent(dstVertex)) {
            //System.out.println("edge removed");
            graph.removeEdge(srcCoord, dstCoord);
        } else {
            //System.out.print("no edge to remove");
        }
    }
}
