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

            if(vertex.getAttribute(this.attribute) != null) {
                Integer edgesAttribute = Integer.parseInt(vertex.getAttribute(this.attribute));
                int numAdjacent = vertex.getAdjacencyList().size();
                if (numAdjacent != edgesAttribute) {
                    vertex.print();
                    return false;
                }
            }
        }
        return true;
    }
}
