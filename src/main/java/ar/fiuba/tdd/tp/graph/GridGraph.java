package ar.fiuba.tdd.tp.graph;

import java.util.ArrayList;
import java.util.List;

public class GridGraph {
    protected List<List<GraphVertex>> vertices = new ArrayList<>();

    public GridGraph(Integer width, Integer height) {
        for (int row = 0; row < height; row++) {
            vertices.add(new ArrayList<>());
        }

        for (int row = 0; row < height; row++) {
            List<GraphVertex> newRow = vertices.get(row);
            for (int column = 0; column < width; column++) {
                GraphVertex vertex = new GraphVertex();
                vertex.setAttribute("pos", "(" + Integer.toString(row) + "," + Integer.toString(column) + ")");
                newRow.add(vertex);
            }
        }
    }

    public GraphVertex getVertex(int row, int column) {
        return vertices.get(row).get(column);
    }

    public void addEdge(Coord nodeA, Coord nodeB) {
        int nodeACoordinateX = nodeA.getCoordinateX();
        int nodeACoordinateY = nodeA.getCoordinateY();
        int nodeBCoordinateX = nodeB.getCoordinateX();
        int nodeBCoordinateY = nodeB.getCoordinateY();
        vertices.get(nodeACoordinateX).get(nodeACoordinateY).addEdge(vertices.get(nodeBCoordinateX).get(nodeBCoordinateY));
        vertices.get(nodeBCoordinateX).get(nodeBCoordinateY).addEdge(vertices.get(nodeACoordinateX).get(nodeACoordinateY));
    }
}
