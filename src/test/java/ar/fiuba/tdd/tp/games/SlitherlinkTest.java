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






        game.playCell(1, 0, "bottom", "true");
        game.playCell(1, 0, "left", "true");
        game.playCell(1, 0, "right", "true");
        game.playCell(0, 0, "left", "true");
        game.playCell(0, 0, "top", "true");


        game.playCell(0, 1, "top", "true");
        //System.out.println("game.validateRules() = " + game.validateRules());

        game.playCell(0, 1, "bottom", "true");
        //System.out.println("game.validateRules() = " + game.validateRules());

        game.playCell(0, 2, "top", "true");
        //System.out.println("game.validateRules() = " + game.validateRules());

        game.playCell(0, 2, "right", "true");
        //System.out.println("game.validateRules() = " + game.validateRules());







        game.playCell(1, 2, "right", "true");
        game.playCell(1, 2, "left", "true");
        //System.out.println("game.validateRules() = " + game.validateRules());


        game.playCell(2, 2, "bottom", "true");
        game.playCell(2, 2, "left", "true");
        game.playCell(2, 2, "right", "true");
        //System.out.println("game.validateRules() = " + game.validateRules());


        System.out.println("game.validateRules() = " + game.validateRules());
        assertTrue(game.validateRules());


    }


}
