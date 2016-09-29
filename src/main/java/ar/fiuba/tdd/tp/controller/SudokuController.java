package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.gamemanager.SudokuGameManager;
import ar.fiuba.tdd.tp.view.BoardGameView;
import ar.fiuba.tdd.tp.view.SudokuCell;

public class SudokuController extends AbstractController {


    private SudokuGameManager sudokuGameManager;
    private BoardGameView view = new BoardGameView();

    public SudokuController(SudokuGameManager sudokuGameManager) {
        this.sudokuGameManager = sudokuGameManager;
    }

    @Override
    public void setView() {

        this.createView(9,9);

    }

    @Override
    public void notifyModel(int collumn, int raw, int userInput) {
        // Here we notify the model
        System.out.print("fila: ");
        System.out.println(collumn);
        System.out.print("columna: ");
        System.out.println(raw);
        System.out.print("ingresó: ");
        System.out.println(userInput);

        // here we should call the model
        // we mock it for the moment
        /*if (userInput == 4) {
            view.won();
        }*/

        sudokuGameManager.setValueOnGrid(collumn, raw, userInput);
        if (sudokuGameManager.isGameWon()) {
            view.won();
        }

    }

    protected void setViewCoordinates(int indexR, int indexC) {
        // Here we ask the model and we instance
        // the right cell
        // and also the default value (Sudoku we only have one kind of cell)
        int obtainedValue = sudokuGameManager.getValueFromGrid(indexR, indexC);
        SudokuCell cell = new SudokuCell(this);
        cell.setDefault(obtainedValue);
        if (obtainedValue == 0) {
            cell.setNotWritable();
        }
        cell.setPosition(indexR, indexC);
        view.set(indexR, indexC, cell);
    }

}
