package ar.fiuba.tdd.tp.move;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by luciano on 15/10/16.
 */
public class MoveFactory {

    HashMap<String,Boolean> possibleValues;

    public MoveFactory(HashMap<String,Boolean> possibleValuesMap) {
        this.possibleValues = possibleValuesMap;
    }

    public MoveFactory(ArrayList<String> possibleValuesList) {

        this.possibleValues = new HashMap<>();
        for( String value : possibleValuesList) {
            this.possibleValues.put(value,Boolean.TRUE);
        }

    }

    public Move createMove(int id,int x,int y,String value) {

        if (this.possibleValues.containsKey(value)) {
            return new ValidMove(id,x,y,value);
        }

        return new InvalidMove(id);
    }


}
