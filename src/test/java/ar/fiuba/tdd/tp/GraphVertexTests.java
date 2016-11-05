package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.graph.GraphVertex;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GraphVertexTests {

    @Test
    public void newGraphVertexHasEmptyAdjacencyList() {
        GraphVertex vertex = new GraphVertex();
        assert (vertex.getAdjacencyList().isEmpty());
    }

    @Test
    public void graphVertexGetMissingAttributeReturnsNull() {
        GraphVertex vertex = new GraphVertex();
        Object attribute = vertex.getAttribute("missing");
        assertEquals(null, attribute);
    }

    @Test
    public void graphVertexHasAddedAttribute() {
        GraphVertex vertex = new GraphVertex();
        vertex.setAttribute("number", "7");
        assert (vertex.hasAttribute("number"));
    }

    @Test
    public void graphVertexGetAttribute() {
        GraphVertex vertex = new GraphVertex();
        vertex.setAttribute("number", "7");
        assertEquals(vertex.getAttribute("number"), "7");
    }

    @Test
    public void graphVertexRemoveAttribute() {
        GraphVertex vertex = new GraphVertex();
        vertex.setAttribute("number", "7");
        vertex.removeAttribute("number");
        assertFalse(vertex.hasAttribute("number"));
    }

    @Test
    public void graphVertexAddEdge() {
        GraphVertex vertex = new GraphVertex();
        GraphVertex neighbour = new GraphVertex();
        vertex.addEdge(neighbour);
        List<GraphVertex> list = vertex.getAdjacencyList();
        assert (list.contains(neighbour));
    }

    @Test
    public void graphVertex() {
        GraphVertex vertex = new GraphVertex();
        vertex.setAttribute("number", "1");
        vertex.setAttribute("color", "white");
        Set<Map.Entry<String, String>> setKV = vertex.getKeysValues();
        for (Map.Entry<String, String> entry : setKV) {
            if (Objects.equals(entry.getKey(), "number")) {
                assertEquals(entry.getValue(), "1");
            }
        }
    }
}
