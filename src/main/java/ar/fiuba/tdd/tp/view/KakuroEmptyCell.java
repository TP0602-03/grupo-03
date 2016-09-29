package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.Controller;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;



public class KakuroEmptyCell extends JPanel {


    public KakuroEmptyCell(Controller controller) {
        this.setBackground(Color.black);
        Border border = new MatteBorder(1, 1, 0, 0, Color.WHITE);
        this.setBorder(border);
    }
}
