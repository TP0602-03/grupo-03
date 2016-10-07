package ar.fiuba.tdd.tp.gamemanager;

import ar.fiuba.tdd.tp.cell.SudokuCell;
import ar.fiuba.tdd.tp.grid.Grid;
import ar.fiuba.tdd.tp.rule.MagicSquareRule;
import ar.fiuba.tdd.tp.rule.SumRule;

/**
 * Created by tomi on 06/10/16.
 */
public class MagicSquareGameManager extends GameManager {

    private Grid<SudokuCell> grid = new Grid<SudokuCell>(3,3);
    private MagicSquareRule unicRUle = new MagicSquareRule();
    private SumRule sumRule = new SumRule();

    public MagicSquareGameManager(){
        fill();

    }

    private boolean checkColumnsUnique() {
        for (int i = 0; i < this.grid.getWidth(); i++) {
            if (!this.unicRUle.check(this.grid.getColumn(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRowsUnique() {
        for (int i = 0; i < this.grid.getHeight(); i++) {
            if (!this.unicRUle.check(this.grid.getRow(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSums(){

        // check collums
        int sum = this.sumRule.check(this.grid.getColumn(0));
        for (int i = 1; i < this.grid.getWidth(); i++) {
            if ((this.sumRule.check(this.grid.getColumn(i))) != sum ){
                return false;
            }

        }

        // check rows
        for (int i = 0; i < this.grid.getHeight(); i++) {
            if ( this.sumRule.check(this.grid.getRow(i)) != sum) {
                return false;
            }
        }

        // check diagonals
        int dianomal1 = this.grid.getValue(0,0).getValue() + this.grid.getValue(1,1).getValue() + this.grid.getValue(2,2).getValue();

        int diagonal2 = this.grid.getValue(0,2).getValue() + this.grid.getValue(1,1).getValue() + this.grid.getValue(2,0).getValue();

        if (dianomal1 != sum && diagonal2 != sum){
            return false;
        }

        return true;

    }

    @Override
    public Boolean isGameWon() {
        return this.checkColumnsUnique() && this.checkRowsUnique() && this.checkSums();
    }

    private void fill(){

        for(int i = 0; i<9; i++){
            SudokuCell cell = new SudokuCell();
            cell.setValue(0);
            grid.setValue(i/3, i%3, cell );
        }
    }

    public void setValueOnGrid(int row, int column, int newValue) {
        //TODO aca no deberia usar grid.setValue()? en vez de grid.getValue().setValue()?
        this.grid.getValue(row, column).setValue(newValue);
    }
}
