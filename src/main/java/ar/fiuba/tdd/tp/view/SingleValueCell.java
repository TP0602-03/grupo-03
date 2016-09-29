package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.Controller;

import java.awt.*;


// Maybe here composition of TextField is a better solution than this...
// but it doesn't hurt for the moment
public abstract class SingleValueCell extends CellView {

    protected int raw;
    protected int collumn;

    Controller controller;

    TextField textView;

    public SingleValueCell(Controller controller) {
        this.textView = new TextField();

        this.controller = controller;
        this.add(textView, 0);
    }

}
