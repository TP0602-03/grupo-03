package ar.fiuba.tdd.tp.grid;

import ar.fiuba.tdd.tp.cell.Cell;

public class GridVerticalIterator extends GridIterator {

    public GridVerticalIterator(Grid grid, Integer row, Integer column) {
        super(grid, row, column);
    }

    public Boolean hasUpperNeighbour(int row, int column) {
        return row == grid.getHeight();
    }

    public Cell getUpperNeighbour (int row, int column) {
        row++;
        return super.getCurrentCell();
    }

    public Boolean hasBottomNeighbour(int row, int column) {
        return row == 0;
    }

    public Cell getBottomNeighbour (int row, int column) {
        row--;
        return super.getCurrentCell();
    }
}
