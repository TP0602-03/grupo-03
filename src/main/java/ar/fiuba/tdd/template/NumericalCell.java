package ar.fiuba.tdd.template;

/**
 * Created by luciano on 24/09/16.
 */
public class NumericalCell extends Cell{

    private int value;

    public NumericalCell(int newValue) {
        this.value = newValue;
    }

    public void setValue(int newValue) {

        this.value = newValue;

    }


    public int getValue() {
        return this.value;
    }
}
