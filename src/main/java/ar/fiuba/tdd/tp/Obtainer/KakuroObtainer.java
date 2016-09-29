package ar.fiuba.tdd.tp.Obtainer;

import ar.fiuba.tdd.tp.cell.KakuroCell;
import ar.fiuba.tdd.tp.grid.Grid;

import java.util.ArrayList;

/**
 * Created by joni on 9/29/16.
 */

public class KakuroObtainer {

    private Grid<KakuroCell> grid;

    public KakuroObtainer(Grid<KakuroCell> grid){
        this.grid = grid;
    }

    private ArrayList<KakuroCell> getSection(ArrayList<KakuroCell> cells, int positionToStart){
        KakuroCell current = cells.get(positionToStart);

        int delimeterPosition = iterateUntilDelimeter(cells, current, positionToStart);
        ArrayList<KakuroCell> cellsToReturn = new ArrayList<>();

        int currentPosition = delimeterPosition + 1;
        current = cells.get(currentPosition);
        while (current.isWrittable() && currentPosition < cells.size() - 1){
            cellsToReturn.add(current);
            currentPosition++;
            current = cells.get(currentPosition);
        }

        return cellsToReturn;
    }

    private int iterateUntilDelimeter(ArrayList<KakuroCell> cells, KakuroCell current, int currentPosition) {
        while (currentPosition > 0 && current.isWrittable()){
            currentPosition--;
            current = cells.get(currentPosition);
        }
        return currentPosition;
    }

    public ArrayList<KakuroCell> getHorizontalSection(int row, int column){
        return getSection(grid.getRow(row), column);
    }

    public ArrayList<KakuroCell> getVericalSection(int row, int column){
        return getSection(grid.getColumn(column), row);
    }
}
