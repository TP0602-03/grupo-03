package ar.fiuba.tdd.tp;

import java.util.ArrayList;

public class Grid {
    private ArrayList<ArrayList<Cell>> grid = new ArrayList<ArrayList<Cell>>();

    public Grid(int width, int height) {
        for (int i = 0; i < height; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < width; j++) {
                grid.get(i).add(new Cell());
            }
        }

    }

    public int getWidth() {
        return grid.get(0).size();
    }

    public int getHeight() {
        return grid.size();
    }

    public CellValue get(int row, int column) {
        return (grid.get(row).get(column)).getValue();
    }

    public ArrayList<CellValue> getRow(int row) {
        ArrayList<CellValue> array = new ArrayList<>();
        for (int i = 0; i < getWidth(); i++) {
            array.add(grid.get(row).get(i).getValue());
        }
        return array;
    }

    public ArrayList<CellValue> getColumn(int column) {
        ArrayList<CellValue> array = new ArrayList<>();
        for (int i = 0; i < getHeight(); i++) {
            array.add(grid.get(i).get(column).getValue());
        }
        return array;
    }

    public void set(int row, int column, CellValue value) {
        (grid.get(row).get(column)).setValue(value);
    }

    public void print() {
        System.out.println("-------------------");
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                System.out.print(grid.get(i).get(j).getValue().print() + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
}
