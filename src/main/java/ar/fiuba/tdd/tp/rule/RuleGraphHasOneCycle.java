package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.*;

public class RuleGraphHasOneCycle extends Rule {

    private Boolean checkVertices(List<GraphVertex> verticesWithEdges, List<GraphVertex> vertices) {

        for (GraphVertex vertex :
                vertices) {
            int vertexDegree = vertex.getAdjacencyList().size();
            if (vertexDegree != 0 && vertexDegree != 2) {
                return false;
            }
            if (vertexDegree == 2) {
                verticesWithEdges.add(vertex);
            }
        }
        return true;
    }


    private Boolean checkStack(Stack<GraphVertex> stack, List<GraphVertex> verticesWithEdges) {
        List<GraphVertex> visited = new ArrayList<>();
        Map<GraphVertex, GraphVertex> parent = new HashMap<>();
        while (!stack.empty()) {
            GraphVertex current = stack.pop();
            visited.add(current);
            List<GraphVertex> adjacent = current.getAdjacencyList();
            for (GraphVertex vertex :
                    adjacent) {
                if (parent.get(current) != vertex && !visited.contains(vertex)) {
                    parent.put(vertex, current);
                    stack.push(vertex);
                } else if (parent.get(current) != vertex && visited.contains(vertex)) {
                    return visited.size() == verticesWithEdges.size();
                }
            }
        }
        return false;
    }


    @Override
    public boolean check(List<GraphVertex> vertices) {
        List<GraphVertex> verticesWithEdges = new ArrayList<>();

        if (!this.checkVertices(verticesWithEdges, vertices)) {
            return false;
        }
        if (verticesWithEdges.size() == 0) {
            return false;
        }

        Stack<GraphVertex> stack = new Stack<>();

        stack.push(verticesWithEdges.get(0));

        return this.checkStack(stack, verticesWithEdges);


    }
}