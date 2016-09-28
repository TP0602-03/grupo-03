package ar.fiuba.tdd.tp.grid;

public abstract class GridIterator {

    private Grid grid;
    protected Integer row;
    protected Integer column;


    public GridIterator(Grid grid, Integer row, Integer column){
        this.grid = grid;
        this.column = column;
        this.row = row;
    }

    public abstract Boolean hasNext();
}
