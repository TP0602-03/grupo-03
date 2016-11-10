package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import org.json.simple.JSONObject;

import java.util.List;
import java.util.Objects;

public class RuleGraphAdjacentDontShareAttributeValue extends Rule {
    private String attribute;
    private String value;

    public RuleGraphAdjacentDontShareAttributeValue(String attribute, String value) {

        this.attribute = attribute;
        this.value = value;
    }

    public RuleGraphAdjacentDontShareAttributeValue(JSONObject ruleJson) {
        attribute = (String) ruleJson.get("attribute");
        value = (String) ruleJson.get("value");
    }

    @Override
    public boolean check(List<GraphVertex> vertices) {
        for (GraphVertex vertex : vertices) {
            List<GraphVertex> adjList = vertex.getAdjacencyList();
            for (GraphVertex adj : adjList) {
                if (vertex.hasAttribute(attribute) && Objects.equals(vertex.getAttribute(attribute), value)) {
                    if (adj.hasAttribute(attribute) && Objects.equals(adj.getAttribute(attribute), value)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
