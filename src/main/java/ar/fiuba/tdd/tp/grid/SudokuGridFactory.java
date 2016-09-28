package ar.fiuba.tdd.tp.grid;

import ar.fiuba.tdd.tp.cell.Cell;
import ar.fiuba.tdd.tp.cell.NumericalCell;
import ar.fiuba.tdd.tp.cell.OneDigitCell;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by luciano on 25/09/16.
 * This class creates grids that follow a Sudoku game structure(All numerical values)
 */
public class SudokuGridFactory extends GridFactory{


    public SudokuGridFactory(){}


    @Override
    protected void loadGrid() {
        if (this.loader != null) {
            this.loader.fillGrid(this.grid);
        }
    }

    public Grid createGrid() {
        this.grid = new SudokuGrid(9,9);
        this.loadGrid();
        return this.grid;
    }

}
