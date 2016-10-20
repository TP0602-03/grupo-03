package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.List;

public class RuleCountVertexEdges extends Rule {
    private String attribute;

    public RuleCountVertexEdges(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public boolean check(List<GraphVertex> vertices) {
        //System.out.println("vertices = " + vertices);
        //System.out.println("rule count vertex edges");
        for (GraphVertex vertex :
                vertices) {
            //System.out.println("(Integer) vertex.getAttribute(attribute) = " + (Integer) vertex.getAttribute(attribute));
            vertex.print();
            if(vertex.getAttribute(this.attribute) != null) {
                Integer edgesAttribute = Integer.parseInt(vertex.getAttribute(this.attribute));
                System.out.println("WANTS " + edgesAttribute);
                System.out.println("HAS " + vertex.getAdjacencyList().size());
                int numAdjacent = vertex.getAdjacencyList().size();
                if (numAdjacent != edgesAttribute) {
                    vertex.print();
                    System.out.println("!!!!!!!!!!!!!!!!!DOESNT HAVE OK EDGES");
                    return false;
                }
            }
        }
        return true;
    }
}
