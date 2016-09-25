package ar.fiuba.tdd.tp;

import java.util.ArrayList;

public abstract class SectionIterator {
    protected Grid grid;

    public SectionIterator(Grid grid) {
        this.grid = grid;
    }

    public abstract ArrayList<Cell> getCells(int row, int column);


    public abstract String print();
}
