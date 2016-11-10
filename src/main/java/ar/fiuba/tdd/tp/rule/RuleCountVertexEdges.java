package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import org.json.simple.JSONObject;

import java.util.List;

public class RuleCountVertexEdges extends Rule {
    private String attribute;

    public RuleCountVertexEdges(String attribute) {
        this.attribute = attribute;
    }

    public RuleCountVertexEdges(JSONObject ruleJson) {
        this((String) ruleJson.get("attribute"));
    }

    @Override
    public boolean check(List<GraphVertex> vertices) {

        for (GraphVertex vertex :
                vertices) {

            if (vertex.getAttribute(attribute) != null) {
                Integer edgesAttribute = Integer.parseInt(vertex.getAttribute(attribute));
                int numAdjacent = vertex.getAdjacencyList().size();
                if (numAdjacent != edgesAttribute) {
                    return false;
                }
            }
        }
        return true;
    }
}
