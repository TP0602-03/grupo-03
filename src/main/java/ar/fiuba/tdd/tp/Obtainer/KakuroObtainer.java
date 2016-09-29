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
        int delimiterPosition = iterateUntilDelimiter(cells, positionToStart);
        ArrayList<KakuroCell> cellsToReturn = new ArrayList<>();

        int currentPosition = delimiterPosition + 1;
        KakuroCell current = cells.get(currentPosition);
        while (current.isWritable() && currentPosition < cells.size() - 1){
            cellsToReturn.add(current);
            currentPosition++;
            current = cells.get(currentPosition);
        }

        return cellsToReturn;
    }

    private KakuroCell getDelimiter(ArrayList<KakuroCell> cells, int positionToStart){
        return cells.get(iterateUntilDelimiter(cells, positionToStart));
    }

    private int iterateUntilDelimiter(ArrayList<KakuroCell> cells, int currentPosition) {
        KakuroCell current = cells.get(currentPosition);
        while (currentPosition > 0 && current.isWritable()){
            currentPosition--;
            current = cells.get(currentPosition);
        }
        return currentPosition;
    }

    public int getHorizontalSectionDelimiter(int row, int column){
        return getDelimiter(grid.getRow(row), column).getUpperRight();
    }

    public ArrayList<KakuroCell> getHorizontalSection(int row, int column){
        return getSection(grid.getRow(row), column);
    }

    public int getVerticalSectionDelimiter(int row, int column){
        return getDelimiter(grid.getColumn(column), row).getLowerLeft();
    }

    public ArrayList<KakuroCell> getVerticalSection(int row, int column){
        return getSection(grid.getColumn(column), row);
    }

    public ArrayList<Integer[]> getAllHorizontalDelimitersPosition(){
        ArrayList<Integer[]> delimiters = new ArrayList<>();

        for (int i = 0; i < grid.getHeight(); i++){
            for (int j = 0; j < grid.getWidth(); j++){
                if (this.grid.getValue(i,j).isHorizontalDelimiter()){
                    delimiters.add(new Integer[]{i,j});
                }
            }
        }
        return delimiters;
    }

    public ArrayList<Integer[]> getAllVerticalDelimitersPosition(){
        ArrayList<Integer[]> delimiters = new ArrayList<>();

        for (int i = 0; i < grid.getHeight(); i++){
            for (int j = 0; j < grid.getWidth(); j++){
                if (this.grid.getValue(i,j).isVerticalDelimiter()){
                    delimiters.add(new Integer[]{i,j});
                }
            }
        }
        return delimiters;
    }
}
