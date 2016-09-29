package ar.fiuba.tdd.tp.obtainer;

import ar.fiuba.tdd.tp.cell.SudokuCell;
import ar.fiuba.tdd.tp.grid.Grid;


import java.util.ArrayList;

/**
 * Created by joni on 9/29/16.
 */
public class SudokuObtainer {

    private Grid<SudokuCell> grid;

    public SudokuObtainer(Grid<SudokuCell> grid) {
        this.grid = grid;
    }

    public ArrayList<SudokuCell> getRow(int row) {
        return grid.getRow(row);
    }

    public ArrayList<SudokuCell> getColumn(int column) {
        return grid.getColumn(column);
    }

    public ArrayList<SudokuCell> getSquare(int row, int column) {
        int startRow = 3 * (row / 3);
        int startColumn = 3 * (column / 3);

        ArrayList<SudokuCell> cells = new ArrayList<>();
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColumn; j < startColumn + 3; j++) {
                cells.add(this.grid.getValue(i, j));
            }
        }
        return cells;

    }
}
