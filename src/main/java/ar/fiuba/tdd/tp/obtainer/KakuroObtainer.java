package ar.fiuba.tdd.tp.obtainer;

import ar.fiuba.tdd.tp.cell.KakuroCell;
import ar.fiuba.tdd.tp.grid.Grid;

import java.util.ArrayList;

/**
 * Created by joni on 9/29/16.
 */

public class KakuroObtainer {

    private Grid<KakuroCell> grid;

    public KakuroObtainer(Grid<KakuroCell> grid) {
        this.grid = grid;
    }

    private ArrayList<KakuroCell> getSection(ArrayList<KakuroCell> cells, int positionToStart) {
        int delimeterPosition = iterateUntilDelimeter(cells, positionToStart);
        ArrayList<KakuroCell> cellsToReturn = new ArrayList<>();

        int currentPosition = delimeterPosition + 1;

        while (currentPosition < cells.size() && cells.get(currentPosition).isWritable()) {
            System.out.print(currentPosition);
            System.out.print(cells.get(currentPosition).getCenter());
            System.out.println();



            cellsToReturn.add(cells.get(currentPosition));
            currentPosition++;
        }

        return cellsToReturn;
    }

    private KakuroCell getDelimeter(ArrayList<KakuroCell> cells, int positionToStart) {
        return cells.get(iterateUntilDelimeter(cells, positionToStart));
    }

    private int iterateUntilDelimeter(ArrayList<KakuroCell> cells, int currentPosition) {
        KakuroCell current = cells.get(currentPosition);
        while (currentPosition > 0 && current.isWritable()) {
            currentPosition--;
            current = cells.get(currentPosition);
        }
        return currentPosition;
    }

    public int getHorizontalSectionDelimeter(int row, int column) {
        return getDelimeter(grid.getRow(row), column).getUpperRight();
    }

    public ArrayList<KakuroCell> getHorizontalSection(int row, int column) {
        return getSection(grid.getRow(row), column);
    }

    public int getVerticalSectionDelimeter(int row, int column) {
        return getDelimeter(grid.getColumn(column), row).getLowerLeft();
    }

    public ArrayList<KakuroCell> getVericalSection(int row, int column) {
        return getSection(grid.getColumn(column), row);
    }

    public ArrayList<Integer[]> getAllHorizontalDelimetersPosition() {
        ArrayList<Integer[]> delimeters = new ArrayList<>();

        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                if (this.grid.getValue(i,j).isHorizontalDelimeter()) {
                    delimeters.add(new Integer[]{i,j});
                }
            }
        }
        return delimeters;
    }

    public ArrayList<Integer[]> getAllVerticalDelimetersPosition() {
        ArrayList<Integer[]> delimeters = new ArrayList<>();

        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                if (this.grid.getValue(i,j).isVerticalDelimiter()) {
                    delimeters.add(new Integer[]{i,j});
                }
            }
        }
        return delimeters;
    }
}
