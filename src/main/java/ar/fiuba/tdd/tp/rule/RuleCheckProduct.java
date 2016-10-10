package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.List;

public class RuleCheckProduct extends Rule {
    private String attribute;
    private Integer expected;

    public RuleCheckProduct(String attribute, Integer expected) {
        this.attribute = attribute;
        this.expected = expected;
    }


    @Override
    public boolean check(List<GraphVertex> vertices) {
        Integer total = 1;
        for (GraphVertex vertex :
                vertices) {
            Integer num = (Integer) vertex.getAttribute(attribute);
            total *= num;
        }
        return total.intValue() == expected.intValue();
    }
}
