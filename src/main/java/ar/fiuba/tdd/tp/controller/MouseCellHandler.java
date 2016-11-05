package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.view.BoardGameView;
import ar.fiuba.tdd.tp.view.CellView;
import ar.fiuba.tdd.tp.view.IconValue;
import ar.fiuba.tdd.tp.view.MainValuePicker;
import javafx.util.Pair;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.swing.*;


/**
 * Created by ms0359 on 10/15/16.
 */
public class MouseCellHandler implements MouseListener {
    ArrayList<IconValue> content;
    Game game;
    int row;
    int col;
    private BoardGameView board;

    public MouseCellHandler(BoardGameView board, ArrayList<IconValue> content, Game game, int row, int col) {
        this.board = board;
        this.content = content;
        this.game = game;
        this.row = row;
        this.col = col;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        MainValuePicker mainValuePicker = new MainValuePicker(content);
        Pair<String, String> newValue = (Pair<String, String>) mainValuePicker.getValuePicker();

        game.playCell(row, col, newValue.getKey(), newValue.getValue());

        drawVertices();

        drawCells();

        checkIfGameIsWon();
    }

    private void drawCells() {
        for (int i = 0; i < game.getHeight(); i++) {
            for (int j = 0; j < game.getWidth(); j++) {
                CellView cell = (CellView) board.getCell(i, j);
                Set<Map.Entry<String, String>> atts = game.getCellKeysValues(i, j);
                drawCellView(cell, atts);
            }
        }
    }

    private void drawCellView(CellView cell, Set<Map.Entry<String, String>> atts) {
        for (Map.Entry<String, String> att : atts) {
            cell.setContent(att.getKey(), att.getValue());
        }
        cell.generateLabels();
    }

    private void drawVertices() {
        for (int i = 0; i < game.getHeight() + 1; i++) {
            for (int j = 0; j < game.getWidth() + 1; j++) {
                CellView cell = (CellView) board.getVertex(i, j);
                //Para que no falle CDP :p
                drawCellView(cell, game.getVertexKeysValues(i, j));
            }
        }
    }

    private void checkIfGameIsWon() {
        if (game.validateRules()) {
            JOptionPane optionPane = new JOptionPane();
            optionPane.setMessage("##### ***** YOU WON ***** #####");
            JFrame frame = new JFrame();

            JDialog dialog = optionPane.createDialog(frame, "Move");
            dialog.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {

    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }

    @Override
    public void mouseEntered(MouseEvent event) {

    }

    @Override
    public void mouseExited(MouseEvent event) {

    }
}