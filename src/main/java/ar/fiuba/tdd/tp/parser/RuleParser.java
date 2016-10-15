package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.rule.Rule;
import ar.fiuba.tdd.tp.rule.RuleCheckSum;
import ar.fiuba.tdd.tp.rule.RuleDistinctElements;
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
        } else if (Objects.equals(ruleName, "RuleDistinctValues")) {
            String att = (String) ruleJson.get("attribute");
            rule = new RuleDistinctElements(att);
        }
        return rule;
    }
}
