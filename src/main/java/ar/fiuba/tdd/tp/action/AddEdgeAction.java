package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.graph.GridGraph;

public class AddEdgeAction extends Action {
    private String src;
    private String dst;

    public AddEdgeAction(String src, String dst) {
        //System.out.println("ADDED ADD EDGE ACTION");

        this.dst = dst;
        this.src = src;
    }

    private Boolean containsCoordenates(GridGraph graph, Coord srcCoordinates, Coord dstCoordinates) {

        if (!graph.contains(dstCoordinates)) {
            return false;
        }
        if (!graph.contains(srcCoordinates)) {
            return false;
        }
        return true;
    }

    @Override
    public void run(GridGraph graph, int row, int col) {
        Coord srcCoord = parseCoord(row, col, this.src);
        Coord dstCoord = parseCoord(row, col, this.dst);
        GraphVertex sourceVertex;
        GraphVertex targetVertex;

        if (!containsCoordenates(graph, srcCoord, dstCoord)) {
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
