package ar.fiuba.tdd.tp.grid;

import ar.fiuba.tdd.tp.cell.Cell;

public class GridHorizontalIterator extends GridIterator {

    public GridHorizontalIterator (Grid grid, Integer row, Integer column) {
        super(grid, row, column);
    }

    public Boolean hasRightNeighbour() {
        return column == grid.getWidth();
    }

    public Cell getRightNeighbour() {
        column++;
        return super.getCurrentCell();
    }

    public Boolean hasLeftNeighbour() {
        return column == 0;
    }

    public Cell getLeftNeighbour() {
        column -= 1;
        return super.getCurrentCell();
    }
}
