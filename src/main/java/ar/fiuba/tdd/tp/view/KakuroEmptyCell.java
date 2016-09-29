package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.Controller;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;



public class KakuroEmptyCell extends CellView {

    public KakuroEmptyCell() {
        defaultBackground = Color.BLACK;
        this.setBackground(defaultBackground );
        Border border = new MatteBorder(1, 1, 0, 0, Color.WHITE);
        this.setBorder(border);
    }
}
