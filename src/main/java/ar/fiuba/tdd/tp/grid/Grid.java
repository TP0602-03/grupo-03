package ar.fiuba.tdd.tp.grid;

import java.util.ArrayList;

/**
 * Created by luciano on 28/09/16.
 */
public class Grid<T> {

    private ArrayList<ArrayList<T>> values;

    public Grid(int newHeight,int newWidth) {

        this.values = new ArrayList<>(newHeight);
        for (int i = 0; i < newHeight;i++) {
            this.values.add(new ArrayList<T>(newWidth));
            for (int j = 0; j < newWidth; j++) {
                this.values.get(i).add(null);
            }
        }
    }

    public void setValue(int row,int column,T value) {
        this.values.get(row).set(column,value);
    }

    public T getValue(int row,int column) {
        return this.values.get(row).get(column);
    }

    public int getWidth() {
        return this.values.get(0).size();
    }

    public int getHeight() {
        return this.values.size();
    }
}
