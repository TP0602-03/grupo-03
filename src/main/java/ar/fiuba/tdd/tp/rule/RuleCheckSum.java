package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.List;

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
        for (GraphVertex vertex :
                vertices){
            Integer num = (Integer) vertex.getAttribute(attribute);
            if (num != null) {
                total += num;
            } else if (num == null && total >= expected.intValue()){
                return false;
            }
            //vertex.print();
            System.out.print(num + " ");

        }
        System.out.println("total: " + total + "exp: " + expected);
        return total.intValue() == expected.intValue();
    }
}
