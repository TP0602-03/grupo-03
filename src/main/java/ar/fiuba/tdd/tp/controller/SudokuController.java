package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.view.BoardGameView;
import ar.fiuba.tdd.tp.view.SudokuCell;

/**
 * Created by martin on 9/28/16.
 */
public class SudokuController extends AbstractController {

    BoardGameView view = new BoardGameView();

    @Override
    public void setView() {

        this.createView();

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
        if (userInput == 4) {
            view.won();
        }
    }

    protected void setViewCoordenade(int indexR, int indexC) {
        // Here we ask the model and we instance
        // the right cell
        // and also the default value (Sudoku we only have one kind of cell)
        SudokuCell cell = new SudokuCell(this);
        cell.setDefault(1);
        cell.setPosition(indexR, indexC);
        view.set(indexR, indexC, cell);
    }

}
