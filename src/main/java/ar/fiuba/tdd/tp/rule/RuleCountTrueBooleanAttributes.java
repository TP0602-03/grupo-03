package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.List;

public class RuleCountTrueBooleanAttributes extends Rule {

    private final List<String> attributes;
    private final String attributeValue;

    public RuleCountTrueBooleanAttributes(List<String> attributes, String attributeValue) {

        this.attributes = attributes;
        this.attributeValue = attributeValue;
    }

    @Override
    public boolean check(List<GraphVertex> vertices) {
        for (GraphVertex vertex : vertices) {
            if (vertex.hasAttribute(attributeValue)) {
                int total = getTrueBooleanAttributes(vertex);
                if (total != Integer.parseInt(vertex.getAttribute(attributeValue))) {
                    return false;
                }
            }
        }

        return true;
    }

    private int getTrueBooleanAttributes(GraphVertex vertex) {
        int total = 0;
        for (String attribute : attributes) {
            if (vertex.hasAttribute(attribute) && Boolean.parseBoolean(vertex.getAttribute(attribute))) {
                total++;
            }
        }
        return total;
    }
}
