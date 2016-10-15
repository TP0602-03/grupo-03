package ar.fiuba.tdd.tp.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by ms0359 on 10/15/16.
 */
public class MouseCellHandler implements MouseListener {
    ArrayList<String> contents;

    public MouseCellHandler(ArrayList<String> contents){
        this.contents = contents;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(contents.get(0));
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