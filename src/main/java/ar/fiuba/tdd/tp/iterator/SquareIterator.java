package ar.fiuba.tdd.tp.iterator;

import ar.fiuba.tdd.tp.cell.Cell;
import ar.fiuba.tdd.tp.grid.Grid;

import java.util.ArrayList;

public class SquareIterator extends SectionIterator {
    public SquareIterator(Grid grid) {
        super(grid);
    }

    @Override
    public ArrayList<Cell> getCells(int row, int column) {
        // Sudoku 3x3 squares
        ArrayList<Cell> array = new ArrayList<>();
        int topLeftRow = row/3;
        int topLeftColumn = column/3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array.add(grid.get(topLeftRow + i, topLeftColumn + j));
            }
        }
        return array;
    }

    @Override
    public String print() {
        return "Square 3x3";
    }

}
