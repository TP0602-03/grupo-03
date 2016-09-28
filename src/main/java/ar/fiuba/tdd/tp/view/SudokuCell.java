package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.SudokuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Maybe here composition of TextField is a better solution than this...
// but it doesn't hurt for the moment
public class SudokuCell extends TextField implements KeyListener, CellDisplay{

    private int x,y;

    SudokuController controller;

    public SudokuCell(SudokuController controller, int defaultValue){
        this.setText(String.valueOf(defaultValue));

        this.addKeyListener(this);
        this.controller = controller;
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        //controller.notifyModel(1,2, Integer.parseInt(this.getText()));

        // if this raises an exception, we should restore the default value in the cell
        // because the model didn't get updated //FIXME
        controller.notifyModel(this.x, this.y, Integer.parseInt(this.getText()));
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
