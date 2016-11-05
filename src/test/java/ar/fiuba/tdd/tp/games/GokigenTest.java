package ar.fiuba.tdd.tp.games;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.parser.Parser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GokigenTest {

    @Test
    public void test1() throws Exception {
        Parser parser = new Parser("gameFiles/gokigen.json");
        Game game = parser.getGame();

        game.playCell(0, 0, "diagonal", "upToDownDiagonal");

        game.playCell(0, 1, "diagonal", "downToUpDiagonal");

        game.playCell(0, 2, "diagonal", "downToUpDiagonal");

        game.playCell(1, 0, "diagonal", "upToDownDiagonal");

        game.playCell(1, 1, "diagonal", "downToUpDiagonal");

        game.playCell(1, 2, "diagonal", "downToUpDiagonal");

        game.playCell(2, 0, "diagonal", "upToDownDiagonal");

        game.playCell(2, 1, "diagonal", "upToDownDiagonal");

        game.playCell(2, 2, "diagonal", "upToDownDiagonal");

        assertTrue(game.validateRules());
    }

}
