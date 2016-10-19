package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class Region {
    private List<Rule> rules = new ArrayList<Rule>();
    private List<GraphVertex> vertices = new ArrayList<>();

    public void addVertex(GraphVertex vertex) {
        vertices.add(vertex);
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public boolean validate() {
        boolean result = false;
        // System.out.println("rules: " +  rules.size());
        for (Rule rule :
                rules) {
//          System.out.println("rule: " + rule);
            result = rule.check(vertices);

            System.out.println("rule: " + rule.getClass() + " result: " + result);
            if (!result) {
                return false;
            }
        }
        return true;
    }
}
