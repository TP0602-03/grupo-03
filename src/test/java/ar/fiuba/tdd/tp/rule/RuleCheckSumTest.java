package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.graph.GridGraph;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RuleCheckSumTest {

    private Rule rule;

    @Before
    public void setUp() throws Exception {
        this.rule = new RuleCheckSum("att", 10);
    }

    @Test
    public void test1() throws Exception {
        GridGraph graph = new GridGraph(3, 3);
        List<GraphVertex> vertices = new ArrayList<>();
        vertices.add(graph.getVertex(0, 0));
        vertices.add(graph.getVertex(0, 1));
        vertices.add(graph.getVertex(0, 2));
        graph.getVertex(0, 0).setAttribute("att", 2);
        graph.getVertex(0, 1).setAttribute("att", 5);
        graph.getVertex(0, 2).setAttribute("att", 1);
        assertFalse(rule.check(vertices));
    }

    @Test
    public void test2() throws Exception {
        GridGraph graph = new GridGraph(3, 3);
        List<GraphVertex> vertices = new ArrayList<>();
        vertices.add(graph.getVertex(1, 0));
        vertices.add(graph.getVertex(0, 1));
        vertices.add(graph.getVertex(1, 2));
        graph.getVertex(1, 0).setAttribute("att", 1);
        graph.getVertex(0, 1).setAttribute("att", 6);
        graph.getVertex(1, 2).setAttribute("att", 3);
        assertTrue(rule.check(vertices));
    }

    @Test
    public void test3() throws Exception {
        GridGraph graph = new GridGraph(3, 3);
        List<GraphVertex> vertices = new ArrayList<>();
        vertices.add(graph.getVertex(1, 0));
        vertices.add(graph.getVertex(0, 1));
        vertices.add(graph.getVertex(1, 2));
        graph.getVertex(1, 0).setAttribute("att", null);
        graph.getVertex(0, 1).setAttribute("att", 10);
        graph.getVertex(1, 2).setAttribute("att", 1);
        assertFalse(rule.check(vertices));
    }

}