package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.grid.Grid;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by luciano on 28/09/16.
 */
public class GridTests {

    @Test
    public void testGridCreation() {
        Grid<Integer> grid = new Grid<Integer>(5, 10);

        assertEquals(grid.getHeight(), 5);
        assertEquals(grid.getWidth(), 10);

    }

    @Test
    public void testSetGetValue() {
        Grid<Integer> grid = new Grid<Integer>(5, 10);

        grid.setValue(4, 2, 20);
        int returnValue = grid.getValue(4, 2);
        assertEquals(returnValue, 20);


    }


    @Test
    public void testCorrectWidthAndHeight() {

        int width = 5;
        int height = 10;
        Grid<Integer> grid = new Grid<Integer>(height, width);

        assertEquals(width, grid.getWidth());
        assertEquals(height, grid.getHeight());


    }
}
