package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.Obtainer.KakuroObtainer;
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
    public void testKakuroGameManagerReturnsTrueWhenGameIsWon(){
        //First form a valid kakuro grid
        Grid<KakuroCell> grid = new Grid<>(1,6);

        grid.setValue(0,0,new KakuroCell(10,null,null));
        grid.setValue(0,1,new KakuroCell(null,null,1));
        grid.setValue(0,2,new KakuroCell(null,null,2));
        grid.setValue(0,3,new KakuroCell(null,null,3));
        grid.setValue(0,4,new KakuroCell(null,null,4));
        grid.setValue(0,5,new KakuroCell(null,null,null));

        KakuroGameManager manager = new KakuroGameManager(grid);

        assertTrue(manager.isGameWon());
        
    }


    @Test
    public void testKakuroGameManagerReturnsFalseWhenGameIsNotWon(){
        //First form a valid kakuro grid
        Grid<KakuroCell> grid = new Grid<>(1,6);

        grid.setValue(0,0,new KakuroCell(10,null,null));
        grid.setValue(0,1,new KakuroCell(null,null,1));
        grid.setValue(0,2,new KakuroCell(null,null,2));
        grid.setValue(0,3,new KakuroCell(null,null,5));
        grid.setValue(0,4,new KakuroCell(null,null,4));
        grid.setValue(0,5,new KakuroCell(null,null,null));

        KakuroGameManager manager = new KakuroGameManager(grid);

        assertFalse(manager.isGameWon());

    }


    @Test
    public void testKakuroGameManagerReturnsTrueWhenGameIsWonWithMultipleDelimiters(){
        //First form a valid kakuro grid
        Grid<KakuroCell> grid = new Grid<>(1,10);

        grid.setValue(0,0,new KakuroCell(4,null,null));
        grid.setValue(0,1,new KakuroCell(null,null,2));
        grid.setValue(0,2,new KakuroCell(null,null,2));
        grid.setValue(0,3,new KakuroCell(4,null,null));
        grid.setValue(0,4,new KakuroCell(null,null,2));
        grid.setValue(0,5,new KakuroCell(null,null,2));
        grid.setValue(0,6,new KakuroCell(4,null,null));
        grid.setValue(0,7,new KakuroCell(null,null,2));
        grid.setValue(0,8,new KakuroCell(null,null,2));
        


        KakuroGameManager manager = new KakuroGameManager(grid);

        assertTrue(manager.isGameWon());

    }


}
