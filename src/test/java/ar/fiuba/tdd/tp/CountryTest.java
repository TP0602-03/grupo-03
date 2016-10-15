package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.rule.RuleGraphHasOneCycle;
import ar.fiuba.tdd.tp.rule.RuleOneEntryOneExit;
import ar.fiuba.tdd.tp.rule.RuleTotalVertexWithAttributeEqual;
import org.junit.Test;

public class CountryTest {
    @Test
    public void test() {
        Game country = new Game(4, 4);

        System.out.println("--- COUNTRY ---");

        country.getCell(0, 0).setAttribute("num", 1);
        country.getCell(0, 2).setAttribute("num", 3);
        country.getCell(2, 0).setAttribute("num", 5);
        country.getCell(2, 3).setAttribute("num", 3);


        Region region1 = new Region();
        region1.addVertex(country.getCell(0, 0));
        region1.addVertex(country.getCell(0, 1));
        region1.addVertex(country.getCell(1, 0));

        country.addRegion(region1);


        Region region2 = new Region();
        region2.addVertex(country.getCell(0, 2));
        region2.addVertex(country.getCell(0, 3));
        region2.addVertex(country.getCell(1, 2));
        region2.addVertex(country.getCell(1, 3));

        country.addRegion(region2);


        Region region3 = new Region();
        region3.addVertex(country.getCell(1, 1));
        region3.addVertex(country.getCell(2, 0));
        region3.addVertex(country.getCell(2, 1));
        region3.addVertex(country.getCell(2, 2));
        region3.addVertex(country.getCell(3, 0));
        region3.addVertex(country.getCell(3, 1));

        country.addRegion(region3);


        Region region4 = new Region();
        region4.addVertex(country.getCell(2, 3));
        region4.addVertex(country.getCell(3, 2));
        region4.addVertex(country.getCell(3, 3));

        country.addRegion(region4);

        region1.addRule(new RuleOneEntryOneExit());
        region2.addRule(new RuleOneEntryOneExit());
        region3.addRule(new RuleOneEntryOneExit());
        region4.addRule(new RuleOneEntryOneExit());

        region1.addRule(new RuleTotalVertexWithAttributeEqual("edges", 1));
        region2.addRule(new RuleTotalVertexWithAttributeEqual("edges", 3));
        region3.addRule(new RuleTotalVertexWithAttributeEqual("edges", 5));
        region4.addRule(new RuleTotalVertexWithAttributeEqual("edges", 3));

        Region fullGame = new Region();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                fullGame.addVertex(country.getCell(i, j));
            }
        }

        fullGame.addRule(new RuleGraphHasOneCycle());
        country.addRegion(fullGame);

        country.playCell(0, 1, "edges", "south-east");
        country.addCellEdge(new Coord(0, 1), new Coord(1, 1));
        country.addCellEdge(new Coord(0, 1), new Coord(0, 2));

        country.playCell(0, 2, "edges", "west-east");
        country.addCellEdge(new Coord(0, 2), new Coord(0, 3));

        country.playCell(0, 3, "edges", "west-south");
        country.addCellEdge(new Coord(0, 3), new Coord(1, 3));

        country.playCell(1, 1, "edges", "south-north");
        //country.addCellEdge(new Coord(1,1),new Coord(0,1));
        country.addCellEdge(new Coord(1, 1), new Coord(2, 1));

        country.playCell(1, 3, "edges", "south-north");
        country.addCellEdge(new Coord(1, 3), new Coord(2, 3));

        country.playCell(2, 0, "edges", "south-east");
        country.addCellEdge(new Coord(2, 0), new Coord(3, 0));
        country.addCellEdge(new Coord(2, 0), new Coord(2, 1));

        country.playCell(2, 1, "edges", "south-north");
        //country.addCellEdge(new Coord(1,3),new Coord(2,3));

        country.playCell(2, 3, "edges", "south-north");
        country.addCellEdge(new Coord(2, 3), new Coord(3, 3));

        country.playCell(3, 0, "edges", "north-east");
        country.addCellEdge(new Coord(3, 0), new Coord(3, 1));

        country.playCell(3, 1, "edges", "west-east");
        country.addCellEdge(new Coord(3, 1), new Coord(3, 2));

        country.playCell(3, 2, "edges", "west-east");
        country.addCellEdge(new Coord(3, 2), new Coord(3, 3));

        country.playCell(3, 3, "edges", "west-north");

        country.validateRules();
    }
}
