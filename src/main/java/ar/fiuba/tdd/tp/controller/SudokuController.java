package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.GameView;
import ar.fiuba.tdd.tp.view.BoardGameView;
import ar.fiuba.tdd.tp.view.SudokuCell;

import javax.swing.*;
import java.awt.*;

/**
 * Created by martin on 9/28/16.
 */
public class SudokuController {

    BoardGameView view = new BoardGameView();

    public void setView(){
        int rows = 9;
        int columns = 9;

        // we ask the model for the size


        for (int indexR = 1 ; indexR <= rows; indexR++){
            for (int indexC = 1; indexC <= columns; indexC++){
                // Here we ask the model and we instance
                // the right cell
                // and also the default value (Sudoku we only have one kind of cell)
                SudokuCell cell = new SudokuCell(this, 1);
                Component componentToDisplay = cell;
                cell.setPosition(indexR, indexC );
                view.set(indexR, indexC, cell);
            }
        }

    }

    public void notifyModel(int x, int y, int userInput){
        // Here we notify the model
        System.out.print("fila: ");
        System.out.println(x);
        System.out.print("columna: ");
        System.out.println(y);
        System.out.print("ingresó: ");
        System.out.println(userInput);

        // here we should call the modell
        // we mock it for the moment
        if (userInput==4){
            view.won();
        }
    }

}
