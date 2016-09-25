package ar.fiuba.tdd.tp;

import java.util.ArrayList;

public class ColumnIterator extends SectionIterator {
    public ColumnIterator(Grid grid) {
        super(grid);
    }

    @Override
    public ArrayList<CellValue> getCells(int row, int column) {
        return grid.getColumn(column);
    }

    @Override
    public String print() {
        return "Column";
    }
}
