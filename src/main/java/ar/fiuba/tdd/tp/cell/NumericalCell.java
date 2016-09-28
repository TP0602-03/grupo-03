package ar.fiuba.tdd.tp.cell;

/**
 * Created by luciano on 24/09/16.
 */
public class NumericalCell extends Cell {

    protected Integer value = null ; //So that an empty cell can be recognised

    public NumericalCell() {

        super();
    }

    public void setValue(Integer newValue) {
        this.value = newValue;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    public Boolean isEmpty() {
        return this.value == null;
    }

}
