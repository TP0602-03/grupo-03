package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import org.json.simple.JSONObject;

import java.util.List;
import java.util.Objects;

public class RuleTotalVertexWithAttributeEqual extends Rule {

    private String attribute;
    private int expected;

    public RuleTotalVertexWithAttributeEqual(String attribute, int expected) {
        this.attribute = attribute;
        this.expected = expected;
    }

    public RuleTotalVertexWithAttributeEqual(JSONObject ruleJson) {
        this((String) ruleJson.get("attribute"), ((Long) ruleJson.get("value")).intValue());
    }

    @Override
    public boolean check(List<GraphVertex> vertices) {
        int count = 0;
        for (GraphVertex vertex :
                vertices) {
            if (vertex.hasAttribute(attribute) && !Objects.equals(vertex.getAttribute(attribute), "")) {
                count += 1;
            }
        }
        return count == expected;
    }

    private static class GetExpectedValue {
        private JSONObject ruleJson;
        private String firstAttribute;
        private int exp;

        public GetExpectedValue(JSONObject ruleJson) {
            this.ruleJson = ruleJson;
        }

        public String getFirstAttribute() {
            return firstAttribute;
        }

        public int getExpected() {
            return exp;
        }

        public RuleTotalVertexWithAttributeEqual.GetExpectedValue invoke() {
            firstAttribute = (String) ruleJson.get("attribute");
            exp = ((Long) ruleJson.get("expected")).intValue();
            return this;
        }
    }
}
