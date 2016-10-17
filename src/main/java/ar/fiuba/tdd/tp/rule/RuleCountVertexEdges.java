package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.List;

public class RuleCountVertexEdges extends Rule {
    private String attribute;

    public RuleCountVertexEdges(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public boolean check(List<GraphVertex> vertices) {
        for (GraphVertex vertex :
                vertices) {
            if ((Integer) vertex.getAttribute(attribute) != null && vertex.getAdjacencyList().size() != (Integer) vertex.getAttribute(attribute)) {
                return false;
            }
        }
        return true;
    }
}
