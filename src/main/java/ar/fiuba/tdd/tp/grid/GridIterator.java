package ar.fiuba.tdd.tp.grid;

import ar.fiuba.tdd.tp.cell.Cell;

public abstract class GridIterator {

    protected Grid grid;
    protected Integer row;
    protected Integer column;


    public GridIterator(Grid grid, Integer row, Integer column) {
        this.grid = grid;
        this.column = column;
        this.row = row;
    }

    protected Cell getCurrentCell() {
        return grid.getCell(row, column);
    }

}
