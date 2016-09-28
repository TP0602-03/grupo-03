package ar.fiuba.tdd.tp.cell;

public class BarredCell extends Cell {

    protected Integer[] value = null ; //So that an empty cell can be recognised

    public BarredCell() {
        super();
    }

    public void setValue(Integer[] newValue) {
        this.value = newValue;
    }

    public Integer[] getValue() {
        return this.value;
    }

    public Boolean isEmpty() {
        return this.value == null;
    }

    @Override
    public Boolean isWritable(){
        return false;
    }

}