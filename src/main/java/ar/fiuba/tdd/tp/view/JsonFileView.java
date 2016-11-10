package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.move.Move;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/**
 * Created by luciano on 16/10/16.
 */
public class JsonFileView {

    private String fileName;
    private JSONObject info;

    public JsonFileView(String newFileName) {
        fileName = newFileName;
        info = new JSONObject();

        info.put("plays", new JSONArray());
        JSONObject boardObject = new JSONObject();
        boardObject.put("status", "false");
        JSONArray valuesArray = new JSONArray();
        boardObject.put("values", valuesArray);
        info.put("board", boardObject);
    }


    private JSONObject aux(JSONObject cell,int row,int col,Map.Entry<String, String> key,String content ) {
        if ( cell == null) {
            cell = createJsonCell(row, col, key.getKey(), content);
        } else {
            updateJsonCell(cell,key.getKey(), content);
        }
        return cell;
    }


    public void add(Game game) {

        ArrayList<JSONObject> cells = new ArrayList<>();
        JSONObject cell = null;
        for (int col = 0; isLowerThan(game, col); col++) {
            for (int row = 0; row < game.getHeight(); row++) {
                cell = null;
                for (Map.Entry<String, String> key : game.getCellKeysValues(col, row)) {
                    String content;
                    try {
                        content = key.getValue();
                        if (Objects.equals(key.getKey(), "pos")) {
                            continue;
                        }
                        cell = aux(cell,row,col,key,content);

                    } catch (Exception ex) {
                        //do nothing;
                    }
                }
                cells.add(cell);


            }
        }

        updateBoard(cells);
        addStatus(game);
    }

    public void add(Move newMove) {
        JSONObject play = new JSONObject();
        play.put("number", newMove.getId());

        if (newMove.isValid()) {
            play.put("boardStatus", "valid");
        } else {
            play.put("boardStatus", "invalid");
        }
        ((JSONArray) info.get("plays")).add(play);
    }

    private void updateJsonCell(JSONObject cell,String attribute,String value) {

        JSONArray values = (JSONArray) cell.get("attributes");
        JSONObject atvalue = new JSONObject();

        atvalue.put(attribute, value);

        values.add(atvalue);
        cell.put("attributes",values);

    }

    private JSONObject createJsonCell(int positionX, int positionY, String attribute, String value) {


        JSONArray positionArray = new JSONArray();
        positionArray.add(positionY);
        positionArray.add(positionX);
        JSONObject atvalue = new JSONObject();

        atvalue.put(attribute, value);

        JSONArray array = new JSONArray();
        array.add(atvalue);
        JSONObject cell = new JSONObject();
        cell.put("attributes",array);
        cell.put("position",positionArray);

        return cell;

    }

    private void addStatus(Game game) {
        if (game.validateRules()) {
            ((JSONObject) info.get("board")).put("status", "true");
        } else {
            ((JSONObject) info.get("board")).put("status", "false");
        }

    }

    private void updateBoard(ArrayList<JSONObject> cells) {
        ((JSONObject) info.get("board")).put("values", cells);
    }

    private boolean isLowerThan(Game game, int col) {
        return col < game.getWidth();
    }

    public void write() throws IOException {

        File file = new File(fileName);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.print(info.toJSONString());
        printWriter.close();

    }

}
