package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.rule.*;
import org.json.simple.JSONObject;

import java.util.Objects;

public class RuleParser {
    public Rule loadRule(JSONObject ruleJson) {

        Rule rule = null;
        String ruleName = (String) ruleJson.get("name");
        if (Objects.equals(ruleName, "RuleCheckSum")) {
            String att = (String) ruleJson.get("attribute");
            int exp = ((Long) ruleJson.get("expected")).intValue();
            rule = new RuleCheckSum(att, exp);
        } else if (Objects.equals(ruleName, "RuleCheckProduct")) {
            String att = (String) ruleJson.get("attribute");
            int exp = ((Long) ruleJson.get("expected")).intValue();
            rule = new RuleCheckProduct(att, exp);
        } else if (Objects.equals(ruleName, "RuleDistinctValues")) {
            String att = (String) ruleJson.get("attribute");
            rule = new RuleDistinctElements(att);
        } else if (Objects.equals(ruleName, "RuleCountVertexEdges")) {
            String att = (String) ruleJson.get("attribute");
            rule = new RuleCountVertexEdges(att);
        } else if (Objects.equals(ruleName, "RuleGraphHasNoCycles")) {
            rule = new RuleGraphHasNoCycles();
        } else if (Objects.equals(ruleName, "RuleGraphHasOneCycle")) {
            rule = new RuleGraphHasOneCycle();
        } else if (Objects.equals(ruleName, "RuleAllVerticesHaveAttribute")) {
            String att = (String) ruleJson.get("attribute");
            rule = new RuleAllVerticesHaveAttribute(att);
        }
        return rule;
    }
}
