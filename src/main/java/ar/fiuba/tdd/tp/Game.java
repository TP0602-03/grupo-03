package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.iterator.SectionIterator;
import ar.fiuba.tdd.tp.rule.Rule;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private HashMap<Rule, ArrayList<SectionIterator>> rules = new HashMap<>();
    private Grid grid;

    public Game(Grid grid) {
        this.grid = grid;
    }

    public void addRule(Rule rule, SectionIterator iterator) {
        rules.putIfAbsent(rule, new ArrayList<>());
        ArrayList<SectionIterator> iterators = rules.get(rule);
        iterators.add(iterator);
    }

    public boolean setCell(int row, int column, int value) throws InvalidValueTypeException {
        boolean allRulesValid = true;
        grid.getCell(row,column).setValue(value);

        grid.print();
        for (Rule rule :
                rules.keySet()) {
            for (SectionIterator iterator :
                    rules.get(rule)) {
                System.out.println("Rule " + rule.print() + " - " + iterator.print() + ": " + rule.check(iterator, row, column));
            }
        }
        return true; //cambiar
    }
}
