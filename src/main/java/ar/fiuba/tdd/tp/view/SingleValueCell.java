package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.Controller;
import ar.fiuba.tdd.tp.controller.SudokuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Maybe here composition of TextField is a better solution than this...
// but it doesn't hurt for the moment
public class SingleValueCell extends CellView implements KeyListener{

    protected int x,y;

    Controller controller;

    TextField textView;

    public SingleValueCell(Controller controller){
        this.textView = new TextField();
        //textView.setText(String.valueOf(defaultValue));


        // here we can add borders //TODO

        textView.addKeyListener(this);
        this.controller = controller;
        this.add(textView, 0);
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
