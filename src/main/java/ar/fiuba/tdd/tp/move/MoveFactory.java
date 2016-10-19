package ar.fiuba.tdd.tp.move;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by luciano on 15/10/16.
 */
public class MoveFactory {

    //Saves the attribute name as the key and the possible values as the hash value.
    private HashMap<String, ArrayList<String>> possibleAttributeValues;

    //Saves the editable cell's positions as keys and the editable attributes as values
    private HashMap<Pair<Integer, Integer>, ArrayList<String>> editableCells;


    public MoveFactory(HashMap<String, ArrayList<String>> possibleValuesMap, HashMap<Pair<Integer, Integer>, ArrayList<String>> possiblePositionsMap) {
        this.possibleAttributeValues = possibleValuesMap;
        this.editableCells = possiblePositionsMap;
    }


    public Move createMove(int newId, int newX, int newY,String newAttribute, String newValue) {

        Pair<Integer,Integer> position = new Pair<>(newX,newY);

        //First check if the cell is editable
        if (!this.editableCells.containsKey(position)) {
            return new InvalidMove(newId);
        }

        //Now check if the attribute is editable and the value is valid
        ArrayList<String> editableAttributes = this.editableCells.get(position);

        if (!editableAttributes.contains(newAttribute) ) {
            return new InvalidMove(newId);
        }

        //Now check if the value of the attribute is valid

        ArrayList<String> possibleValues = this.possibleAttributeValues.get(newAttribute);

        if (!possibleValues.contains(newValue) ) {
            return new InvalidMove(newId);
        }

        return new ValidMove(newId,newX,newY,newAttribute,newValue);
    }


}
