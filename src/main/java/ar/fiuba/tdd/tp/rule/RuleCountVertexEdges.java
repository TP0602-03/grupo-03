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

            if (vertex.getAttribute(this.attribute) != null) {
                Integer edgesAttribute = Integer.parseInt(vertex.getAttribute(this.attribute));
                int numAdjacent = vertex.getAdjacencyList().size();
                if (numAdjacent != edgesAttribute) {
                    return false;
                }
            }
        }
        return true;
    }
}
