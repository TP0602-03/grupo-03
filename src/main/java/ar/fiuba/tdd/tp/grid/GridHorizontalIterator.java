package ar.fiuba.tdd.tp.grid;

public class GridHorizontalIterator extends GridIterator {

    public GridHorizontalIterator (Grid grid, Integer row, Integer column){
        super(grid, row, column);
    }

    @Override
    public Boolean hasNext(){
        return false;
    }
}
