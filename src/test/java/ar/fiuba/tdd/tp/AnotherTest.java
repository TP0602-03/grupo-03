package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.rule.RuleCheckSum;
import ar.fiuba.tdd.tp.rule.RuleDistinctElements;

public class AnotherTest {

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

    /*        Game game = new Game(4, 4);

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
        System.out.println(ruleCountEdges.check(v2));*/

}
