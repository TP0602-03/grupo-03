package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.view.BoardGameView;
import ar.fiuba.tdd.tp.view.IconValue;
import ar.fiuba.tdd.tp.view.MainValuePicker;
import javafx.util.Pair;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
        Object result = mainValuePicker.getValuePicker();
        if (result != null) {
            Pair<String, String> newValue = (Pair<String, String>) result;

            game.playCell(row, col, newValue.getKey(), newValue.getValue());

            board.update();

            //drawVertices();

            //drawCells();

            checkIfGameIsWon();
        }
    }

    private void checkIfGameIsWon() {
        if (game.validateRules()) {
            JFrame frame = new JFrame();
            JOptionPane optionPane = new JOptionPane();
            optionPane.setMessage("##### ***** YOU WIN ***** #####");
            JDialog dialog = optionPane.createDialog(frame, "YOU WIN");
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