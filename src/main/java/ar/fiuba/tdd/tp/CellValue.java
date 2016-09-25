package ar.fiuba.tdd.tp;

public class CellValue {
    int value;

    public CellValue(int value) {
        this.value = value;
    }

    public String print() {
        return String.valueOf(this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CellValue)) {
            return false;
        }

        CellValue other = (CellValue) obj;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return this.value;
    }
}
