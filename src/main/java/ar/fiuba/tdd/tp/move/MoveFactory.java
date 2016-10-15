package ar.fiuba.tdd.tp.move;

import javafx.util.Pair;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by luciano on 15/10/16.
 */
public class MoveFactory {

    //Saves the possible values to be used in the move
    private HashMap<String,Boolean> possibleValues;

    //Saves the possible positions for the move to take place in
    private HashMap<Pair<Integer,Integer>,Boolean> possiblePositions;



    public MoveFactory(HashMap<String,Boolean> possibleValuesMap, HashMap<Pair<Integer,Integer>,Boolean> possiblePositionsMap) {
        this.possibleValues = possibleValuesMap;
        this.possiblePositions = possiblePositionsMap;
    }

    public MoveFactory(ArrayList<String> possibleValuesList,ArrayList<Pair<Integer,Integer>> possiblePositionsList) {

        this.possibleValues = new HashMap<>();
        for( String value : possibleValuesList) {
            this.possibleValues.put(value,Boolean.TRUE);
        }

        this.possiblePositions = new HashMap<>();
        for (Pair<Integer,Integer> position : possiblePositionsList) {
            this.possiblePositions.put(position,Boolean.TRUE);
        }
    }

    public Move createMove(int id,int x,int y,String value) {


        if (this.possibleValues.containsKey(value) && possiblePositions.containsKey(new Pair<>(x,y))) {
            return new ValidMove(id,x,y,value);
        }

        return new InvalidMove(id);
    }


}
