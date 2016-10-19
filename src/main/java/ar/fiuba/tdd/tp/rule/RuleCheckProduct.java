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
            Integer num = Integer.parseInt(vertex.getAttribute(attribute));
            if (num != null) {
                total *= num;
            } else if (total >= expected) {
                return false;
            }
        }
        return total.intValue() == expected.intValue();
    }
}
