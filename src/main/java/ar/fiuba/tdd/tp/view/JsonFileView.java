package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.move.Move;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by luciano on 16/10/16.
 */
public class JsonFileView {

    private String fileName;
    private JSONObject info;


    public JsonFileView(String newFileName) {
        this.fileName = newFileName;
        this.info = new JSONObject();

        this.info.put("plays", new JSONArray());
        JSONObject boardObject = new JSONObject();
        boardObject.put("status", "false");
        JSONArray valuesArray = new JSONArray();
        boardObject.put("values", valuesArray);
        this.info.put("board", boardObject);
    }

    public void add(Move newMove) {
        JSONObject play = new JSONObject();
        play.put("number", newMove.getId());

        if (newMove.isValid()) {
            play.put("boardStatus", "valid");
        } else {
            play.put("boardStatus", "invalid");
        }
        ((JSONArray) this.info.get("plays")).add(play);
    }

    private JSONObject createJsonCell(int positionX, int positionY, String attribute, String value) {


        JSONObject cell = new JSONObject();

        JSONArray positionArray = new JSONArray();
        positionArray.add(positionX);
        positionArray.add(positionY);
        cell.put("position", positionArray);
        cell.put("attribute", attribute);
        cell.put("value", value);

        return cell;

    }

    private void addStatus(Game game) {
        if (game.validateRules()) {
            ((JSONObject) this.info.get("board")).put("status", "true");
        } else {
            ((JSONObject) this.info.get("board")).put("status", "false");
        }

    }

    private void updateBoard(ArrayList<JSONObject> cells) {
        ((JSONObject) this.info.get("board")).put("values", cells);
    }

    public void add(Game game) {

        ArrayList<JSONObject> cells = new ArrayList<>();

        for (int i = 0; i < game.getWidth(); i++) {
            for (int j = 0; j < game.getHeight(); j++) {
                for (Map.Entry<String, String> key : game.getCellKeysValues(i, j)) {
                    String content;
                    try {
                        content = key.getValue();
                        if (key.getKey() != "pos") {
                            cells.add(this.createJsonCell(j, i, key.getKey().toString(), content));
                        }
                    } catch (Exception ex) {
                        //do nothing;
                    }
                }
            }
        }

        this.updateBoard(cells);
        this.addStatus(game);
    }

    public void write() throws IOException {

        File file = new File(this.fileName);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.print(this.info.toJSONString());
        printWriter.close();

    }

}
