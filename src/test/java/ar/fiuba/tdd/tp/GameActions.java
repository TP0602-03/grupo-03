package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.parser.Parser;
import org.junit.Test;

public class GameActions {
    @Test
    public void test() throws Exception {
        Parser parser = new Parser("gameFiles/gokigen.json");
        Game game = parser.getGame();
        game.playCell(0, 0, "diagonal", "/");
        game.validateRules();
    }
}