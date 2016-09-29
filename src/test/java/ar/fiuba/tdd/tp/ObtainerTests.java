package ar.fiuba.tdd.tp;


import ar.fiuba.tdd.tp.cell.KakuroCell;
import ar.fiuba.tdd.tp.cell.SudokuCell;
import ar.fiuba.tdd.tp.grid.Grid;
import ar.fiuba.tdd.tp.obtainer.KakuroObtainer;
import ar.fiuba.tdd.tp.obtainer.SudokuObtainer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by luciano on 29/09/16.
 */
public class ObtainerTests {

    @Test
    public void testSudokuSquareObtainer() {
        Grid<SudokuCell> grid = new Grid<>(9, 9);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                SudokuCell cell = new SudokuCell();
                cell.setValue(i * 10 + j);
                grid.setValue(i, j, cell);
            }
        }

        SudokuObtainer obtainer = new SudokuObtainer(grid);


        ArrayList<SudokuCell> square = obtainer.getSquare(4, 4);
        ArrayList<Integer> expectedValues = new ArrayList<>(Arrays.asList(33, 34, 35, 43, 44, 45, 53, 54, 55));

        for (int i = 0; i < square.size(); i++) {
            assertTrue(expectedValues.contains(square.get(i).getValue()));
        }


    }

    @Test
    public void testKakuroHorizontalObtainerWithOneCell() {

        //First form a valid kakuro grid
        Grid<KakuroCell> grid = new Grid<>(3, 3); //3x3 should be enough

        grid.setValue(0, 0, new KakuroCell(1, null, null));
        grid.setValue(0, 1, new KakuroCell(null, null, 1));
        grid.getValue(0,1).setWritable(true);
        grid.setValue(0, 2, new KakuroCell(null, null, null));

        KakuroObtainer obtainer = new KakuroObtainer(grid);

        ArrayList<KakuroCell> cells = obtainer.getHorizontalSection(0, 1);

        assertTrue(cells.size() == 1);
        assertTrue(cells.get(0).getCenter() == 1);

    }

    @Test
    public void testKakuroHorizontalObtainerWith5Cells() {

        //First form a valid kakuro grid
        Grid<KakuroCell> grid = new Grid<>(6, 6);

        grid.setValue(0, 0, new KakuroCell(10, null, null));
        grid.setValue(0, 1, new KakuroCell(null, null, 1));
        grid.getValue(0,1).setWritable(true);
        grid.setValue(0, 2, new KakuroCell(null, null, 2));
        grid.getValue(0,2).setWritable(true);
        grid.setValue(0, 3, new KakuroCell(null, null, 3));
        grid.getValue(0,3).setWritable(true);
        grid.setValue(0, 4, new KakuroCell(null, null, 4));
        grid.getValue(0,4).setWritable(true);
        grid.setValue(0, 5, new KakuroCell(null, null, null));

        KakuroObtainer obtainer = new KakuroObtainer(grid);

        ArrayList<KakuroCell> cells = obtainer.getHorizontalSection(0, 1);

        assertTrue(cells.size() == 4);

        for (int i = 0; i < cells.size(); i++) {
            assertTrue(cells.get(i).getCenter() == i + 1);
        }

    }


}
