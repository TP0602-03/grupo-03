package ar.fiuba.tdd.tp.cell;


public abstract class Cell {


    public void setValue(int newValue) throws InvalidValueTypeException {

        throw new InvalidValueTypeException("This cell does not accept numbers");



    }

    public Object getValue() throws InvalidValueTypeException {
        throw new InvalidValueTypeException("Not a numeric Cell");
    }

    public Boolean isWritable(){
        return true;
    }
}
