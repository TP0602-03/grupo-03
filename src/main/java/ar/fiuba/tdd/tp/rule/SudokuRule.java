package ar.fiuba.tdd.tp.rule;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by luciano on 28/09/16.
 */
public class SudokuRule {


    public Boolean check(ArrayList<Integer> values){

        /*Loads all the values in the hash. If they are all different, then the size of the hash
        should be equal to the size of the array*/

        HashMap<Integer,Integer> map = new HashMap<>();
        for( int i = 0;i<values.size();i++){
            map.put(values.get(i),i);
        }
        return (map.size() == values.size());
    }
}
