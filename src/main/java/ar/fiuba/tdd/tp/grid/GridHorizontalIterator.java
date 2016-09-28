package ar.fiuba.tdd.tp.grid;

import ar.fiuba.tdd.tp.cell.Cell;

public class GridHorizontalIterator extends GridIterator {

    public GridHorizontalIterator (Grid grid, Integer row, Integer column) {
        super(grid, row, column);
    }

    public Boolean hasRightNeighbour(int row, int column) {
        return column == grid.getWidth();
    }

    public Cell getRightNeighbour (int row, int column) {
        return grid.getCell(row, column + 1);
    }

    public Boolean hasLeftNeighbour(int row, int column) {
        return column == 0;
    }

    public Cell getLeftNeighbour (int row, int column) {
        return grid.getCell(row, column - 1);
    }
}
