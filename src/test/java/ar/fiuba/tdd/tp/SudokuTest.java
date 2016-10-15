package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.parser.Parser;
import org.junit.Test;
import org.junit.Assert;

public class SudokuTest {
    @Test
    public void sudokuTest() throws Exception {

        Parser parser = new Parser("gameFiles/sudoku.json");
        Game game = parser.getGame();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Object a = game.getCell(i,j).getAttribute("num");
                if (a != null) {
                    System.out.print(" " + a + " |");
                } else {
                    System.out.print("   |");
                }

            }
            System.out.println();
            System.out.println("----------------");
        }

        game.playCell(0,3,"num",2);
        game.validateRules();

    }
}
