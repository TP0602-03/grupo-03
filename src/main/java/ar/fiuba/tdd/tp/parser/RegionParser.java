package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.Region;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.rule.Rule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashSet;
import java.util.Set;

public class RegionParser {
    public void loadRegions(Game game, JSONArray regions) {
        for (Object o :
                regions) {
            JSONObject region = (JSONObject) ((JSONObject) o).get("region");
            Region reg = new Region();
            String type = (String) region.get("type");


            switch (type) {
                case "rectangle":
                    loadRectangleRegion(game, region, reg);
                    break;
                case "column":
                    loadColumnRegion(game, region, reg);
                    break;
                case "row":
                    loadRowRegion(game, region, reg);
                    break;
                case "custom":
                    loadCustomRegion(game, region, reg);
                    break;
                case "edges":
                    loadEdgesRegion(game, region, reg);
                    break;
                case "all_cells":
                    loadAllCells(game, reg);
                    break;
                case "all_corners":
                    loadAllCorners(game, reg);
                    break;
                case "all_edges":
                    loadAllEdges(game, reg);
                    break;
                default:
                    break;

            }

            JSONArray rules = (JSONArray) region.get("rules");
            loadRules(rules, reg);
            game.addRegion(reg);
        }
    }

    private void loadAllEdges(Game game, Region reg) {
        Set<GraphVertex> set = new HashSet<>();
        for (int i = 0; i < game.getHeight(); i++) {
            for (int j = 0; j < game.getWidth(); j++) {
                //top
                GraphVertex vertex = game.getVertex(2 * i, 2 * j + 1);
                set.add(vertex);
                //bottom
                vertex = game.getVertex(2 * i + 2, 2 * j + 1);
                set.add(vertex);
                //left
                vertex = game.getVertex(2 * i + 1, 2 * j);
                set.add(vertex);
                //right
                vertex = game.getVertex(2 * i + 1, 2 * j + 2);
                set.add(vertex);
            }

        }
        for (GraphVertex v :
                set) {
            reg.addVertex(v);
        }
    }

    private void loadAllCorners(Game game, Region reg) {
        for (int i = 0; i < game.getHeight() + 1; i++) {
            for (int j = 0; j < game.getWidth() + 1; j++) {
                GraphVertex vertex = game.getCorner(i, j);
                reg.addVertex(vertex);
            }
        }
    }

    private void loadAllCells(Game game, Region reg) {
        for (int i = 0; i < game.getHeight(); i++) {
            for (int j = 0; j < game.getWidth(); j++) {
                GraphVertex vertex = game.getCell(i, j);
                reg.addVertex(vertex);
            }
        }
    }


    private GraphVertex getVertex(Game game, int row, int col, int rowOffset, int columnOffset) {
        return game.getVertex(2 * row + rowOffset, 2 * col + columnOffset);

    }

    private void loadEdgesRegion(Game game, JSONObject region, Region reg) {
        JSONArray cells = (JSONArray) region.get("cells");
        //Horizontal
        Set<GraphVertex> set = new HashSet<>();
        for (Object obj :
                cells) {
            JSONObject cellPos = (JSONObject) obj;
            int row = ((Long) cellPos.get("r")).intValue();
            int col = ((Long) cellPos.get("c")).intValue();
            //top
            set.add(this.getVertex(game, row, col, 0, 1));
            //bottom
            set.add(this.getVertex(game, row, col, 2, 1));
            //left
            set.add(this.getVertex(game, row, col, 1, 0));
            //right
            set.add(this.getVertex(game, row, col, 1, 2));

        }
        for (GraphVertex vertex :
                set) {
            reg.addVertex(vertex);
        }
    }


    private void loadCustomRegion(Game game, JSONObject region, Region reg) {
        JSONArray cells = (JSONArray) region.get("cells");
        for (Object objeto : cells) {
            JSONObject cellPosition = (JSONObject) objeto;
            int column = ((Long) cellPosition.get("c")).intValue();

            int row = ((Long) cellPosition.get("r")).intValue();
            GraphVertex vertex = game.getCell(row, column);
            reg.addVertex(vertex);
        }
    }

    private void loadRules(JSONArray rules, Region reg) {
        RuleParser ruleParser = new RuleParser();
        for (Object o :
                rules) {
            JSONObject jsonRule = (JSONObject) ((JSONObject) o).get("rule");
            //System.out.println(jsonRule);
            Rule rule = ruleParser.loadRule(jsonRule);
            //System.out.println("added rule: " + rule);
            reg.addRule(rule);
        }
    }


    private void loadRectangleRegion(Game game, JSONObject region, Region reg) {
        JSONObject rectangle = (JSONObject) region.get("rectangle");
        int rowMin = ((Long) rectangle.get("r_min")).intValue();
        int rowMax = ((Long) rectangle.get("r_max")).intValue();
        int colMin = ((Long) rectangle.get("c_min")).intValue();
        int colMax = ((Long) rectangle.get("c_max")).intValue();

        for (int i = rowMin; i <= rowMax; i++) {
            for (int j = colMin; j <= colMax; j++) {
                GraphVertex vertex = game.getCell(i, j);
                reg.addVertex(vertex);
            }
        }
    }

    private void loadRowRegion(Game game, JSONObject region, Region reg) {
        int row = ((Long) region.get("row")).intValue();
        int width = game.getWidth();
        for (int i = 0; i < width; i++) {
            GraphVertex vertex = game.getCell(row, i);
            reg.addVertex(vertex);
        }
    }

    private void loadColumnRegion(Game game, JSONObject region, Region reg) {
        int column = ((Long) region.get("column")).intValue();
        int height = game.getHeight();
        for (int i = 0; i < height; i++) {
            GraphVertex vertex = game.getCell(i, column);
            reg.addVertex(vertex);
        }
    }
}
