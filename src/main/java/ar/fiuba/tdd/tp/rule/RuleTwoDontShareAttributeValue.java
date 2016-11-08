package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import org.json.simple.JSONObject;

import java.util.List;
import java.util.Objects;

public class RuleTwoDontShareAttributeValue extends Rule {
    private final String attribute;
    private final String value;

    public RuleTwoDontShareAttributeValue(String attribute, String value) {

        this.attribute = attribute;
        this.value = value;
    }

    public RuleTwoDontShareAttributeValue(JSONObject ruleJson) {
        this.attribute = (String) ruleJson.get("attribute");
        this.value = (String) ruleJson.get("value");
    }

    @Override
    public boolean check(List<GraphVertex> vertices) {
        System.out.println("v1: " + vertices.get(0).getAttribute("pos") + " : " + "lines -> " + vertices.get(0)
                .getAttribute("lines"));
        System.out.println("v2: " + vertices.get(1).getAttribute("pos") + " : " + "lines -> " + vertices.get(1)
                .getAttribute("lines"));
        if (vertices.get(0).hasAttribute(attribute) && Objects.equals(vertices.get(0).getAttribute(attribute), value)) {
            if (vertices.get(1).hasAttribute(attribute) && Objects.equals(vertices.get(1).getAttribute(attribute), value)) {
                return false;
            }
        }

        return true;
    }

}
