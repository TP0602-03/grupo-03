package com.company;

public abstract class Rule {

    public Rule() {
    }

    public abstract boolean check(SectionIterator iterator, int row, int column);

    public abstract String print();
}
