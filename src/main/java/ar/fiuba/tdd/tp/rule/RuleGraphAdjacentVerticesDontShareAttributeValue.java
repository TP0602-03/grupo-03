package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.List;
import java.util.Objects;

public class RuleGraphAdjacentVerticesDontShareAttributeValue extends Rule {
    private final String attribute;
    private final String value;

    public RuleGraphAdjacentVerticesDontShareAttributeValue(String attribute, String value) {

        this.attribute = attribute;
        this.value = value;
    }

    @Override
    public boolean check(List<GraphVertex> vertices) {
        for (GraphVertex vertex : vertices) {
            List<GraphVertex> adjList = vertex.getAdjacencyList();
            for (GraphVertex adj : adjList) {
                if (vertex.hasAttribute(attribute) && Objects.equals(vertex.getAttribute(attribute), value) && adj.hasAttribute(attribute) && Objects.equals(adj.getAttribute(attribute), value)) {
                    System.out.println("vertices share attribute value");
                    vertex.print();
                    adj.print();
                    return false;
                }
            }
        }
        return true;
    }
}
