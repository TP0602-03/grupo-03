package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.gamemanager.MagicSquareGameManager;
import org.junit.Test;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


/**
 * Created by martin on 10/7/16.
 */
public class MagicSquareGameManagerTests {

    @Test
    public void testPaly(){
        MagicSquareGameManager myGame = new MagicSquareGameManager();

        int[] moves = new int[] { 6, 1, 8,
                                  7, 5, 3,
                                  2, 9, 4};

        //assertFalse(myGame.isGameWon());

        for (int i = 0; i <  moves.length; i++){
            assertFalse(myGame.isGameWon());
            /*System.out.println("Fila: ");
            System.out.println(i/3 + 1);
            System.out.println("Columna: ");
            System.out.println(i%3 + 1);*/

            myGame.setValueOnGrid(i/3, i%3, moves[i]);

        }

        assertTrue(myGame.isGameWon());
        myGame.setValueOnGrid(2, 2, 1);
        assertFalse(myGame.isGameWon());

    }
}
