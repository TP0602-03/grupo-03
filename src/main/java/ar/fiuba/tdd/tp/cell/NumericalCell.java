package ar.fiuba.tdd.tp.cell;

/**
 * Created by luciano on 24/09/16.
 */
public class NumericalCell extends Cell {

    protected Integer value = null ; //So that an empty cell can be recognised

    public NumericalCell() {

    }

    public void setValue(int newValue) {

        this.value = newValue;

    }

    public int getValue() {
        return this.value;
    }

    public Boolean isEmpty() {
        return this.value == null;
    }
}
