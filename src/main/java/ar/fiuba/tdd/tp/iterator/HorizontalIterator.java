package ar.fiuba.tdd.tp.iterator;

import ar.fiuba.tdd.tp.cell.Cell;
import ar.fiuba.tdd.tp.grid.Grid;

import java.util.ArrayList;

public class HorizontalIterator extends SectionIterator {
    public HorizontalIterator(Grid grid) {
        super(grid);
    }

    @Override
    public ArrayList<Cell> getCells(int row, int column) {
        ArrayList<Cell> rowCells = grid.getRow(column);

        Cell currentCell = rowCells.get(column);
        ArrayList<Cell> cells = new ArrayList<Cell>();

        cells.add(currentCell);

        return null;
    }

    @Override
    public String print() {
        return "Row";
    }
}
