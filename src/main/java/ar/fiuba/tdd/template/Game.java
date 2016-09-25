package ar.fiuba.tdd.template;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private HashMap<Rule,ArrayList<SectionIterator>> rules = new HashMap<>();
    private Grid grid;

    public Game(Grid grid) {
        this.grid = grid;
    }

    public void addRule(Rule rule, SectionIterator iterator){
        rules.putIfAbsent(rule, new ArrayList<>());
        ArrayList<SectionIterator> iterators = rules.get(rule);
        iterators.add(iterator);
    }
    public boolean setCell(int row, int column, CellValue value){
        boolean allRulesValid = true;
        grid.set(row,column,value);
        grid.print();
        for (Rule rule :
                rules.keySet()) {
            for (SectionIterator iterator :
                    rules.get(rule)) {
                System.out.println("Rule " + rule.print() + " - " + iterator.print() + ": " + rule.check(iterator,row,column));
            }
        }
        return allRulesValid;
    }
}
