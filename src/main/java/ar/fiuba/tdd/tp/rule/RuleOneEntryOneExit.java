package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.List;

public class RuleOneEntryOneExit extends Rule {
    @Override
    public boolean check(List<GraphVertex> vertices) {
        int edges = 0; // number of edges to vertices that are not in this region

        for (GraphVertex vertex :
                vertices) {
            for (GraphVertex dest :
                    vertex.getAdjacencyList()) {
                if (!vertices.contains(dest)) {
                    edges += 1;
                }
            }
        }
        //System.out.println("One entry one exit rule: " + (edges == 2));
        return edges == 2;
    }
}
