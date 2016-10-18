package ar.fiuba.tdd.tp.games;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.parser.Parser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InshiTest {
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
    public void test() throws Exception {
        Parser parser = new Parser("gameFiles/inshi.json");
        Game game = parser.getGame();


        printBoard(game);


        game.playCell(0, 0, "num", 3);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules() + "\n");

        game.playCell(0, 1, "num", 4);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules() + "\n");

        game.playCell(0, 2, "num", 2);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules() + "\n");

        game.playCell(0, 3, "num", 1);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules() + "\n");


        game.playCell(1, 0, "num", 2);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules() + "\n");

        game.playCell(1, 1, "num", 1);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules() + "\n");

        game.playCell(1, 2, "num", 4);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules() + "\n");

        game.playCell(1, 3, "num", 3);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules() + "\n");


        game.playCell(2, 0, "num", 1);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules() + "\n");

        game.playCell(2, 1, "num", 2);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules() + "\n");

        game.playCell(2, 2, "num", 3);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules() + "\n");

        game.playCell(2, 3, "num", 4);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules() + "\n");


        game.playCell(3, 0, "num", 4);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules() + "\n");

        game.playCell(3, 1, "num", 3);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules() + "\n");

        game.playCell(3, 2, "num", 1);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules() + "\n");

        game.playCell(3, 3, "num", 2);
        printBoard(game);
        //System.out.println("rules ok: " + game.validateRules() + "\n");
        assertTrue(game.validateRules());
    }


}