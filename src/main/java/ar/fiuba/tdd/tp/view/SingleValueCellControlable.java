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
                controller.notifyModel(this.raw, this.collumn, Integer.parseInt(textInWidget));
            }
            lastValue = textInWidget;
        } catch (java.lang.NumberFormatException e) {
            this.textView.setText(lastValue);
        }


    }

    @Override
    public void setPosition(int raw, int collumn) {
        this.raw = raw;
        this.collumn = collumn;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

}
