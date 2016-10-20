package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.rule.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RuleParser {





    private Rule getRuleDistinctValues(JSONObject ruleJson) {
        String attrib2 = (String) ruleJson.get("attribute");
        return new RuleDistinctElements(attrib2);
    }


    private Rule getRuleGraphHasNoCycles() {
        return new RuleGraphHasNoCycles();
    }

    private Rule getRuleCheckSum(JSONObject ruleJson) {
        String attrib1 = (String) ruleJson.get("attribute");
        int exp = ((Long) ruleJson.get("expected")).intValue();
        return new RuleCheckSum(attrib1, exp);
    }

    private Rule getRuleGraphHasOneCycle() {
        return new RuleGraphHasOneCycle();
    }

    private Rule getRuleCountSetAttributes(JSONObject ruleJson) {
        String att = (String) ruleJson.get("attribute");
        JSONArray attListJson = (JSONArray) ruleJson.get("attributes");
        List<String> attList = new ArrayList<>();
        for (Object obj :
                attListJson) {
            String attribute = (String) obj;
            attList.add(attribute);
        }
        return new RuleCountSetAttributes(attList, att);
    }



    private Rule getRuleRuleTotalVertexWithAttributeEqual(JSONObject ruleJson) {
        String att4 = (String) ruleJson.get("attribute");
        int total = ((Long) ruleJson.get("value")).intValue();
        return new RuleTotalVertexWithAttributeEqual(att4, total);
    }

    private Rule getRuleOneEntryOneExit() {
        return new RuleOneEntryOneExit();
    }


    private Rule getRuleCheckProduct(JSONObject ruleJson) {
        String att = (String) ruleJson.get("attribute");
        int exp = ((Long) ruleJson.get("expected")).intValue();
        return new RuleCheckProduct(att, exp);
    }

    private Rule getRuleAllVertexHaveAttribute(JSONObject ruleJson) {
        String att0 = (String) ruleJson.get("attribute");
        return new RuleAllVerticesHaveAttribute(att0);
    }


    public Rule loadRule(JSONObject ruleJson) {
        String ruleName = (String) ruleJson.get("name");
        Rule rule = null;

        switch (ruleName) {
            case "RuleCheckSum":
                rule = this.getRuleCheckSum(ruleJson);
                break;
            case "RuleCheckProduct":
                rule = this.getRuleCheckProduct(ruleJson);
                break;
            case "RuleDistinctValues":
                rule = this.getRuleDistinctValues(ruleJson);
                break;
            case "RuleCountVertexEdges":
                rule = this.getRuleCountVertexEdges(ruleJson);
                break;
            case "RuleGraphHasNoCycles":
                rule = this.getRuleGraphHasNoCycles();
                break;
            case "RuleGraphHasOneCycle":
                rule = this.getRuleGraphHasOneCycle();
                break;
            case "RuleAllVerticesHaveAttribute":
                rule = this.getRuleAllVertexHaveAttribute(ruleJson);
                break;
            case "RuleCountSetAttributes":
                rule = this.getRuleCountSetAttributes(ruleJson);
                break;
            case "RuleTotalVertexWithAttributeEqual":
                rule = this.getRuleRuleTotalVertexWithAttributeEqual(ruleJson);
                break;
            case "RuleOneEntryOneExit":
                rule = this.getRuleOneEntryOneExit();
                break;
            default:
                break;


        }
        return rule;
    }

    private Rule getRuleCountVertexEdges(JSONObject ruleJson) {
        String att7 = (String) ruleJson.get("attribute");
        return new RuleCountVertexEdges(att7);
    }
}
