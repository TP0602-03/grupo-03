package ar.fiuba.tdd.tp.gamemanager;

import ar.fiuba.tdd.tp.Obtainer.KakuroObtainer;
import ar.fiuba.tdd.tp.Obtainer.SudokuObtainer;
import ar.fiuba.tdd.tp.cell.SudokuCell;
import ar.fiuba.tdd.tp.grid.Grid;
import ar.fiuba.tdd.tp.rule.KakuroRule;
import ar.fiuba.tdd.tp.rule.SudokuRule;

/**
 * Created by luciano on 28/09/16.
 */
public class SudokuGameManager extends GameManager {

    private Grid<SudokuCell> grid;
    private SudokuRule rule;
    private SudokuObtainer obtainer;

    public SudokuGameManager(Grid<SudokuCell> newGrid){
        this.grid = newGrid;
        this.obtainer = new SudokuObtainer(this.grid);
        this.rule = new SudokuRule();

    }

    public Boolean isGameWon(){
        //Has to check the rule for every column,row and square.
        for(int i = 0; i < this.grid.getHeight() ; i++){
            if(!this.rule.check(this.obtainer.getRow(i))) {
                return false;
            }
        }
        for(int i = 0; i < this.grid.getWidth() ; i++){
            if(!this.rule.check(this.obtainer.getColumn(i))) {
                return false;
            }
        }
        for(int i = 0; i < this.grid.getWidth() ; i+=3) {
            for (int j = 0; i < this.grid.getHeight(); i += 3) {
                if (!this.rule.check(this.obtainer.getSquare(i, j))) {
                    return false;
                }
            }
        }
        return true;



    }



    public void setValueOnGrid(int row, int column, int newValue){
        this.grid.getValue(row,column).setValue(newValue);
    }

    public void setGrid(Grid<SudokuCell> newGrid) {
        this.grid = newGrid;
        this.obtainer = new SudokuObtainer(this.grid);
    }
    
    public int getValueFromGrid(int row,int column){
        return this.grid.getValue(row,column).getValue();
    }

}
