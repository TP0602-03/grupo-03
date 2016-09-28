package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.view.CellView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CellController extends MouseAdapter {
    private CellView cellView;

    public CellController(CellView cellView) {
        super();
        this.cellView = cellView;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        cellView.setBackground(Color.BLUE);
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        cellView.setDefaultBackground();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        cellView.setBackground(Color.RED);
    }
}
