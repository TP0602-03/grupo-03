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
    private String path;
    private JSONObject jsonGame;
    //private String gameName;
    private int width;
    private int height;
    private Game game;

    public Parser(String filePath) throws ParseException, IOException, org.json.simple.parser.ParseException {
        this.path = filePath;
        JSONParser parser = new JSONParser();
        this.jsonGame = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(this.path), "UTF-8"));
        //this.gameName = (String) this.jsonGame.get("name");
        JSONObject size = (JSONObject) this.jsonGame.get("size");
        width = ((Long) size.get("width")).intValue();
        height = ((Long) size.get("height")).intValue();

        game = new Game(width, height);

        GraphVertexParser gridParser = new GraphVertexParser();
        gridParser.loadGrid(game, this.jsonGame);

        JSONArray editables = (JSONArray) this.jsonGame.get("editables");
        for (Object obj :
                editables) {
            JSONObject attributeInfo = (JSONObject) obj;
            String attributeName = (String) attributeInfo.get("attribute");
            JSONArray attributeValues = (JSONArray) attributeInfo.get("values");
            JSONArray transitionActions = (JSONArray) attributeInfo.get("transition_actions");
            List<Action> actionsTransition = new ArrayList<>();
            if (transitionActions != null) {
                for (Object actionObj :
                        transitionActions) {
                    JSONObject actionJson = (JSONObject) actionObj;
                    ActionParser actParser = new ActionParser(actionJson);
                    Action action = actParser.getAction();
                    actionsTransition.add(action);
                }
            }
            JSONArray actions = (JSONArray) attributeInfo.get("actions");
            if (actions != null) {
                for (int i = 0; i < attributeValues.size(); i++) {
                    JSONArray valueActions = (JSONArray) actions.get(i);
                    List<Action> actionsForValue = new ArrayList<>();
                    for (Object actionObj :
                            valueActions) {
                        JSONObject actionJson = (JSONObject) actionObj;
                        ActionParser actParser = new ActionParser(actionJson);
                        Action action = actParser.getAction();
                        actionsForValue.add(action);
                        //System.out.println("action = " + action);
                    }
                    Object value = attributeValues.get(i);
                    List<Action> allActions = new ArrayList<>();
                    allActions.addAll(actionsTransition);
                    allActions.addAll(actionsForValue);
                    game.addActions(attributeName, value.toString(), allActions);
                }
            }
        }

        RegionParser regionParser = new RegionParser();
        JSONArray jsonRegions = (JSONArray) jsonGame.get("regions");
        regionParser.loadRegions(game, jsonRegions);

    }

    public Game getGame() {
        return game;
    }

}
