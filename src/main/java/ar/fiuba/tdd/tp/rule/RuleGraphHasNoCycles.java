package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.*;

public class RuleGraphHasNoCycles extends Rule {
    @Override
    public boolean check(List<GraphVertex> vertices) {
        Stack<GraphVertex> stack = new Stack<>();
        List<GraphVertex> visited = new ArrayList<>();
        Map<GraphVertex, GraphVertex> parent = new HashMap<>();

        stack.push(vertices.get(0));
        while (visited.size() != vertices.size()) {
            GraphVertex current = stack.pop();
            visited.add(current);

            List<GraphVertex> adjacent = current.getAdjacencyList();
            for (GraphVertex vertex :
                    adjacent) {
                if (!visited.contains(vertex) && parent.get(current) != vertex) {
                    parent.put(vertex, current);
                    stack.push(vertex);
                } else if (visited.contains(vertex) && parent.get(current) != vertex) {
                    return false;
                }
            }

            if (stack.empty()) {
                for (GraphVertex vertex :
                        vertices) {
                    if (!visited.contains(vertex)) {
                        stack.push(vertex);
                        break;
                    }
                }
                // Agrego un vertice que no haya sido visitado para seguir...
            }

        }
        return true;
    }
}
