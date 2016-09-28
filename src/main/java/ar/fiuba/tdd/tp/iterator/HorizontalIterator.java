package ar.fiuba.tdd.tp.iterator;

import ar.fiuba.tdd.tp.cell.Cell;
import ar.fiuba.tdd.tp.grid.Grid;
import ar.fiuba.tdd.tp.grid.GridHorizontalIterator;
import ar.fiuba.tdd.tp.grid.GridIterator;

import java.util.ArrayList;

public class HorizontalIterator extends KakuroIterator {
    public HorizontalIterator(Grid grid) {
        super(grid);
    }

    @Override
    protected void iterateUntilDelimeter(){

    }

    @Override
    protected ArrayList<Cell> getSectionCells(int row, int column){
        return  null;
    }


    @Override
    public String print() {
        return "Section";
    }
}
