package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.graph.GridGraph;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RuleCountVertexEdgesTest {
    private Rule rule;

    @Before
    public void setUp() throws Exception {
        this.rule = new RuleCountVertexEdges("max_edges");
    }

    @Test
    public void test1() throws Exception {
        GridGraph graph = new GridGraph(3, 3);
        graph.getVertex(0, 0).setAttribute("max_edges", "1");
        graph.getVertex(0, 1).setAttribute("max_edges", "2");
        graph.getVertex(0, 2).setAttribute("max_edges", "1");
        graph.addEdge(new Coord(0, 0), new Coord(0, 1));
        graph.addEdge(new Coord(0, 2), new Coord(0, 1));
        List<GraphVertex> vertices = new ArrayList<>();
        vertices.add(graph.getVertex(0, 0));
        vertices.add(graph.getVertex(0, 1));
        vertices.add(graph.getVertex(0, 2));
        assertTrue(rule.check(vertices));
    }

    @Test
    public void test2() throws Exception {
        GridGraph graph = new GridGraph(3, 3);
        graph.getVertex(0, 0).setAttribute("max_edges", "1");
        graph.getVertex(0, 1).setAttribute("max_edges", "1");
        graph.getVertex(0, 2).setAttribute("max_edges", "0");
        graph.addEdge(new Coord(0, 0), new Coord(0, 1));
        graph.addEdge(new Coord(0, 2), new Coord(0, 1));
        List<GraphVertex> vertices = new ArrayList<>();
        vertices.add(graph.getVertex(0, 0));
        vertices.add(graph.getVertex(0, 1));
        vertices.add(graph.getVertex(0, 2));
        assertFalse(rule.check(vertices));
    }


    @Test
    public void test3() throws Exception {
        GridGraph graph = new GridGraph(3, 3);
        graph.getVertex(0, 0).setAttribute("max_edges", "1");
        graph.getVertex(0, 1).setAttribute("max_edges", "1");
        graph.getVertex(0, 2).setAttribute("max_edges", "0");
        graph.addEdge(new Coord(0, 0), new Coord(0, 1));
        List<GraphVertex> vertices = new ArrayList<>();
        vertices.add(graph.getVertex(0, 0));
        vertices.add(graph.getVertex(0, 1));
        vertices.add(graph.getVertex(0, 2));
        assertTrue(rule.check(vertices));
    }
}