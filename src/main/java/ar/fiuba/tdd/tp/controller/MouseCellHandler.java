package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.view.BoardGameView;
import ar.fiuba.tdd.tp.view.CellView;
import ar.fiuba.tdd.tp.view.IconValue;
import ar.fiuba.tdd.tp.view.MainValuePicker;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by ms0359 on 10/15/16.
 */
public class MouseCellHandler implements MouseListener {
    ArrayList<IconValue> content;
    Game game;
    int row, col;
    CellView cellView;
    private BoardGameView board;

    public MouseCellHandler(BoardGameView board, ArrayList<IconValue> content, Game game, int row, int col, CellView cellView) {
        this.board = board;
        this.content = content;
        this.game = game;
        this.row = row;
        this.col = col;
        this.cellView = cellView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        MainValuePicker mainValuePicker = new MainValuePicker(content);
        Pair<String, String> newValue = (Pair<String,String>) mainValuePicker.GetValuePicker((JPanel) e.getSource());
        ArrayList<String> contents = null;
        System.out.println("key is:" + newValue.getKey());
        System.out.println("value is:" + newValue.getValue());
        game.playCell(row,col, newValue.getKey(), newValue.getValue());

        for (int i = 0; i < game.getHeight(); i++) {
            for (int j = 0; j < game.getWidth(); j++) {
                CellView cell = (CellView) board.get(i, j);
                Set<Map.Entry<String, String>> atts = game.getCellKeysValues(i, j);
                for (Map.Entry<String, String> att : atts) {
                    cell.setContent(att.getKey(), att.getValue());
                }
                cell.generateLabels();

            }
        }

        /*cellView.setContent(newValue.getKey(), newValue.getValue());
        cellView.generateLabels();*/
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