package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.view.CellView;
import ar.fiuba.tdd.tp.view.IconValue;
import ar.fiuba.tdd.tp.view.MainValuePicker;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by ms0359 on 10/15/16.
 */
public class MouseCellHandler implements MouseListener {
    ArrayList<IconValue> content;
    Game game;
    int row, col;
    CellView cellView;

    public MouseCellHandler(ArrayList<IconValue> content, Game game, int row, int col, CellView cellView) {
        this.content = content;
        this.game = game;
        this.row = row;
        this.col = col;
        this.cellView = cellView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        MainValuePicker mainValuePicker = new MainValuePicker(content);
        String newValue = (String) mainValuePicker.GetValuePicker((JPanel) e.getSource());
        ArrayList<String> contents = null;
        game.playCell(row,col, "num", newValue);
        for (int i = 0; i < game.getWidth(); i++) {
            for (int j = 0; j < game.getHeight(); j++) {
                contents = new ArrayList<String>();
                for (Map.Entry<String, String> key : game.getCellKeysValues(i, j)) {
                    String content;
                    try {
                        content = key.getValue().toString();
                    } catch (Exception ex) {
                        content = "  ";
                    }
                    contents.add(content);
                }
            }
        }
        cellView.setContents(contents);
        cellView.generateLabels();
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