package ar.fiuba.tdd.tp.games;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

public class SudokuTest {

    @Test
    public void sudokuTest() throws Exception {

        Parser parser = new Parser("gameFiles/sudoku.json");
        Game game = parser.getGame();

        game.playCell(3, 0, "num", "2");

        game.playCell(1, 0, "num", "1");

        game.playCell(1, 2, "num", "3");

        game.playCell(1, 3, "num", "4");

        game.playCell(2, 1, "num", "3");

        game.playCell(2, 3, "num", "1");

        game.playCell(2, 0, "num", "4");

        game.playCell(0, 3, "num", "2");

        Assert.assertTrue(game.validateRules());
    }
}
