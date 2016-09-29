package ar.fiuba.tdd.tp.cell;

public class SudokuCell {
    private Integer value = null;

    public SudokuCell(int i) {
        value = i;
    }

    public SudokuCell() {

    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
