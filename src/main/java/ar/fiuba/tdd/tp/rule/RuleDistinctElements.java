package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleDistinctElements extends Rule {
    private String attribute;

    public RuleDistinctElements(String attribute) {

        this.attribute = attribute;
    }

    @Override
    public boolean check(List<GraphVertex> vertices) {
        Map<Object, Integer> map = new HashMap<>();
        for (GraphVertex vertex :
                vertices) {
            map.put(vertex.getAttribute(attribute), 1);
            System.out.println("attribute is:" + attribute + "  val: " + vertex.getAttribute(attribute));
        }

        return map.size() == vertices.size();
    }
}
