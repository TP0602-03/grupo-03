package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.cell.Cell;
import ar.fiuba.tdd.tp.iterator.SectionIterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DistinctRule extends Rule {

    @Override
    public boolean check(SectionIterator iterator, int row, int column) {
        ArrayList<Cell> cells = iterator.getCells(row, column);
        Set<Cell> values = new HashSet<>();
        values.addAll(cells);
        return cells.size() == values.size();
    }

    @Override
    public String print() {
        return "Distinct elements";
    }

}


