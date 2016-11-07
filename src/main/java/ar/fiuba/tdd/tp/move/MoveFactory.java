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

    public MoveFactory(HashMap<String, ArrayList<String>> possibleValuesMap,
                       HashMap<Pair<Integer, Integer>, ArrayList<String>> possiblePositionsMap) {
        possibleAttributeValues = possibleValuesMap;
        editableCells = possiblePositionsMap;
    }

    private Boolean isEditable(Pair<Integer, Integer> position) {
        //First check if the cell is editable
        return editableCells.containsKey(position);
    }

    private Boolean isAttributeEditable(String attribute, Pair<Integer, Integer> position) {
        //Now check if the attribute is editable and the value is valid
        ArrayList<String> editableAttributes = editableCells.get(position);

        return editableAttributes.contains(attribute);
    }

    private Boolean isValuePossible(String attribute, String value) {
        ArrayList<String> possibleValues = possibleAttributeValues.get(attribute);

        return possibleValues.contains(value);
    }

    public Move createMove(int newId, int newX, int newY, String newAttribute, String newValue) {

        Pair<Integer, Integer> position = new Pair<>(newX, newY);

        Boolean editable = isEditable(position);
        Boolean attributeEditable = isAttributeEditable(newAttribute, position);
        Boolean valuePossible = isValuePossible(newAttribute, newValue);
        if (!editable || !attributeEditable || !valuePossible) {
            return new InvalidMove(newId);
        }

        return new ValidMove(newId, newX, newY, newAttribute, newValue);
    }

}
