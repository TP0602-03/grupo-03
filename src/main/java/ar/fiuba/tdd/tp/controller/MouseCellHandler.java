package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.view.IconValue;
import ar.fiuba.tdd.tp.view.MainValuePicker;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.StringJoiner;
import javax.swing.*;

/**
 * Created by ms0359 on 10/15/16.
 */
public class MouseCellHandler implements MouseListener {
    IconValue[] content;

    public MouseCellHandler(IconValue[] content){
        this.content = content;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        MainValuePicker mainValuePicker = new MainValuePicker(content);
        mainValuePicker.GetValuePicker((JPanel) e.getSource());
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