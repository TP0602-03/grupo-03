package ar.fiuba.tdd.tp.gridtest;

import ar.fiuba.tdd.tp.cell.InvalidValueTypeException;
import ar.fiuba.tdd.tp.grid.Grid;
import ar.fiuba.tdd.tp.grid.SudokuGridFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by luciano on 25/09/16.
 */
public class SodokuFactoryTest {

    @Test
    public void testGettingCorrectDimensions() {
        SudokuGridFactory factory = new SudokuGridFactory();
        Grid grid = factory.createGrid();

        assertEquals(9,grid.getWidth());

        assertEquals(9,grid.getHeight());

    }

    @Test
    public void testGettingCorrectTypeOfCell() throws InvalidValueTypeException {
        SudokuGridFactory factory = new SudokuGridFactory();
        Grid grid = factory.createGrid();

        for (int i = 0;i < 9;i++) {
            for (int j = 0; j < 9 ; j++) {
                grid.get(i, j).setValue(5);
                assertEquals(grid.get(i,j).getValue(),5);
            }
        }

    }

}
