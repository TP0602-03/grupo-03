package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.List;
import java.util.Objects;

public class RuleCountVertWithAttributeValue extends Rule {

    private final String attribute;
    private final String value;
    private int expected;

    public RuleCountVertWithAttributeValue(String attribute, String value, int expected) {

        this.attribute = attribute;
        this.value = value;
        this.expected = expected;
    }


    @Override
    public boolean check(List<GraphVertex> vertices) {
        int count = 0;
        for (GraphVertex vertex :
                vertices) {
            if (vertex.hasAttribute(attribute) && Objects.equals(vertex.getAttribute(attribute), value)) {
                count += 1;
            }
        }
        return count == expected;
    }
}
