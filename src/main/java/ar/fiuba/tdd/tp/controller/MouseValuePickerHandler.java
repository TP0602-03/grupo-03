package ar.fiuba.tdd.tp.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by ms0359 on 10/15/16.
 */
public class MouseValuePickerHandler implements MouseListener {

    String content;

    public MouseValuePickerHandler(String content){
        this.content = content;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(content);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}