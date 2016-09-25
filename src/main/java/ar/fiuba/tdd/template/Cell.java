package ar.fiuba.tdd.template;


public class Cell {

    public void setValue(int newValue) throws InvalidValueTypeException {

        throw new InvalidValueTypeException("This cell does not accept numbers");
    }

    public int getValue() throws InvalidValueTypeException {
        throw new InvalidValueTypeException("Not a numeric Cell");
    }



}
