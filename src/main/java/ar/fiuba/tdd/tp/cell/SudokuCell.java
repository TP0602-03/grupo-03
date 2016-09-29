package ar.fiuba.tdd.tp.cell;

public class SudokuCell {

    private Integer value;

    public SudokuCell() {
        this.value = null;
    }

    public SudokuCell(int newValue) {
        this.value = newValue;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
