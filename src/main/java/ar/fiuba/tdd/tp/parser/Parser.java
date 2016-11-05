package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.action.Action;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private JSONObject jsonGame;
    private Game game;

    public Parser(String filePath) throws ParseException, IOException, org.json.simple.parser.ParseException {
        String path = filePath;
        JSONParser parser = new JSONParser();
        this.jsonGame = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        //this.gameName = (String) this.jsonGame.getCell("name");
        JSONObject size = (JSONObject) this.jsonGame.get("size");
        int width = ((Long) size.get("width")).intValue();
        int height = ((Long) size.get("height")).intValue();

        game = new Game(width, height);

        GraphVertexParser gridParser = new GraphVertexParser();
        gridParser.loadGrid(game, this.jsonGame);

        loadEditables();

        RegionParser regionParser = new RegionParser();
        JSONArray jsonRegions = (JSONArray) jsonGame.get("regions");
        regionParser.loadRegions(game, jsonRegions);

    }

    private void loadEditables() {
        JSONArray editables = (JSONArray) this.jsonGame.get("editables");
        for (Object obj : editables) {
            JSONObject attributeInfo = (JSONObject) obj;
            String attributeName = (String) attributeInfo.get("attribute");
            JSONArray attributeValues = (JSONArray) attributeInfo.get("values");

            JSONArray actions = (JSONArray) attributeInfo.get("actions");
            if (actions != null) {
                loadActionsForAttribute(attributeName, attributeValues, actions);
            }
            game.addAllowedValues(this.parseJsonArrayToStringArray(attributeValues), attributeName);
        }
    }

    private void loadActionsForAttribute(String attributeName, JSONArray attributeValues, JSONArray actions) {
        for (int i = 0; i < actions.size(); i++) {
            JSONArray valueActions = (JSONArray) actions.get(i);
            List<Action> actionsForValue = new ArrayList<>();
            for (Object actionObj :
                    valueActions) {
                JSONObject actionJson = (JSONObject) actionObj;
                ActionParser actParser = new ActionParser(actionJson);
                Action action = actParser.getAction();
                actionsForValue.add(action);
            }
            Object value = attributeValues.get(i);
            game.addActions(attributeName, value.toString(), actionsForValue);

        }
    }

    private ArrayList<String> parseJsonArrayToStringArray(JSONArray attributeValues) {
        ArrayList<String> stringArray = new ArrayList<>();

        for (Object jsonObject : attributeValues) {
            stringArray.add(jsonObject.toString());
        }


        RestrictionsParser restrictionsParser = new RestrictionsParser();
        JSONArray jsonRestrictions = (JSONArray) jsonGame.get("restrictions");
        restrictionsParser.loadCellRestrictions(game, jsonRestrictions);


        return stringArray;

    }

    public Game getGame() {
        return game;
    }

}
