package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.rule.Rule;
import ar.fiuba.tdd.tp.rule.RuleCheckSum;
import ar.fiuba.tdd.tp.rule.RuleDistinctElements;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Objects;

public class Parser {
    private String path;
    private JSONObject jsonGame;
    private String gameName;
    private int width;
    private int height;

    public Parser(String filePath) throws ParseException, IOException, org.json.simple.parser.ParseException {
        this.path = filePath;
        JSONParser parser = new JSONParser();
        this.jsonGame = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(this.path), "UTF-8"));
        this.gameName = (String) this.jsonGame.get("name");
        JSONObject size = (JSONObject) this.jsonGame.get("size");
        width = (int) size.get("width");
        height = (int) size.get("height");
        Game game = new Game(width, height);
        loadCells(game, jsonGame);
        loadRegions(game, jsonGame);
    }

    private void loadRegions(Game game, JSONObject jsonGame) {
        JSONArray regions = (JSONArray) jsonGame.get("regions");
        for (Object o :
                regions) {
            JSONObject region = (JSONObject) o;
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
        for (Object o :
                rules) {
            Rule rule = loadRule((JSONObject) o);
            reg.addRule(rule);
        }
    }

    private Rule loadRule(JSONObject ruleJson) {

        Rule rule = null;
        String ruleName = (String) ruleJson.get("name");
        if (Objects.equals(ruleName, "RuleCheckSum")) {
            String att = (String) ruleJson.get("attribute");
            int exp = (int) ruleJson.get("expected");
            rule = new RuleCheckSum(att, exp);
        } else if (Objects.equals(ruleName, "RuleDistinctValues")) {
            String att = (String) ruleJson.get("attribute");
            rule = new RuleDistinctElements(att);
        }
        return rule;
    }

    private void loadRectangleRegion(Game game, JSONObject region, Region reg) {
        JSONObject rectangle = (JSONObject) region.get("rectangle");
        int row_min = (int) rectangle.get("x_min");
        int row_max = (int) rectangle.get("x_max");
        int col_min = (int) rectangle.get("y_min");
        int col_max = (int) rectangle.get("y_max");

        for (int i = row_min; i <= row_max; i++) {
            for (int j = col_min; j <= col_max; j++) {
                GraphVertex vertex = game.getCell(i, j);
                reg.addVertex(vertex);
            }
        }
    }

    private void loadRowRegion(Game game, JSONObject region, Region reg) {
        int row = (int) region.get("row");

        for (int i = 0; i <= width; i++) {
            GraphVertex vertex = game.getCell(row, i);
            reg.addVertex(vertex);
        }
    }

    private void loadColumnRegion(Game game, JSONObject region, Region reg) {
        int column = (int) region.get("column");

        for (int i = 0; i <= height; i++) {
            GraphVertex vertex = game.getCell(i, column);
            reg.addVertex(vertex);
        }
    }

    private void loadCells(Game game, JSONObject jsonGame) {
        JSONArray cells = (JSONArray) jsonGame.get("cells");
        for (Object o :
                cells) {
            JSONObject cell = (JSONObject) o;
            int row = (int) cell.get("x");
            int col = (int) cell.get("y");
            GraphVertex vertex = game.getCell(row, col);
            JSONArray attributes = (JSONArray) cell.get("attributes");
            for (Object e :
                    attributes) {
                JSONObject attribute = (JSONObject) e;
                String name = (String) attribute.get("name");
                Object value = attribute.get("value");
                vertex.setAttribute(name, value);
            }
        }
    }
}
