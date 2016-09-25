package ar.fiuba.tdd.template;
import java.util.ArrayList;

public class RowIterator extends SectionIterator{
    public RowIterator(Grid grid) {
        super(grid);
    }

    @Override
    public ArrayList<Cell> getCells(int row, int column) {
        ArrayList<Cell> array = new ArrayList<>();
        for (int i = 0; i < grid.getWidth(); i++) {
            array.add(grid.get(row,i));
        }
        return array;
    }

    @Override
    public String print() {
        return "Row";
    }
}
