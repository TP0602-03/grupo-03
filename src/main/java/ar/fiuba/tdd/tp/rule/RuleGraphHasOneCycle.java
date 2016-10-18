package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.*;

public class RuleGraphHasOneCycle extends Rule {
    @Override
    public boolean check(List<GraphVertex> vertices) {
        List<GraphVertex> verticesWithEdges = new ArrayList<>();
        System.out.println("all vertices = " + vertices.size());
        for (GraphVertex vertex :
                vertices) {
            int vertexDegree = vertex.getAdjacencyList().size();
            System.out.println("noow:");
            vertex.print();
            System.out.println("vertexDegree = " + vertexDegree);
            if (vertexDegree != 0 && vertexDegree != 2) {
                return false;
            }
            if (vertexDegree == 2) {
                verticesWithEdges.add(vertex);
            }
        }
        System.out.println("HEre");
        if (verticesWithEdges.size() == 0) {
            return false;
        }
        System.out.println("HEre2");
        Stack<GraphVertex> stack = new Stack<>();
        List<GraphVertex> visited = new ArrayList<>();
        Map<GraphVertex, GraphVertex> parent = new HashMap<>();

        stack.push(verticesWithEdges.get(0));
        while (!stack.empty()) {
            GraphVertex current = stack.pop();
            visited.add(current);
            System.out.println("visited: ");
            current.print();
            List<GraphVertex> adjacent = current.getAdjacencyList();
            for (GraphVertex vertex :
                    adjacent) {
//                System.out.println("vertex = " + vertex);
                if (parent.get(current) != vertex && !visited.contains(vertex)) {
                    System.out.println("la");
                    parent.put(vertex, current);
                    stack.push(vertex);
                } else if (parent.get(current) != vertex && visited.contains(vertex)) {
                    System.out.println("lu");
                    System.out.println("visited = " + visited);
                    System.out.println("verticesWithEdges.size() = " + verticesWithEdges.size());
                    return visited.size() == verticesWithEdges.size();
                }
            }
        }
        return false;

    }
}