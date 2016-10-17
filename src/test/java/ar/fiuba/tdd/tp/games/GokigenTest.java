package ar.fiuba.tdd.tp.games;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.Region;
import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.rule.RuleCountVertexEdges;
import ar.fiuba.tdd.tp.rule.RuleGraphHasNoCycles;
import org.junit.Test;

public class GokigenTest {
    @Test
    public void dummy() {
        Game gogiken = new Game(2, 2);

        Region fullGraph = new Region();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fullGraph.addVertex((gogiken.getNode(i, j)));
            }
        }
        fullGraph.addRule(new RuleCountVertexEdges("max_edges"));
        fullGraph.addRule(new RuleGraphHasNoCycles());

        gogiken.addRegion(fullGraph);

        gogiken.getNode(0, 0).setAttribute("max_edges", 1);
        gogiken.getNode(0, 1).setAttribute("max_edges", -1);
        gogiken.getNode(0, 2).setAttribute("max_edges", 0);
        gogiken.getNode(1, 0).setAttribute("max_edges", 1);
        gogiken.getNode(1, 1).setAttribute("max_edges", 1);
        gogiken.getNode(1, 2).setAttribute("max_edges", 2);
        gogiken.getNode(2, 0).setAttribute("max_edges", -1);
        gogiken.getNode(2, 1).setAttribute("max_edges", 2);
        gogiken.getNode(2, 2).setAttribute("max_edges", -1);

        gogiken.playCell(0, 0, "diagonal", "\\");
        gogiken.addNodeEdge(new Coord(0, 0), new Coord(1, 1));
        gogiken.validateRules();

        gogiken.playCell(1, 0, "diagonal", "\\");
        gogiken.addNodeEdge(new Coord(1, 0), new Coord(2, 1));
        gogiken.validateRules();

        gogiken.playCell(1, 0, "diagonal", "\\");
        gogiken.addNodeEdge(new Coord(0, 1), new Coord(1, 2));
        gogiken.validateRules();

        gogiken.playCell(1, 0, "diagonal", "/");
        gogiken.addNodeEdge(new Coord(2, 1), new Coord(1, 2));
        gogiken.validateRules();
    }
}
