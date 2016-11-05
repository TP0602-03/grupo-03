package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.rule.Rule;

import org.json.simple.JSONObject;

import java.lang.reflect.Constructor;

public class RuleParser {

    public Rule loadRule(JSONObject ruleJson) throws Exception {
        String ruleName = (String) ruleJson.get("name");
        Class ruleClass = Class.forName("ar.fiuba.tdd.tp.rule." + ruleName);
        Constructor constructor = ruleClass.getConstructor(JSONObject.class);
        Rule rule = (Rule) constructor.newInstance(ruleJson);
        return rule;
    }

}
