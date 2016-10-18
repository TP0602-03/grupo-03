package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GridGraph;

public class AddEdgeAction extends Action {
    private String src;
    private String dst;

    public AddEdgeAction(String src, String dst) {
        this.src = src;
        this.dst = dst;
    }

    @Override
    public void run(GridGraph graph, int x, int y) {
        Coord srcCoord = parseCoord(x, y, this.src);
        Coord dstCoord = parseCoord(x, y, this.dst);
        System.out.println("dstCoord = " + dstCoord.getCoordinateX());
        System.out.println("dstCoord = " + dstCoord.getCoordinateY());
        System.out.println("srcCoord = " + srcCoord.getCoordinateX());
        System.out.println("srcCoord = " + srcCoord.getCoordinateY());
        if (dstCoord.getCoordinateX() < 0 || dstCoord.getCoordinateX() >= graph.getHeight()) {
            return;
        }
        if (dstCoord.getCoordinateY() < 0 || dstCoord.getCoordinateY() >= graph.getWidth()) {
            return;
        }

        if (srcCoord.getCoordinateX() < 0 || srcCoord.getCoordinateX() >= graph.getHeight()) {
            return;
        }
        if (srcCoord.getCoordinateY() < 0 || srcCoord.getCoordinateY() >= graph.getWidth()) {
            return;
        }
        graph.addEdge(srcCoord, dstCoord);
    }
}
