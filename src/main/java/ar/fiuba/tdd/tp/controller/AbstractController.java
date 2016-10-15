package ar.fiuba.tdd.tp.controller;

public abstract class AbstractController implements Controller {

    // model here
    // Model model;


    protected void createView(int rows,int columns) {



        // we ask the model for the size


        for (int indexR = 0; indexR < rows; indexR++) {
            for (int indexC = 0; indexC < columns; indexC++) {
                this.setViewCoordinates(indexR, indexC);
            }
        }

    }

    protected abstract void setViewCoordinates(int indexR, int indexC);

}
