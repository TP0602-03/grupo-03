package ar.fiuba.tdd.tp.gamemanager;


import ar.fiuba.tdd.tp.cell.SudokuCell;
import ar.fiuba.tdd.tp.grid.Grid;
import ar.fiuba.tdd.tp.obtainer.SudokuObtainer;
import ar.fiuba.tdd.tp.rule.SudokuRule;

/**
 * Created by luciano on 28/09/16.
 */
public class SudokuGameManager extends GameManager {

    private Grid<SudokuCell> grid;
    private SudokuRule rule;
    private SudokuObtainer obtainer;

    public SudokuGameManager(Grid<SudokuCell> newGrid) {
        this.grid = newGrid;
        this.obtainer = new SudokuObtainer(this.grid);
        this.rule = new SudokuRule();
    }

    private boolean checkRows() {
        for (int i = 0; i < this.grid.getHeight(); i++) {
            if (!this.rule.check(this.obtainer.getRow(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumns() {
        for (int i = 0; i < this.grid.getWidth(); i++) {
            if (!this.rule.check(this.obtainer.getColumn(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSquares() {
        for (int i = 0; i < this.grid.getWidth(); i += 3) {
            for (int j = 0; i < this.grid.getHeight(); i += 3) {
                if (!this.rule.check(this.obtainer.getSquare(i, j))) {
                    return false;
                }
            }
        }
        return true;

    }

    public Boolean isGameWon() {
        return this.checkColumns() && this.checkRows() && this.checkSquares();

    }


    public void setValueOnGrid(int row, int column, int newValue) {
        this.grid.getValue(row, column).setValue(newValue);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid.getValue(i, j).getValue() + " ");
            }
            System.out.println();
        }
    }

    public void setGrid(Grid<SudokuCell> newGrid) {
        this.grid = newGrid;
        this.obtainer = new SudokuObtainer(this.grid);
    }

    public int getValueFromGrid(int row, int column) {
        return this.grid.getValue(row, column).getValue();
    }

}
