package com.company;

import java.util.ArrayList;

public class ColumnIterator extends SectionIterator{
    public ColumnIterator(Grid grid) {
        super(grid);
    }

    @Override
    public ArrayList<CellValue> getCells(int row, int column) {
        ArrayList<CellValue> array = new ArrayList<>();
        for (int i = 0; i < grid.getHeight(); i++) {
            array.add(grid.get(i,column));
        }
        return array;
    }

    @Override
    public String print() {
        return "Column";
    }
}
