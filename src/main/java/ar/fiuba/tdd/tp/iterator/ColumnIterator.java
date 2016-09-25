package ar.fiuba.tdd.tp.iterator;

import ar.fiuba.tdd.tp.cell.Cell;
import ar.fiuba.tdd.tp.grid.Grid;

import java.util.ArrayList;

public class ColumnIterator extends SectionIterator {
    public ColumnIterator(Grid grid) {
        super(grid);
    }

    @Override
    public ArrayList<Cell> getCells(int row, int column) {
        return grid.getColumn(column);
    }

    @Override
    public String print() {
        return "Column";
    }
}
