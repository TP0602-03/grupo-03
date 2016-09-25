package com.company;

import java.util.ArrayList;

public abstract class SectionIterator {
    protected Grid grid;

    public SectionIterator (Grid grid) {
        this.grid = grid;
    }

    public abstract ArrayList<CellValue> getCells(int row, int column);


    public abstract String print();
}
