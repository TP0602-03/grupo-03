package ar.fiuba.tdd.tp.rule;


import ar.fiuba.tdd.tp.cell.SudokuCell;

import java.util.ArrayList;
import java.util.HashMap;

public class SumRule {
    public int check(ArrayList<SudokuCell> cells) {

        /*Loads all the values in the hash. If they are all different, then the size of the hash
        should be equal to the size of the array*/

        int sum = 0;
        for (int i = 0; i < cells.size(); i++) {
            sum += cells.get(i).getValue();
        }
        return sum;
    }
}
