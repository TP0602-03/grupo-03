package ar.fiuba.tdd.tp.cell;

/**
 * Created by luciano on 25/09/16.
 * This cell only takes numerical values from 1 to 9
 */
public class OneDigitCell extends NumericalCell{

    public OneDigitCell() { }

    public OneDigitCell(Integer value) {
        this.value = value;
    }

    public void setValue(Integer newValue) {
        if (this.checkValue(newValue)) {
            super.setValue(newValue);
        }
    }

    private Boolean checkValue(Integer newValue) {
        return  (newValue >= 1 && newValue <= 9);
    }

}
