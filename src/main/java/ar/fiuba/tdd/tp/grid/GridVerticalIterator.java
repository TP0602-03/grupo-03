package ar.fiuba.tdd.tp.grid;

import ar.fiuba.tdd.tp.cell.Cell;

public class GridVerticalIterator extends GridIterator {

    public GridVerticalIterator(Grid grid, Integer row, Integer column){
        super(grid, row, column);
    }

    public Boolean hasUpperNeighbour(int row, int column){
        return row == grid.getHeight();
    }

    public Cell getUpperNeighbour (int row, int column) {
        return grid.getCell(row + 1, column);
    }

    public Boolean hasNeighbour(int row, int column){
        return column == 0;
    }

    public Cell getLeftNeighbour (int row, int column) {
        return grid.getCell(row, column - 1);
    }
}
