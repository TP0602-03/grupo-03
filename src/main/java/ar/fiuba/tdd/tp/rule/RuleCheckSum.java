package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.List;

public class RuleCheckSum extends Rule {
    private String attribute;
    private Integer expected;

    public RuleCheckSum(String attribute, Integer expected) {
        this.attribute = attribute;
        this.expected = expected;
    }


    @Override
    public boolean check(List<GraphVertex> vertices) {
        Integer total = 0;

        for (GraphVertex vertex :
                vertices) {
            if (vertex.getAttribute(attribute) != null) {
                Integer num = Integer.parseInt(vertex.getAttribute(attribute));
                total += num;
            } else if (total >= expected) {
                return false;
            }

        }
        return total.intValue() == expected.intValue();
    }
}
