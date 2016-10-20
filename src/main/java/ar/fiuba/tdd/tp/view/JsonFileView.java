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

    public void add(Game game) {

        ArrayList<JSONObject> cells = new ArrayList<>();
        int k = 0;
        int h = 0;

        while ( k < game.getWidth()) {
            while ( h < game.getHeight() ) {
                for (Map.Entry<String, String> clave : game.getCellKeysValues(k, h)) {
                    String content;
                    try {
                        content = clave.getValue();
                        if (clave.getKey() != "pos") {
                            cells.add(this.createJsonCell(h, k, clave.getKey().toString(), content));
                        }
                    } catch (Exception ex) {
                        //do nothing;
                    }
                }
                h++;
            }
            h = 0;
            k++;
        }


        this.updateBoard(cells);
        this.addStatus(game);
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


    public void write() throws IOException {

        File file = new File(this.fileName);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.print(this.info.toJSONString());
        printWriter.close();

    }

}
