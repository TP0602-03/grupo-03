package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.view.SudokuCell;

public abstract class AbstractController implements Controller {

    // model here
    // Model model;


    protected void createView() {

        // we ask the model for this size
        int rows = 9;
        int columns = 9;

        // we ask the model for the size


        for (int indexR = 0; indexR < rows; indexR++) {
            for (int indexC = 0; indexC < columns; indexC++) {
                this.setViewCoordenade(indexR, indexC);
            }
        }

    }

    protected abstract void setViewCoordenade(int indexR, int indexC);

}
