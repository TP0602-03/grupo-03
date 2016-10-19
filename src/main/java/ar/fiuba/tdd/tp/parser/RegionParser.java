package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.Region;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.rule.Rule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RegionParser {
    public void loadRegions(Game game, JSONArray regions) {
        for (Object o :
                regions) {
            JSONObject region = (JSONObject) ((JSONObject) o).get("region");
            Region reg = new Region();
            String type = (String) region.get("type");


            if (Objects.equals(type, "rectangle")) {
                loadRectangleRegion(game, region, reg);
            } else if (Objects.equals(type, "column")) {
                loadColumnRegion(game, region, reg);
            } else if (Objects.equals(type, "row")) {
                loadRowRegion(game, region, reg);
            } else if (Objects.equals(type, "custom")) {
                loadCustomRegion(game, region, reg);
            } else if (Objects.equals(type, "edges")) {
                loadEdgesRegion(game, region, reg);
            } else if (Objects.equals(type, "all_cells")) {
                loadAllCells(game, reg);
            } else if (Objects.equals(type, "all_corners")) {
                loadAllCorners(game, reg);
            } else if (Objects.equals(type, "all_edges")) {
                loadAllEdges(game, reg);
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

    private void loadEdgesRegion(Game game, JSONObject region, Region reg) {
        JSONArray cells = (JSONArray) region.get("cells");
        //Horizontal
        Set<GraphVertex> set = new HashSet<>();
        for (Object obj :
                cells) {
            JSONObject cellPos = (JSONObject) obj;
            int row = ((Long) cellPos.get("x")).intValue();
            int col = ((Long) cellPos.get("y")).intValue();
            //top
            GraphVertex vertex = game.getVertex(2 * row, 2 * col + 1);
            set.add(vertex);
            //bottom
            vertex = game.getVertex(2 * row + 2, 2 * col + 1);
            set.add(vertex);
            //left
            vertex = game.getVertex(2 * row + 1, 2 * col);
            set.add(vertex);
            //right
            vertex = game.getVertex(2 * row + 1, 2 * col + 2);
            set.add(vertex);

        }
        for (GraphVertex vertex :
                set) {
            reg.addVertex(vertex);
        }
    }


    private void loadCustomRegion(Game game, JSONObject region, Region reg) {
        JSONArray cells = (JSONArray) region.get("cells");
        for (Object obj :
                cells) {
            JSONObject cellPos = (JSONObject) obj;
            int row = ((Long) cellPos.get("x")).intValue();
            int col = ((Long) cellPos.get("y")).intValue();
            GraphVertex vertex = game.getCell(row, col);
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
        int rowMin = ((Long) rectangle.get("x_min")).intValue();
        int rowMax = ((Long) rectangle.get("x_max")).intValue();
        int colMin = ((Long) rectangle.get("y_min")).intValue();
        int colMax = ((Long) rectangle.get("y_max")).intValue();

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
