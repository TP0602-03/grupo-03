package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.List;
import java.util.Map;

public class RuleCheckSum extends Rule {
    private String attribute;
    private Integer expected;

    public RuleCheckSum(String attribute, Integer expected) {
        this.attribute = attribute;
        this.expected = expected;
    }


    @Override
    public boolean check(List<GraphVertex> vertices) {
        Integer total = 0;

        System.out.println("RULE HAS VERTICES: " + vertices.size());
        for (GraphVertex vertex :
                vertices) {
            System.out.println("NOW:");
            vertex.print();

            for (Map.Entry<String, String> att :
                    vertex.getAttributes().entrySet()) {
                System.out.println("att: " + att.getKey() + " val: " + att.getValue());
            }
            if (vertex.getAttribute(attribute) != null) {
                Integer num = Integer.parseInt(vertex.getAttribute(attribute));
                total += num;
                System.out.println("num is: " + num);
                System.out.println("total is:" + total + " exp:" + expected);
            } else if (total >= expected) {
                return false;
            }

        }
        return total.intValue() == expected.intValue();
    }
}
