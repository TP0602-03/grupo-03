package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.SudokuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by martin on 9/28/16.
 */
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
        controller.notifyModel(this.x, this.y, Integer.parseInt(this.getText()));
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
