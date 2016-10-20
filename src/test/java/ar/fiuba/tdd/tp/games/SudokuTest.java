package ar.fiuba.tdd.tp.games;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

public class SudokuTest {
    private void printBoard(Game game) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Object num = game.getCell(i, j).getAttribute("num");
                if (num != null) {
                    System.out.print(" " + num + " |");
                } else {
                    System.out.print("   |");
                }

            }
            System.out.println();
            System.out.println("----------------");
        }
    }

    @Test
    public void sudokuTest() throws Exception {

        Parser parser = new Parser("gameFiles/sudoku.json");
        Game game = parser.getGame();


        printBoard(game);


        game.playCell(3, 0, "num", "2");
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());


        game.playCell(1, 0, "num", "1");
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());


        game.playCell(1, 2, "num", "3");
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());

        game.playCell(1, 3, "num", "4");
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());

        game.playCell(2, 1, "num", "3");
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());

        game.playCell(2, 3, "num", "1");
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());

        game.playCell(2, 0, "num", "4");
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());

        game.playCell(0, 3, "num", "2");
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());
        Assert.assertTrue(game.validateRules());
    }
}
