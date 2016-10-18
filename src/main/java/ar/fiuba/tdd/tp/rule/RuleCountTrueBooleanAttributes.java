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
        for (GraphVertex vertex :
                vertices) {
            if (vertex.hasAttribute(attributeValue)) {
                int total = 0;
                for (String attribute :
                        attributes) {
                    if (vertex.hasAttribute(attribute) && (Boolean) vertex.getAttribute(attribute)) {
                        total++;
                    }
                }
                if (total != (Integer) vertex.getAttribute(attributeValue)) {
                    return false;
                }
            }
        }

        return true;
    }
}
