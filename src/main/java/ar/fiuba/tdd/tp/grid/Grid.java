package ar.fiuba.tdd.tp.grid;

import java.util.ArrayList;

public class Grid<T> {

    private ArrayList<ArrayList<T>> values;

    public Grid(int newHeight, int newWidth) {

        this.values = new ArrayList<>(newHeight);
        for (int i = 0; i < newHeight; i++) {
            this.values.add(new ArrayList<T>(newWidth));
            for (int j = 0; j < newWidth; j++) {
                this.values.get(i).add(null);
            }
        }
    }

    public void setValue(int row, int column, T value) {
        this.values.get(row).set(column, value);
    }

    public T getValue(int row, int column) {
        return this.values.get(row).get(column);
    }

    public int getWidth() {
        return this.values.get(0).size();
    }

    public int getHeight() {
        return this.values.size();
    }

    public ArrayList<T> getRow(int row) {
        return this.values.get(row);
    }

    public ArrayList<T> getColumn(int column) {
        ArrayList<T> cells = new ArrayList<T>();
        for (ArrayList<T> row : values) {
            cells.add(row.get(column));
        }
        return cells;
    }

}
