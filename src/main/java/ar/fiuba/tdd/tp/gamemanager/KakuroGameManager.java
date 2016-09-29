package ar.fiuba.tdd.tp.gamemanager;

import ar.fiuba.tdd.tp.cell.KakuroCell;
import ar.fiuba.tdd.tp.cell.SudokuCell;
import ar.fiuba.tdd.tp.grid.Grid;

/**
 * Created by luciano on 29/09/16.
 */
public class KakuroGameManager extends GameManager {

    private Grid<KakuroCell> grid;

    public Boolean isGameWon(){
        return true;
    }

    public void setGrid(Grid<KakuroCell> newGrid) {
        this.grid = newGrid;
    }

    public void setValueOnGrid(int row, int column, int newValue){
        this.grid.getValue(row,column).setCenter(newValue);
    }

    public int getValueFromGrid(int row,int column){
        return this.grid.getValue(row,column).getCenter();
    }

}
