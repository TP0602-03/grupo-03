package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.Controller;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.border.Border;


public class KakuroEmptyCell extends JPanel implements KeyListener, CellDisplay {


    public KakuroEmptyCell(Controller controller){
        this.setBackground(Color.black);
        Border border = new MatteBorder(1, 1, 0, 0, Color.WHITE);
        this.setBorder(border);
    }

    @Override
    public void setPosition(int x, int y) {
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
