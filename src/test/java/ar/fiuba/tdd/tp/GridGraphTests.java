package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.graph.GridGraph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridGraphTests {

    @Test
    public void gridGraphGetVertex() {
        GridGraph grid = new GridGraph(9, 9);
        GraphVertex vertex = grid.getVertex(1, 1);
        assertEquals(grid.getVertex(1, 1), vertex);
    }

    @Test(expected = java.lang.IndexOutOfBoundsException.class)
    public void gridGraphGetMissingVertexReturnsIndexOutOfBoundsException() {
        GridGraph grid = new GridGraph(9, 9);
        assertEquals(grid.getVertex(10, 10), null);
    }

    @Test
    public void gridGraphAddEdge() {
        GridGraph grid = new GridGraph(3, 3);
        Coord c1 = new Coord(1, 1);
        Coord c2 = new Coord(2, 2);
        grid.addEdge(c1, c2);
        GraphVertex vertex = grid.getVertex(1, 1);
        GraphVertex vertex2 = grid.getVertex(2, 2);
        assert (vertex.getAdjacencyList().contains(vertex2));
    }
}
