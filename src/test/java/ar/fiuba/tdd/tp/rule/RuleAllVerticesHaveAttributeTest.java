package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.graph.GridGraph;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class RuleAllVerticesHaveAttributeTest {

    private Rule rule;

    @Before
    public void setUp() throws Exception {
        this.rule = new RuleAllVerticesHaveAttribute("att");

    }

    @Test
    public void test1() throws Exception {
        GridGraph graph = new GridGraph(3, 3);
        graph.addEdge(new Coord(0, 2), new Coord(1, 1));
        graph.addEdge(new Coord(1, 1), new Coord(1, 2));
        graph.addEdge(new Coord(1, 2), new Coord(0, 2));
        List<GraphVertex> vertices = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                graph.getVertex(i, j).setAttribute("att", "val");
                vertices.add(graph.getVertex(i, j));
            }
        }
        assertTrue(rule.check(vertices));
    }

    @Test
    public void test2() throws Exception {
        GridGraph graph = new GridGraph(3, 3);
        graph.addEdge(new Coord(0, 2), new Coord(1, 1));
        graph.addEdge(new Coord(1, 1), new Coord(1, 2));
        graph.addEdge(new Coord(1, 2), new Coord(0, 2));
        List<GraphVertex> vertices = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i + j) % 2 == 0) {
                    graph.getVertex(i, j).setAttribute("att", "val");
                }

                vertices.add(graph.getVertex(i, j));
            }
        }
        assertFalse(rule.check(vertices));
    }
}