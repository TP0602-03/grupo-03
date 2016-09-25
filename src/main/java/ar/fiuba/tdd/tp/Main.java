package ar.fiuba.tdd.tp;

public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid(9, 9);
        Game game = new Game(grid);
        grid.print();
        game.addRule(new DistinctRule(), new SquareIterator(grid));
        game.addRule(new DistinctRule(), new ColumnIterator(grid));
        grid.set(1, 1, new CellValue(2));
        grid.set(2, 1, new CellValue(3));
        grid.set(3, 1, new CellValue(4));
        grid.set(4, 1, new CellValue(5));
        grid.set(5, 1, new CellValue(6));
        grid.set(6, 1, new CellValue(7));
        grid.set(7, 1, new CellValue(8));
        game.setCell(8, 1, new CellValue(9));
        grid.print();
    }
}
