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

    public void addEdge(Coord nodeA, Coord nodeB) {
        int nodeACoordinateX = nodeA.getX();
        int nodeACoordinateY = nodeA.getY();
        int nodeBCoordinateX = nodeB.getX();
        int nodeBCoordinateY = nodeB.getY();
        vertices.get(nodeACoordinateX).get(nodeACoordinateY).addEdge(vertices.get(nodeBCoordinateX).get(nodeBCoordinateY));
        vertices.get(nodeBCoordinateX).get(nodeBCoordinateY).addEdge(vertices.get(nodeACoordinateX).get(nodeACoordinateY));
    }

    public void removeEdge(Coord src, Coord dst) {
        int nodeACoordinateX = src.getX();
        int nodeACoordinateY = src.getY();
        int nodeBCoordinateX = dst.getX();
        int nodeBCoordinateY = dst.getY();
        vertices.get(nodeACoordinateX).get(nodeACoordinateY).removeEdge(vertices.get(nodeBCoordinateX).get(nodeBCoordinateY));
        vertices.get(nodeBCoordinateX).get(nodeBCoordinateY).removeEdge(vertices.get(nodeACoordinateX).get(nodeACoordinateY));
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
                vertices.get(i).get(j).clearEdges();
            }
        }
    }

    public boolean contains(Coord dstCoord) {
        if (dstCoord.getX() < 0 || dstCoord.getX() >= height) {
            return false;
        }
        return !(dstCoord.getY() < 0 || dstCoord.getY() >= width);
    }
}
