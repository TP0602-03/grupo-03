package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import org.json.simple.JSONObject;

import java.util.List;

public class RuleAllVerticesHaveAttribute extends Rule {
    private String attribute;

    public RuleAllVerticesHaveAttribute() {
    }

    public RuleAllVerticesHaveAttribute(String attribute) {

        this.attribute = attribute;
    }

    public RuleAllVerticesHaveAttribute(JSONObject ruleJson) {
        attribute = (String) ruleJson.get("attribute");
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
