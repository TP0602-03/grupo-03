package ar.fiuba.tdd.tp.iterator;

import ar.fiuba.tdd.tp.cell.Cell;
import ar.fiuba.tdd.tp.cell.NumericalCell;
import ar.fiuba.tdd.tp.grid.Grid;
import ar.fiuba.tdd.tp.grid.GridHorizontalIterator;

import java.util.ArrayList;

/**
 * Created by joni on 9/28/16.
 */
public abstract class KakuroIterator extends SectionIterator {

    public KakuroIterator(Grid grid) {
        super(grid);
    }

    protected abstract void iterateUntilDelimeter();

    protected abstract ArrayList<Cell> getSectionCells(int row, int column);

    @Override
    public ArrayList<Cell> getCells(int row, int column){
        /*ArrayList<Cell> rowCells = grid.getRow(column);*/
        ArrayList<Cell> sectionCells = this.getSectionCells(row, column);

        Cell currentCell = sectionCells.get(column);
        ArrayList<Cell> cells = new ArrayList<Cell>();

        GridHorizontalIterator iterator = new GridHorizontalIterator(grid,row, column);
        while (iterator.hasLeftNeighbour() && currentCell.isWritable()){
            currentCell = iterator.getLeftNeighbour();
        }

        cells.add(currentCell);

        while (iterator.hasRightNeighbour() && currentCell.isWritable()){
            currentCell = iterator.getRightNeighbour();
            cells.add(currentCell);

        }

        return cells;
    }

}
