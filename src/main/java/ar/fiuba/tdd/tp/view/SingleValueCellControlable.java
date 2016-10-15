package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class SingleValueCellControlable extends SingleValueCell implements CellDisplay, KeyListener {

    String lastValue;

    public SingleValueCellControlable(Controller controller) {
        super(controller);
        this.textView.addKeyListener(this);
    }

    public void setDefault(int defaultValue) {
        this.textView.setText(String.valueOf(defaultValue));
        lastValue = this.textView.getText();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        try {
            String textInWidget = this.textView.getText();
            if (!textInWidget.isEmpty()) {
                controller.notifyModel(this.row, this.column, Integer.parseInt(textInWidget));
            }
            lastValue = textInWidget;
        } catch (java.lang.NumberFormatException e) {
            this.textView.setText(lastValue);
        }
    }

    @Override
    public void setPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

}
