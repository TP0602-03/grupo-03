package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.CellController;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class CellView extends JPanel {

    protected int row;
    protected int column;

    protected ImageGetter imageGetter = new ImageGetter("gameFiles/images");

    protected Color defaultBackground = Color.WHITE;

    public CellView(String content) {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(new JLabel(this.imageGetter.getImage(content)));
    }

}