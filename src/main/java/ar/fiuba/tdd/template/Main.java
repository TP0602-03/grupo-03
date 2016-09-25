package ar.fiuba.tdd.template;
public class Main {

    public static void main(String[] args) throws InvalidValueTypeException{
        Grid grid = new Grid(9,9);
        Game game = new Game(grid);
        grid.print();
        game.addRule(new DistinctRule(),new SquareIterator(grid));
        game.addRule(new DistinctRule(),new ColumnIterator(grid));
        game.addRule(new DistinctRule(),new RowIterator(grid));
        grid.set(1,1,2);
        grid.set(2,1,3);
        grid.set(3,1,4);
        grid.set(4,1,5);
        grid.set(5,1,6);
        grid.set(6,1,7);
        grid.set(7,1,8);
        game.setCell(8,1,9);
        grid.print();
    }
}
