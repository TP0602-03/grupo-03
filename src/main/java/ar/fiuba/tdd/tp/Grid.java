package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.cell.Cell;
import ar.fiuba.tdd.tp.cell.InvalidValueTypeException;
import ar.fiuba.tdd.tp.cell.NumericalCell;

import java.util.ArrayList;

public class Grid {
    private ArrayList<ArrayList<Cell>> grid = new ArrayList<ArrayList<Cell>>();

    public Grid(int width, int height) {
        for (int i = 0; i < height; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < width; j++) {
                grid.get(i).add(new NumericalCell(1));
            }
        }

    }

    public int getWidth() {
        return grid.get(0).size();
    }

    public int getHeight() {
        return grid.size();
    }

    public Cell get(int row, int column) {
        return (grid.get(row).get(column));
    }

    public ArrayList<Cell> getRow(int row) {
        ArrayList<Cell> array = new ArrayList<>();
        for (int i = 0; i < getWidth(); i++) {
            array.add(grid.get(row).get(i));
        }
        return array;
    }

    public ArrayList<Cell> getColumn(int column) {
        ArrayList<Cell> array = new ArrayList<>();
        for (int i = 0; i < getHeight(); i++) {
            array.add(grid.get(i).get(column));
        }
        return array;
    }


    public void print() throws InvalidValueTypeException {
        System.out.println("-------------------");
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                System.out.print(grid.get(i).get(j).getValue() + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
}
