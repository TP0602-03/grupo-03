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

/**
 * Chequea que en los vertices recibidos sólo haya 2 aristas hacia vertices que no estan
 * en el conjunto recibido. O sea, que haya una "entrada" y una "salida"
 */
public class RuleOneEntryOneExitTest {
    private Rule rule;

    @Before
    public void setUp() throws Exception {
        this.rule = new RuleOneEntryOneExit();
    }

    @Test
    public void test1() throws Exception {
        GridGraph graph = new GridGraph(3, 3);
        graph.addEdge(new Coord(0, 0), new Coord(0, 1));
        graph.addEdge(new Coord(0, 1), new Coord(0, 2));
        graph.addEdge(new Coord(0, 2), new Coord(1, 2)); // "Entrada"
        graph.addEdge(new Coord(0, 1), new Coord(2, 2)); // "Salida"
        List<GraphVertex> vertices = new ArrayList<>();
        vertices.add(graph.getVertex(0, 0));
        vertices.add(graph.getVertex(0, 1));
        vertices.add(graph.getVertex(0, 2));
        assertTrue(rule.check(vertices));
    }

    @Test
    public void test2() throws Exception {
        GridGraph graph = new GridGraph(3, 3);
        graph.addEdge(new Coord(0, 0), new Coord(0, 1));
        graph.addEdge(new Coord(0, 1), new Coord(0, 2));
        graph.addEdge(new Coord(0, 2), new Coord(1, 2)); // "Entrada"
        graph.addEdge(new Coord(0, 1), new Coord(2, 2)); // "Salida"
        graph.addEdge(new Coord(0, 0), new Coord(1, 1)); // Otra "Entrada" o "Salida"
        List<GraphVertex> vertices = new ArrayList<>();
        vertices.add(graph.getVertex(0, 0));
        vertices.add(graph.getVertex(0, 1));
        vertices.add(graph.getVertex(0, 2));
        assertFalse(rule.check(vertices));
    }
}