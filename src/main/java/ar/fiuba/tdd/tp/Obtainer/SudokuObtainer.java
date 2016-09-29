package ar.fiuba.tdd.tp.Obtainer;

import ar.fiuba.tdd.tp.cell.SudokuCell;
import ar.fiuba.tdd.tp.grid.Grid;


import java.util.ArrayList;

/**
 * Created by joni on 9/29/16.
 */
public class SudokuObtainer {

    private Grid<SudokuCell> grid;

    public SudokuObtainer(Grid<SudokuCell> grid){
        this.grid = grid;
    }

    public ArrayList<SudokuCell> getRow(int row){
        return grid.getRow(row);
    }

    public ArrayList<SudokuCell> getColumn(int column){
        return grid.getColumn(column);
    }

    public ArrayList<SudokuCell> getSquare(int row, int column){
        int width = (int) Math.sqrt(grid.getWidth());
        int topLeftRow = row / width;
        int topLeftColumn = column / width;

        ArrayList<SudokuCell> cells = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                cells.add(grid.getValue(topLeftRow + i, topLeftColumn + j));
            }
        }
        return cells;
    }
}
