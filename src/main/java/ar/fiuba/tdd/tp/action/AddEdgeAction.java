package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.graph.GridGraph;

public class AddEdgeAction extends Action {
    private String src;
    private String dst;

    public AddEdgeAction(String src, String dst) {
        System.out.println("ADDED ADD EDGE ACTION");
        this.src = src;
        this.dst = dst;
    }

    @Override
    public void run(GridGraph graph, int row, int col) {
        Coord srcCoord = parseCoord(row, col, this.src);
        Coord dstCoord = parseCoord(row, col, this.dst);

        System.out.println("ADDED EDGE BETWEEN 1");

        if (!graph.contains(dstCoord) || !graph.contains(srcCoord)) {
            return;
        }

        System.out.println("ADDED EDGE BETWEEN 2");
        GraphVertex srcVertex = graph.getVertex(srcCoord.getX(), srcCoord.getY());
        GraphVertex dstVertex = graph.getVertex(dstCoord.getX(), dstCoord.getY());

        System.out.println("ADDED EDGE BETWEEN 3");
        if (srcVertex.isAdjacent(dstVertex)) {
            return;
        }

        System.out.println("ADDED EDGE BETWEEN 4");
        srcVertex.print();
        dstVertex.print();

        graph.addEdge(srcCoord, dstCoord);
    }


}
