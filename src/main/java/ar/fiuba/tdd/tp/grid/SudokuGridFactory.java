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

    private void createEmptySudokuGrid() {

        int height = 9;
        int width = 9;
        this.grid = new Grid(height,width); //A sudoku grid has 9x9 elements

        //Has to turn every cell in the grid to a numerical one
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.grid.setCell(i,j,new OneDigitCell());
            }
        }
    }

    public Grid createGrid() {

        this.createEmptySudokuGrid();
        this.loadGrid();
        return this.grid;
    }

}
