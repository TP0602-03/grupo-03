package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.List;

public class RuleAllVerticesHaveAttribute extends Rule {

    private String attribute;

    public RuleAllVerticesHaveAttribute(String attribute) {

        this.attribute = attribute;
    }


    @Override
    public boolean check(List<GraphVertex> vertices) {
        for (GraphVertex vertex :
                vertices) {
            if (!vertex.hasAttribute(attribute)) {
                return false;
            }
        }
        return true;
    }
}
