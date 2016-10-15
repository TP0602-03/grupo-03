package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.Region;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.rule.Rule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Objects;

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
            }
            JSONArray rules = (JSONArray) region.get("rules");
            loadRules(rules, reg);
            game.addRegion(reg);

        }
    }

    private void loadCustomRegion(Game game, JSONObject region, Region reg) {

    }

    private void loadRules(JSONArray rules, Region reg) {
        RuleParser ruleParser = new RuleParser();
        for (Object o :
                rules) {
            JSONObject jsonRule = (JSONObject)((JSONObject) o).get("rule");
            Rule rule = ruleParser.loadRule(jsonRule);

            reg.addRule(rule);
        }
    }


    private void loadRectangleRegion(Game game, JSONObject region, Region reg) {
        JSONObject rectangle = (JSONObject) region.get("rectangle");
        int row_min = ((Long) rectangle.get("x_min")).intValue();
        int row_max = ((Long) rectangle.get("x_max")).intValue();
        int col_min = ((Long) rectangle.get("y_min")).intValue();
        int col_max = ((Long) rectangle.get("y_max")).intValue();

        for (int i = row_min; i <= row_max; i++) {
            for (int j = col_min; j <= col_max; j++) {
                GraphVertex vertex = game.getCell(i, j);
                reg.addVertex(vertex);
            }
        }
    }

    private void loadRowRegion(Game game, JSONObject region, Region reg) {
        int row = ((Long) region.get("row")).intValue();
        int width = game.getWidth();
        for (int i = 0; i <= width; i++) {
            GraphVertex vertex = game.getCell(row, i);
            reg.addVertex(vertex);
        }
    }

    private void loadColumnRegion(Game game, JSONObject region, Region reg) {
        int column = ((Long) region.get("column")).intValue();
        int height = game.getHeight();
        for (int i = 0; i <= height; i++) {
            GraphVertex vertex = game.getCell(i, column);
            reg.addVertex(vertex);
        }
    }
}
