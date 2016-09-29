package ar.fiuba.tdd.tp.gamemanager;

import ar.fiuba.tdd.tp.cell.SudokuCell;
import ar.fiuba.tdd.tp.grid.Grid;

/**
 * Created by luciano on 28/09/16.
 */
public class SudokuGameManager extends GameManager {

    private Grid<SudokuCell> grid;

    public Boolean isGameWon(){
        return true;
    }

    public void setGrid(Grid<SudokuCell> newGrid) {
        this.grid = newGrid;
    }

    public void setValueOnGrid(int row, int column, int newValue){
        this.grid.getValue(row,column).setValue(newValue);
    }

    public int getValueFromGrid(int row,int column){
        return this.grid.getValue(row,column).getValue();
    }

}
