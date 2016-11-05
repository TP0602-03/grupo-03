package ar.fiuba.tdd.tp.games;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.parser.Parser;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InshiTest {

    @Test
    public void test() throws Exception {
        Parser parser = new Parser("gameFiles/inshi.json");
        Game game = parser.getGame();

        game.playCell(0, 0, "num", "3");

        game.playCell(0, 1, "num", "4");

        game.playCell(0, 2, "num", "2");

        game.playCell(0, 3, "num", "1");

        game.playCell(1, 0, "num", "2");

        game.playCell(1, 1, "num", "1");

        game.playCell(1, 2, "num", "4");

        game.playCell(1, 3, "num", "3");

        game.playCell(2, 0, "num", "1");

        game.playCell(2, 1, "num", "2");

        game.playCell(2, 2, "num", "3");

        game.playCell(2, 3, "num", "4");

        game.playCell(3, 0, "num", "4");

        game.playCell(3, 1, "num", "3");

        game.playCell(3, 2, "num", "1");

        game.playCell(3, 3, "num", "2");

        assertTrue(game.validateRules());
    }


}