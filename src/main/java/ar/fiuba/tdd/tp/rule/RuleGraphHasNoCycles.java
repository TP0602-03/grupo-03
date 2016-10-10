package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class RuleGraphHasNoCycles extends Rule {
    @Override
    public boolean check(List<GraphVertex> vertices) {
        Stack<GraphVertex> stack = new Stack<>();
        Map<GraphVertex, Boolean> visited = new HashMap<>();
        Map<GraphVertex, GraphVertex> parent = new HashMap<>();
        for (GraphVertex vertex :
                vertices) {
            visited.put(vertex, false);
        }

        stack.push(vertices.get(0));
        while (!stack.empty()) {
            GraphVertex current = stack.pop();
            visited.put(current, true);
            //System.out.println("visited " + (String) current.getAttribute("pos"));
            List<GraphVertex> adjacent = current.getAdjacencyList();
            for (GraphVertex vertex :
                    adjacent) {

                if (parent.get(current) != vertex && !visited.get(vertex)) {
                    parent.put(vertex, current);
                    stack.push(vertex);
                } else if (parent.get(current) != vertex && visited.get(vertex)) {
                    return false;
                }
            }
        }
        // Falla si el vertice 0 no tiene aristas
        return true;
    }
}
