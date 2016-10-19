package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GridGraph;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RuleCheckProductTest {
    Rule rule;

    @Before
    public void setUp() throws Exception {
        this.rule = new RuleCheckProduct("att", 10);
    }

    @Test
    public void test1() throws Exception {
        GridGraph graph = new GridGraph(3, 3);
        List vertices = new ArrayList<>();
        vertices.add(graph.getVertex(0, 0));
        vertices.add(graph.getVertex(0, 1));
        vertices.add(graph.getVertex(0, 2));
        graph.getVertex(0, 0).setAttribute("att", "2");
        graph.getVertex(0, 1).setAttribute("att", "5");
        graph.getVertex(0, 2).setAttribute("att", "1");
        assertTrue(rule.check(vertices));
    }

    @Test
    public void test2() throws Exception {
        GridGraph graph = new GridGraph(3, 3);
        List vertices = new ArrayList<>();
        vertices.add(graph.getVertex(1, 0));
        vertices.add(graph.getVertex(0, 1));
        vertices.add(graph.getVertex(1, 2));
        graph.getVertex(1, 0).setAttribute("att", "10");
        graph.getVertex(0, 1).setAttribute("att", "0");
        graph.getVertex(1, 2).setAttribute("att", "1");
        assertFalse(rule.check(vertices));
    }

    @Test
    public void test3() throws Exception {
        GridGraph graph = new GridGraph(3, 3);
        List vertices = new ArrayList<>();
        vertices.add(graph.getVertex(1, 0));
        vertices.add(graph.getVertex(0, 1));
        vertices.add(graph.getVertex(1, 2));
        graph.getVertex(1, 0).setAttribute("att", "1");
        /*TODO Si se comenta una de estas lineas, devuelve true aunque haya un
        vertice que no tenga ese atributo*/
        graph.getVertex(0, 1).setAttribute("att", "10");
        graph.getVertex(1, 2).setAttribute("att", "1");
        assertTrue(rule.check(vertices));
    }
}