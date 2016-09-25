package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.iterator.SectionIterator;

public abstract class Rule {

    public Rule() {
    }

    public abstract boolean check(SectionIterator iterator, int row, int column);

    public abstract String print();
}
