package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.cell.InvalidValueTypeException;
import ar.fiuba.tdd.tp.grid.Grid;
import ar.fiuba.tdd.tp.iterator.ColumnIterator;
import ar.fiuba.tdd.tp.iterator.SquareIterator;
import ar.fiuba.tdd.tp.rule.DistinctRule;

public class Main {

    public static void main(String[] args) throws InvalidValueTypeException {
        Grid grid = new Grid(9, 9);
        Game game = new Game(grid);
        grid.print();
        game.addRule(new DistinctRule(), new SquareIterator(grid));
        game.addRule(new DistinctRule(), new ColumnIterator(grid));
        grid.getCell(1, 1).setValue(1);
        grid.getCell(2, 1).setValue(2);
        grid.getCell(3, 1).setValue(3);
        grid.getCell(4, 1).setValue(4);
        grid.getCell(5, 1).setValue(5);
        grid.getCell(6, 1).setValue(6);
        grid.getCell(7, 1).setValue(7);
        game.setCell(8, 1, 9);
        grid.print();
    }
}
