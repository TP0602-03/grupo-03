package ar.fiuba.tdd.tp.games;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.parser.Parser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SlitherlinkTest {
    @Test
    public void name() throws Exception {
        Parser parser = new Parser("gameFiles/slitherlink.json");
        Game game = parser.getGame();

        game.playCell(0, 0, "top", "topHorizontalPipe");
        game.playCell(0, 0, "left", "leftVerticalPipe");

        game.playCell(0, 1, "top", "topHorizontalPipe");
        game.playCell(0, 1, "right", "rightVerticalPipe");
        game.playCell(0, 1, "bottom", "bottomHorizontalPipe");

        game.playCell(1, 0, "left", "leftVerticalPipe");

        game.playCell(1, 1, "left", "leftVerticalPipe");
        game.playCell(1, 1, "bottom", "bottomHorizontalPipe");

        game.playCell(1, 2, "bottom", "bottomHorizontalPipe");

        game.playCell(2, 0, "left", "leftVerticalPipe");
        game.playCell(2, 0, "bottom", "bottomHorizontalPipe");

        game.playCell(2, 1, "bottom", "bottomHorizontalPipe");

        game.playCell(2, 2, "bottom", "bottomHorizontalPipe");
        game.playCell(2, 2, "right", "rightVerticalPipe");

        System.out.println("game.validateRules() = " + game.validateRules());
        assertTrue(game.validateRules());


    }


}
