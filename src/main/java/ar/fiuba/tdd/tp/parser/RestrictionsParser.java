package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.Game;
import javafx.util.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;

/**
 * Created by luciano on 20/10/16.
 */
public class RestrictionsParser {

    public void loadCellRestrictions(Game game, JSONArray info) {

        HashMap<String, ArrayList<String>> posibleValues = new HashMap<>();
        HashMap<Pair<Integer, Integer>, ArrayList<String>> allowedPositions = new HashMap<>();

        this.loadAll(info,allowedPositions,posibleValues);

        game.setPosibleValues(posibleValues);
        game.setAllowedPositions(allowedPositions);

    }

    private void loadAllowedPositions(String attribute,JSONArray positions,
                                      HashMap<Pair<Integer, Integer>, ArrayList<String>> allowedPositions) {
        for ( Object object : positions) {
            JSONArray jsonObject = (JSONArray) object;
            int x = ((Long)jsonObject.get(0)).intValue();
            int y = ((Long)jsonObject.get(1)).intValue();
            Pair<Integer,Integer> position = new Pair<>(x,y);
            if(allowedPositions.containsKey(position)) {
                allowedPositions.get(position).add(attribute);
            }else {
                allowedPositions.put(position,new ArrayList<String>() {
                    {
                        add(attribute);
                    }
                } );
            }
        }

    }

    private void loadAllowedValues(String attribute,JSONArray values,
                                   HashMap<String, ArrayList<String>> posibleValues) {

        ArrayList<String> valuesArray = new ArrayList<>();

        for ( Object object : values) {
            String value = (String) object;
            valuesArray.add(value);
        }

        posibleValues.put(attribute,valuesArray);


    }

    private void loadAll(JSONArray info,HashMap<Pair<Integer, Integer>, ArrayList<String>> allowedPositionsMap,
                         HashMap<String, ArrayList<String>> posibleValues) {
        for ( Object object : info) {
            JSONObject jsonObject = (JSONObject) object;
            String attribute = (String) jsonObject.get("attribute");
            JSONArray allowedPositionsJson = (JSONArray) jsonObject.get("allowedPositions");
            JSONArray values = (JSONArray) jsonObject.get("allowedValues");

            this.loadAllowedPositions(attribute,allowedPositionsJson,allowedPositionsMap);
            this.loadAllowedValues(attribute,values,posibleValues);

        }



    }
}
