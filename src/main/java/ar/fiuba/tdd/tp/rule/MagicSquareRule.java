package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.cell.SudokuCell;

import java.util.ArrayList;
import java.util.HashMap;

public class MagicSquareRule {


        public Boolean check(ArrayList<SudokuCell> cells) {

        /*Loads all the values in the hash. If they are all different, then the size of the hash
        should be equal to the size of the array*/

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < cells.size(); i++) {
                map.put(cells.get(i).getValue(), i);
            }
            return (map.size() == cells.size());
        }
}
