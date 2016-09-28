package ar.fiuba.tdd.tp.iterator;

import java.util.ArrayList;

public class RowIterator extends SectionIterator {
    public RowIterator(Grid grid) {
        super(grid);
    }

    @Override
    public ArrayList<Cell> getCells(int row, int column) {
        return grid.getRow(column);
    }

    @Override
    public String print() {
        return "Row";
    }
}
