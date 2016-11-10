package ar.fiuba.tdd.tp.games;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.parser.Parser;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CountryTest {
    @Test
    public void test() throws Exception {
        Parser parser = new Parser("gameFiles/country.json");
        Game game = parser.getGame();

        game.playCell(0, 0, "lines", "se");

        game.playCell(0, 1, "lines", "we");

        game.playCell(0, 2, "lines", "sw");

        game.playCell(1, 0, "lines", "ns");

        game.playCell(1, 1, "lines", "se");

        game.playCell(1, 2, "lines", "nw");

        game.playCell(2, 0, "lines", "ne");

        game.playCell(2, 1, "lines", "nw");
        assertTrue(game.validateRules());

        game.playCell(2, 1, "lines", "nw");
        assertTrue(game.validateRules());

        game.playCell(2, 1, "lines", "ne");
        assertFalse(game.validateRules());

        game.playCell(2, 1, "lines", "nw");
        assertTrue(game.validateRules());
    }
}
