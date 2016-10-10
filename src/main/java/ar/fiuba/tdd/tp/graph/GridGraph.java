package ar.fiuba.tdd.tp.graph;

import java.util.ArrayList;
import java.util.List;

public class GridGraph {
    protected List<List<GraphVertex>> vertices = new ArrayList<>();

    public GridGraph(Integer width, Integer height) {
        for (int i = 0; i < height; i++) {
            vertices.add(new ArrayList<>());
        }

        for (int i = 0; i < height; i++) {
            List<GraphVertex> row = vertices.get(i);
            for (int j = 0; j < width; j++) {
                GraphVertex v = new GraphVertex();
                v.setAttribute("pos", "(" + Integer.toString(i) + "," + Integer.toString(j) + ")");
                row.add(v);
            }
        }
    }

    public GraphVertex getVertex(int i, int j) {
        return vertices.get(i).get(j);
    }

    public void addEdge(Coord nodeA, Coord nodeB) {
        int i = nodeA.getX();
        int j = nodeA.getY();
        int k = nodeB.getX();
        int l = nodeB.getY();
        vertices.get(i).get(j).addEdge(vertices.get(k).get(l));
        vertices.get(k).get(l).addEdge(vertices.get(i).get(j));
    }
}
