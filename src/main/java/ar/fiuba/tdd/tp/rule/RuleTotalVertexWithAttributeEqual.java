package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.List;

public class RuleTotalVertexWithAttributeEqual extends Rule {

    private final String attribute;
    private final int expected;

    public RuleTotalVertexWithAttributeEqual(String attribute, int expected) {
        this.attribute = attribute;
        this.expected = expected;
    }

    @Override
    public boolean check(List<GraphVertex> vertices) {
        int count = 0;
        for (GraphVertex vertex :
                vertices) {
            if (vertex.hasAttribute(attribute)) {
                count += 1;
            }
        }
        //System.out.println(count);
        //System.out.println(expected);
        //System.out.println("Total vertices with attribute is " + ((count == expected) ? "OK" : "NOT OK"));
        return count == expected;
    }
}
