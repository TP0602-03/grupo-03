package ar.fiuba.tdd.tp.gamemanager;

import ar.fiuba.tdd.tp.cell.SudokuCell;
import ar.fiuba.tdd.tp.grid.Grid;

/**
 * Created by tomi on 06/10/16.
 */
public class MagicSquareGameManager extends GameManager {

    private Grid<SudokuCell> grid = new Grid<SudokuCell>(3,3);

    @Override
    public Boolean isGameWon() {
        return false;

    }

    public void setValueOnGrid(int row, int column, int newValue) {
        //TODO aca no deberia usar grid.setValue()? en vez de grid.getValue().setValue()?
        this.grid.getValue(row, column).setValue(newValue);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid.getValue(i, j).getValue() + " ");
            }
            System.out.println();
        }
    }
}
