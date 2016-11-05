package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import org.json.simple.JSONObject;

import java.util.List;
import java.util.Objects;

public class RuleCheckOperationResult extends Rule {


    private final String attribute;
    private final int expected;
    private OperationCalculator operation;

    public RuleCheckOperationResult(JSONObject obj) {
        String operator = (String) obj.get("operator");
        attribute = (String) obj.get("attribute");
        expected = ((Long) obj.get("expected")).intValue();
        if (Objects.equals(operator, "sum")) {
            operation = new SumCalculator();
        } else if (Objects.equals(operator, "product")) {
            operation = new ProductCalculator();
        } else {
            operation = null;
        }
    }

    @Override
    public boolean check(List<GraphVertex> vertices) {
        Integer total = operation.neutral();

        for (GraphVertex vertex :
                vertices) {
            if (vertex.getAttribute(attribute) != null) {
                Integer num = Integer.parseInt(vertex.getAttribute(attribute));
                total = operation.calculate(total, num);
            } else if (total >= expected) {
                return false;
            }

        }
        return total == expected;
    }

    private abstract class OperationCalculator {
        public abstract int calculate(int opA, int opB);

        public abstract int neutral();
    }

    private class ProductCalculator extends OperationCalculator {
        public int neutral() {
            return 1;
        }

        public int calculate(int opA, int opB) {
            return opA * opB;
        }
    }

    private class SumCalculator extends OperationCalculator {
        public int neutral() {
            return 0;
        }

        public int calculate(int opA, int opB) {
            return opA + opB;
        }
    }
}
