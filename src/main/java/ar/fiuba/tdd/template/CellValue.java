package ar.fiuba.tdd.template;
public class CellValue {
    int v;

    public CellValue(int v){
        this.v = v;
    }
    public String print() {
        return String.valueOf(this.v);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)                return false;
        if(!(o instanceof CellValue) ) return false;

        CellValue other = (CellValue) o;
        return this.v == other.v;
    }

    @Override
    public int hashCode() {
        return this.v;
    }
}
