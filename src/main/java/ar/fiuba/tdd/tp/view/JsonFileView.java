package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.move.Move;
import javafx.util.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
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

    public void add(Pair<Integer, Integer> position,String attribute, String value) {
        JSONObject cell = new JSONObject();
        JSONArray positionArray = new JSONArray();
        positionArray.add(position.getKey());
        positionArray.add(position.getValue());
        cell.put("position", positionArray);
        cell.put("attribute",attribute);
        cell.put("value", value);
        ((JSONArray) ((JSONObject) this.info.get("board")).get("values")).add(cell);

    }

    public void add(Game game) {

        for (int i = 0; i < game.getWidth(); i++) {
            for (int j = 0; j < game.getHeight(); j++) {
                for (Map.Entry<String, Object> key : game.getCellKeysValues(i, j)) {
                    String content;
                    try {
                        content = key.getValue().toString();
                        this.info.put(key,content);
                    } catch (Exception ex) {
                        //do nothing;
                    }
                }
            }
        }
    }

    public void write() throws IOException {

        File file = new File(this.fileName);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.print(this.info.toJSONString());
        printWriter.close();

    }

}
