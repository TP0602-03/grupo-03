package ar.fiuba.tdd.tp.grid;

import ar.fiuba.tdd.tp.cell.OneDigitCell;

import java.util.ArrayList;

/**
 * Created by joni on 9/28/16.
 */
public class SudokuGrid extends Grid {

    public SudokuGrid(int width, int height) {
        for (int i = 0; i < height; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < width; j++) {
                grid.get(i).add(new OneDigitCell());
            }
        }
    }

}
