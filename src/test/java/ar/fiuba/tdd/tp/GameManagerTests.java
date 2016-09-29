package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.cell.KakuroCell;
import ar.fiuba.tdd.tp.gamemanager.KakuroGameManager;
import ar.fiuba.tdd.tp.grid.Grid;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by luciano on 29/09/16.
 */
public class GameManagerTests {

    @Test
    public void testKakuroGameManagerReturnsTrueWhenGameIsWon() {
        //First form a valid kakuro grid
        Grid<KakuroCell> grid = new Grid<>(1, 6);


        grid.setValue(0, 0, new KakuroCell(10, null, null));

        for (int i = 1; i < 5; i++) {
            KakuroCell cell = new KakuroCell(null, null, i);
            cell.setWritable(true);
            grid.setValue(0, i, cell);
        }

        grid.setValue(0, 5, new KakuroCell(null, null, null));

        KakuroGameManager manager = new KakuroGameManager(grid);

        assertTrue(manager.isGameWon());

    }


    @Test
    public void testKakuroGameManagerReturnsFalseWhenGameIsNotWon() {
        //First form a valid kakuro grid
        Grid<KakuroCell> grid = new Grid<>(1, 6);

        grid.setValue(0, 0, new KakuroCell(10, null, null));

        for (int i = 1; i < 5; i++) {
            KakuroCell cell = new KakuroCell(null, null, i * 2);
            cell.setWritable(true);
            grid.setValue(0, i, cell);
        }

        grid.setValue(0, 5, new KakuroCell(null, null, null));

        KakuroGameManager manager = new KakuroGameManager(grid);

        assertFalse(manager.isGameWon());

    }


    @Test
    public void testKakuroGameManagerReturnsTrueWhenGameIsWonWithMultipleDelimiters() {
        //First form a valid kakuro grid
        Grid<KakuroCell> grid = new Grid<>(1, 9);


        grid.setValue(0, 0, new KakuroCell(4, null, null));
        grid.setValue(0, 1, new KakuroCell(null, null, 2));
        grid.getValue(0, 1).setWritable(true);
        grid.setValue(0, 2, new KakuroCell(null, null, 2));
        grid.getValue(0, 2).setWritable(true);
        grid.setValue(0, 3, new KakuroCell(4, null, null));
        grid.setValue(0, 4, new KakuroCell(null, null, 2));
        grid.getValue(0, 4).setWritable(true);
        grid.setValue(0, 5, new KakuroCell(null, null, 2));
        grid.getValue(0, 5).setWritable(true);
        grid.setValue(0, 6, new KakuroCell(4, null, null));
        grid.setValue(0, 7, new KakuroCell(null, null, 2));
        grid.getValue(0, 7).setWritable(true);
        grid.setValue(0, 8, new KakuroCell(null, null, 2));
        grid.getValue(0, 8).setWritable(true);

        /* 0\4  2   2  0\4  2  2  0\4  2  2
         */

        KakuroGameManager manager = new KakuroGameManager(grid);

        assertTrue(manager.isGameWon());

    }

    @Test
    public void testKakuroGameManagerReturnsTrueWhenGameIsWonWithMultipleDirections() {
        //First form a valid kakuro grid
        Grid<KakuroCell> grid = new Grid<>(3, 3);

        grid.setValue(0, 0, new KakuroCell(1, 1, null));
        grid.setValue(0, 1, new KakuroCell(null, null, 1));
        grid.getValue(0, 1).setWritable(true);
        grid.setValue(0, 2, new KakuroCell(null, 1, null));
        grid.setValue(1, 0, new KakuroCell(null, null, 1));
        grid.getValue(1, 0).setWritable(true);
        grid.setValue(1, 1, new KakuroCell(null, null, null));
        grid.setValue(1, 2, new KakuroCell(null, null, 1));
        grid.getValue(1, 2).setWritable(true);
        grid.setValue(2, 0, new KakuroCell(1, null, null));
        grid.setValue(2, 1, new KakuroCell(null, null, 1));
        grid.getValue(2, 1).setWritable(true);
        grid.setValue(2, 2, new KakuroCell(null, null, null));

        /* 1\1  1  1\0
         *  1  0\0  1
         * 0\1  1  0/0
         */

        KakuroGameManager manager = new KakuroGameManager(grid);

        assertTrue(manager.isGameWon());

    }

    @Test
    public void testKakuroGameManagerReturnsFalseWhenOneDirectionIsWrong() {
        //First form a valid kakuro grid
        Grid<KakuroCell> grid = new Grid<>(3, 3);

        grid.setValue(0, 0, new KakuroCell(1, 1, null));
        grid.setValue(0, 1, new KakuroCell(null, null, 1));
        grid.getValue(0, 1).setWritable(true);
        grid.setValue(0, 2, new KakuroCell(null, 1, null));
        grid.setValue(1, 0, new KakuroCell(null, null, 1));
        grid.getValue(1, 0).setWritable(true);
        grid.setValue(1, 1, new KakuroCell(null, null, null));
        grid.setValue(1, 2, new KakuroCell(null, null, 1));
        grid.getValue(1, 2).setWritable(true);
        grid.setValue(2, 0, new KakuroCell(1, null, null));
        grid.setValue(2, 1, new KakuroCell(null, null, 5));
        grid.getValue(2, 1).setWritable(true);
        grid.setValue(2, 2, new KakuroCell(null, null, null));

        /* 1\1  1  1\0
         *  1  0\0  1
         * 0\1  5  0/0
         */

        KakuroGameManager manager = new KakuroGameManager(grid);

        assertFalse(manager.isGameWon());

    }


}
