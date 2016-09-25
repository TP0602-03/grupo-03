package ar.fiuba.tdd.tp;

public class Main {

    public static void main(String[] args) throws InvalidValueTypeException {
        Grid grid = new Grid(9, 9);
        Game game = new Game(grid);
        grid.print();
        game.addRule(new DistinctRule(), new SquareIterator(grid));
        game.addRule(new DistinctRule(), new ColumnIterator(grid));
        grid.get(1, 1).setValue(1);
        grid.get(2, 1).setValue(2);
        grid.get(3, 1).setValue(3);
        grid.get(4, 1).setValue(4);
        grid.get(5, 1).setValue(5);
        grid.get(6, 1).setValue(6);
        grid.get(7, 1).setValue(7);
        game.setCell(8, 1, 9);
        grid.print();
    }
}
