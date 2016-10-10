package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.graph.GridGraph;
import ar.fiuba.tdd.tp.rule.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void setDefaultAttribute(Game game, int width, int height, String attribute, Object value) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                game.getCell(i, j).setAttribute(attribute, value);
            }
        }
    }

    public static void buildRowRegions(Game game) {
        for (int i = 0; i < 4; i++) {
            Region region;
            region = new Region();
            region.addVertex(game.getCell(i, 0));
            region.addVertex(game.getCell(i, 1));
            region.addVertex(game.getCell(i, 2));
            region.addVertex(game.getCell(i, 3));
            region.addRule(new RuleCheckSum("num", 10));
            region.addRule(new RuleDistinctElements("num"));
            game.addRegion(region);
        }
    }

    public static void buildColumnRegions(Game game) {
        for (int i = 0; i < 4; i++) {
            Region region;
            region = new Region();
            region.addVertex(game.getCell(0, i));
            region.addVertex(game.getCell(1, i));
            region.addVertex(game.getCell(2, i));
            region.addVertex(game.getCell(3, i));
            region.addRule(new RuleCheckSum("num", 10));
            region.addRule(new RuleDistinctElements("num"));
            game.addRegion(region);
        }
    }

    private static void buildSquareRegions(Game game) {
        Region region;
        region = new Region();
        region.addVertex(game.getCell(0, 0));
        region.addVertex(game.getCell(0, 1));
        region.addVertex(game.getCell(1, 0));
        region.addVertex(game.getCell(1, 1));
        region.addRule(new RuleCheckSum("num", 10));
        region.addRule(new RuleDistinctElements("num"));
        game.addRegion(region);

        region = new Region();
        region.addVertex(game.getCell(2, 0));
        region.addVertex(game.getCell(2, 1));
        region.addVertex(game.getCell(3, 0));
        region.addVertex(game.getCell(3, 1));
        region.addRule(new RuleCheckSum("num", 10));
        region.addRule(new RuleDistinctElements("num"));
        game.addRegion(region);

        region = new Region();
        region.addVertex(game.getCell(0, 2));
        region.addVertex(game.getCell(0, 3));
        region.addVertex(game.getCell(1, 2));
        region.addVertex(game.getCell(1, 3));
        region.addRule(new RuleCheckSum("num", 10));
        region.addRule(new RuleDistinctElements("num"));
        game.addRegion(region);

        region = new Region();
        region.addVertex(game.getCell(2, 2));
        region.addVertex(game.getCell(2, 3));
        region.addVertex(game.getCell(3, 2));
        region.addVertex(game.getCell(3, 3));
        region.addRule(new RuleCheckSum("num", 10));
        region.addRule(new RuleDistinctElements("num"));
        game.addRegion(region);
    }

    public static void main(String[] args) {
        Game game = new Game(4, 4);

        setDefaultAttribute(game, 4, 4, "num", 0);

        GraphVertex cell;

        cell = game.getCell(0, 0);
        cell.setAttribute("num", 3);
        cell = game.getCell(0, 1);
        cell.setAttribute("num", 4);
        cell.setAttribute("right_wall", true);
        cell = game.getCell(0, 2);
        cell.setAttribute("num", 1);
        cell.setAttribute("left_wall", true);

        cell = game.getCell(1, 1);
        cell.setAttribute("num", 2);
        cell.setAttribute("right_wall", true);
        cell.setAttribute("down_wall", true);

        cell = game.getCell(2, 2);
        cell.setAttribute("num", 2);
        cell.setAttribute("left_wall", true);
        cell.setAttribute("up_wall", true);

        cell = game.getCell(3, 1);
        cell.setAttribute("num", 1);
        cell.setAttribute("right_wall", true);
        cell = game.getCell(3, 2);
        cell.setAttribute("num", 4);
        cell.setAttribute("left_wall", true);
        cell = game.getCell(3, 3);
        cell.setAttribute("num", 3);

        buildRowRegions(game);
        buildColumnRegions(game);
        buildSquareRegions(game);


        game.playCell(0, 3, "num", 2);
        System.out.println();

        game.playCell(1, 0, "num", 1);
        System.out.println();
        game.playCell(1, 2, "num", 3);
        System.out.println();
        game.playCell(1, 3, "num", 4);
        System.out.println();

        game.playCell(2, 0, "num", 4);
        System.out.println();
        game.playCell(2, 1, "num", 3);
        System.out.println();
        game.playCell(2, 3, "num", 1);
        System.out.println();

        game.playCell(3, 0, "num", 2);
        System.out.println();

        game.validateRules();

        // Juego de poner diagonales en las celdas

        game.playCell(1, 1, "diagonal", "/");
        game.addNodeEdge(new Coord(2, 1), new Coord(1, 2));

        GridGraph graph = new GridGraph(3, 3);
        graph.addEdge(new Coord(0, 0), new Coord(0, 1));
        graph.addEdge(new Coord(0, 1), new Coord(1, 0));
        graph.addEdge(new Coord(0, 0), new Coord(1, 0));
        Rule rule = new RuleGraphHasNoCycles();
        List<GraphVertex> vert = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                vert.add(graph.getVertex(i, j));
            }
        }

        System.out.println(rule.check(vert));


        Rule ruleCountEdges = new RuleCountVertexEdges("max_edges");
        GridGraph graph2 = new GridGraph(2, 2);
        graph2.addEdge(new Coord(0, 0), new Coord(0, 1));
        graph2.addEdge(new Coord(0, 1), new Coord(1, 0));
        graph2.addEdge(new Coord(0, 0), new Coord(1, 0));
        graph2.addEdge(new Coord(1, 0), new Coord(1, 1));
        graph2.getVertex(0, 0).setAttribute("max_edges", 2);
        graph2.getVertex(0, 1).setAttribute("max_edges", 2);
        graph2.getVertex(1, 0).setAttribute("max_edges", 3);
        graph2.getVertex(1, 1).setAttribute("max_edges", 1);
        List<GraphVertex> v2 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                v2.add(graph2.getVertex(i, j));
            }
        }
        System.out.println(ruleCountEdges.check(v2));

        // Goishi no se qué

        System.out.println("GOISHI");

        Game goishi = new Game(2, 2);
        // Jugada
        Region fullGraph = new Region();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fullGraph.addVertex((goishi.getNode(i, j)));
            }
        }
        fullGraph.addRule(new RuleCountVertexEdges("max_edges"));
        fullGraph.addRule(new RuleGraphHasNoCycles());

        goishi.addRegion(fullGraph);

        goishi.getNode(0, 0).setAttribute("max_edges", 1);
        goishi.getNode(0, 1).setAttribute("max_edges", -1);
        goishi.getNode(0, 2).setAttribute("max_edges", 0);
        goishi.getNode(1, 0).setAttribute("max_edges", 1);
        goishi.getNode(1, 1).setAttribute("max_edges", 1);
        goishi.getNode(1, 2).setAttribute("max_edges", 2);
        goishi.getNode(2, 0).setAttribute("max_edges", -1);
        goishi.getNode(2, 1).setAttribute("max_edges", 2);
        goishi.getNode(2, 2).setAttribute("max_edges", -1);

        goishi.playCell(0, 0, "diagonal", "\\");
        goishi.addNodeEdge(new Coord(0, 0), new Coord(1, 1));
        goishi.validateRules();

        goishi.playCell(1, 0, "diagonal", "\\");
        goishi.addNodeEdge(new Coord(1, 0), new Coord(2, 1));
        goishi.validateRules();

        goishi.playCell(1, 0, "diagonal", "\\");
        goishi.addNodeEdge(new Coord(0, 1), new Coord(1, 2));
        goishi.validateRules();

        goishi.playCell(1, 0, "diagonal", "/");
        goishi.addNodeEdge(new Coord(2, 1), new Coord(1, 2));
        goishi.validateRules();

        // Country road
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

        // Kakuro
        Game kakuro = new Game(4, 4);
        kakuro.getCell(0, 0).setAttribute("black", null);
        kakuro.getCell(0, 1).setAttribute("num_down", 17);
        kakuro.getCell(0, 2).setAttribute("num_down", 11);
        kakuro.getCell(0, 3).setAttribute("num_down", 17);

        kakuro.getCell(1, 0).setAttribute("num_right", 12);
        kakuro.getCell(2, 0).setAttribute("num_right", 21);
        kakuro.getCell(3, 0).setAttribute("num_right", 12);

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                kakuro.getCell(i, j).setAttribute("num", 0);
            }
        }

        Region reg1 = new Region();
        reg1.addVertex(kakuro.getCell(1, 1));
        reg1.addVertex(kakuro.getCell(1, 2));
        reg1.addVertex(kakuro.getCell(1, 3));

        reg1.addRule(new RuleCheckSum("num", 12));


        Region reg2 = new Region();
        reg2.addVertex(kakuro.getCell(2, 1));
        reg2.addVertex(kakuro.getCell(2, 2));
        reg2.addVertex(kakuro.getCell(2, 3));

        reg2.addRule(new RuleCheckSum("num", 21));

        Region reg3 = new Region();
        reg3.addVertex(kakuro.getCell(3, 1));
        reg3.addVertex(kakuro.getCell(3, 2));
        reg3.addVertex(kakuro.getCell(3, 3));

        reg3.addRule(new RuleCheckSum("num", 12));

        Region reg4 = new Region();
        reg4.addVertex(kakuro.getCell(1, 1));
        reg4.addVertex(kakuro.getCell(2, 1));
        reg4.addVertex(kakuro.getCell(3, 1));

        reg4.addRule(new RuleCheckSum("num", 17));

        Region reg5 = new Region();
        reg5.addVertex(kakuro.getCell(1, 2));
        reg5.addVertex(kakuro.getCell(2, 2));
        reg5.addVertex(kakuro.getCell(3, 2));

        reg5.addRule(new RuleCheckSum("num", 11));

        Region reg6 = new Region();
        reg6.addVertex(kakuro.getCell(1, 3));
        reg6.addVertex(kakuro.getCell(2, 3));
        reg6.addVertex(kakuro.getCell(3, 3));

        reg6.addRule(new RuleCheckSum("num", 17));

        reg1.addRule(new RuleDistinctElements("num"));
        reg2.addRule(new RuleDistinctElements("num"));
        reg3.addRule(new RuleDistinctElements("num"));
        reg4.addRule(new RuleDistinctElements("num"));
        reg5.addRule(new RuleDistinctElements("num"));
        reg6.addRule(new RuleDistinctElements("num"));

        kakuro.addRegion(reg1);
        kakuro.addRegion(reg2);
        kakuro.addRegion(reg3);
        kakuro.addRegion(reg4);
        kakuro.addRegion(reg5);
        kakuro.addRegion(reg6);

        System.out.println("---kakuro---");

        System.out.println("--- row 1 ---");

        kakuro.playCell(1, 1, "num", 1);
        System.out.println("--- 1 ---");
        kakuro.validateRules();
        kakuro.playCell(1, 2, "num", 5);
        System.out.println("--- 5 ---");
        kakuro.validateRules();
        kakuro.playCell(1, 3, "num", 6);
        System.out.println("--- 6 ---");
        kakuro.validateRules();

        System.out.println("--- row 2 ---");

        System.out.println("--- 9 ---");
        kakuro.playCell(2, 1, "num", 9);
        kakuro.validateRules();
        System.out.println("--- 4 ---");
        kakuro.playCell(2, 2, "num", 4);
        kakuro.validateRules();
        System.out.println("--- 8 ---");
        kakuro.playCell(2, 3, "num", 8);
        kakuro.validateRules();

        System.out.println("--- row 3 ---");

        System.out.println("--- 7 ---");
        kakuro.playCell(3, 1, "num", 7);
        kakuro.validateRules();
        System.out.println("--- 2 ---");
        kakuro.playCell(3, 2, "num", 2);
        kakuro.validateRules();
        System.out.println("--- 3 ---");
        kakuro.playCell(3, 3, "num", 3);
        kakuro.validateRules();

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                System.out.print(kakuro.getCell(i, j).getAttribute("num") + " ");
            }
            System.out.println();
        }

    }

}
