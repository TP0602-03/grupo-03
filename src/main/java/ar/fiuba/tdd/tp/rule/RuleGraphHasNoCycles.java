package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.*;

public class RuleGraphHasNoCycles extends Rule {

    private Boolean checkAdjacent(List<GraphVertex> adjacent, List<GraphVertex> visited,
                                  Map<GraphVertex, GraphVertex> parent, Stack<GraphVertex> stack, GraphVertex current) {
        for (GraphVertex vertex :
                adjacent) {
            if (!visited.contains(vertex) && parent.get(current) != vertex) {
                parent.put(vertex, current);
                stack.push(vertex);
            } else if (visited.contains(vertex) && parent.get(current) != vertex) {
                return false;
            }
        }
        return true;
    }

    private void fixStackEmpty(Stack<GraphVertex> stack,List<GraphVertex> vertices,List<GraphVertex> visited) {

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

    @Override
    public boolean check(List<GraphVertex> vertices) {
        GraphAnalizer graphAnalizer = new GraphAnalizer().invoke();
        Stack<GraphVertex> stack = graphAnalizer.getStack();
        List<GraphVertex> visited = graphAnalizer.getVisited();
        Map<GraphVertex, GraphVertex> parent = graphAnalizer.getParent();

        stack.push(vertices.get(0));
        while (someVertexIsUnvisited(vertices, visited)) {
            GraphVertex current = stack.pop();
            visited.add(current);

            List<GraphVertex> adjacent = current.getAdjacencyList();

            if (!this.checkAdjacent(adjacent, visited, parent, stack, current)) {
                return false;
            }
            this.fixStackEmpty(stack,vertices,visited);


        }
        return true;
    }

    private boolean someVertexIsUnvisited(List<GraphVertex> vertices, List<GraphVertex> visited) {
        return visited.size() != vertices.size();
    }

    private static class GraphAnalizer {
        private Stack<GraphVertex> stack;
        private List<GraphVertex> visited;
        private Map<GraphVertex, GraphVertex> parent;

        public Stack<GraphVertex> getStack() {
            return stack;
        }

        public List<GraphVertex> getVisited() {
            return visited;
        }

        public Map<GraphVertex, GraphVertex> getParent() {
            return parent;
        }

        public GraphAnalizer invoke() {
            stack = new Stack<>();
            visited = new ArrayList<>();
            parent = new HashMap<>();
            return this;
        }
    }
}
