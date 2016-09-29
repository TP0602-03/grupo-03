package ar.fiuba.tdd.tp.view;


import ar.fiuba.tdd.tp.controller.Controller;

import java.awt.*;

public class SudokuCell extends SingleValueCellControlable {

    public SudokuCell(Controller controller) {
        super(controller);
    }

    public void setNotWritable() {
        defaultBackground = Color.BLACK;
    }
}
