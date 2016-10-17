package ar.fiuba.tdd.tp.move;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by luciano on 15/10/16.
 */
public class MoveFactory {

    //Saves the possible values to be used in the move. The key is the possible value and the value of the hash is the attribute name
    // its like an inverted hash)
    private HashMap<String, String> possibleValues;

    //Saves the possible positions for the move to take place in
    private HashMap<Pair<Integer, Integer>, Boolean> possiblePositions;


    public MoveFactory(HashMap<String, String> possibleValuesMap, HashMap<Pair<Integer, Integer>, Boolean> possiblePositionsMap) {
        this.possibleValues = possibleValuesMap;
        this.possiblePositions = possiblePositionsMap;
    }


    public Move createMove(int newId, int newX, int newY, String newValue) {


        if (this.possibleValues.containsKey(newValue) && possiblePositions.containsKey(new Pair<>(newX, newY))) {
            String newAttribute = this.possibleValues.get(newValue);
            return new ValidMove(newId, newX, newY, newAttribute, newValue);
        }

        return new InvalidMove(newId);
    }


}
