package ar.fiuba.tdd.tp.graph;

import java.util.ArrayList;
import java.util.List;

public class GridGraph {
    protected List<List<GraphVertex>> vertices = new ArrayList<>();
    private Integer width;
    private Integer height;

    public GridGraph(Integer width, Integer height) {
        this.width = width;
        this.height = height;
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

    public GraphVertex getVertex(Coord coord) {
        return getVertex(coord.getX(), coord.getY());
    }

    public void addEdge(Coord nodeA, Coord nodeB) {
        GraphVertex vertexA = getVertex(nodeA);
        GraphVertex vertexB = getVertex(nodeB);
        vertexA.addEdge(vertexB);
        vertexB.addEdge(vertexA);
    }

    public void removeEdge(Coord nodeA, Coord nodeB) {
        GraphVertex vertexA = getVertex(nodeA);
        GraphVertex vertexB = getVertex(nodeB);
        vertexA.removeEdge(vertexB);
        vertexB.removeEdge(vertexA);
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public void clearEdges() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                getVertex(i, j).clearEdges();
            }
        }
    }

    public boolean contains(Coord node) {
        if (node.getX() < 0 || node.getX() >= height) {
            return false;
        }
        return !(node.getY() < 0 || node.getY() >= width);
    }
}
