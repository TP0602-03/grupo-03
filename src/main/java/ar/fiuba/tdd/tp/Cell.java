package ar.fiuba.tdd.tp;

public class Cell {
    private CellValue value = new CellValue(1);

    public CellValue getValue() {
        return value;
    }

    public void setValue(CellValue value) {
        this.value = value;
    }
}
