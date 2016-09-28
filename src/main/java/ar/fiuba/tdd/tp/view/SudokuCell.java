package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.Controller;

import java.awt.event.KeyEvent;


public class SudokuCell extends SingleValueCell implements CellDisplay {
    public SudokuCell(Controller controller) {
        super(controller);
    }

    public void setDefault(int defaultValue){
        textView.setText(String.valueOf(defaultValue));
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        //controller.notifyModel(1,2, Integer.parseInt(this.getText()));

        // if this raises an exception, we should restore the default value in the cell
        // because the model didn't get updated //FIXME
        controller.notifyModel(this.x, this.y, Integer.parseInt(this.textView.getText()));
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
