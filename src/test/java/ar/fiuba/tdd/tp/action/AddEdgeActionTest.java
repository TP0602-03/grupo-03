package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.graph.GridGraph;
import org.junit.Test;

public class AddEdgeActionTest {
    @Test
    public void name() throws Exception {
        AddEdgeAction action = new AddEdgeAction("bottomLeft", "topRight");
        GridGraph graph = new GridGraph(3, 3);
    }
}