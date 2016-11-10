package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleDistinctValues extends Rule {
    private String attribute;

    public RuleDistinctValues(String attribute) {

        this.attribute = attribute;
    }

    public RuleDistinctValues(JSONObject ruleJson) {
        attribute = (String) ruleJson.get("attribute");
    }

    @Override
    public boolean check(List<GraphVertex> vertices) {
        Map<Object, Integer> map = new HashMap<>();
        for (GraphVertex vertex :
                vertices) {
            map.put(vertex.getAttribute(attribute), 1);
        }

        return map.size() == vertices.size();
    }
}
