package ar.fiuba.tdd.tp.celltest;

import ar.fiuba.tdd.tp.cell.NumericalCell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by luciano on 24/09/16.
 */
public class NumericalCellTests {





    @Test
    public void checkSetGetValue() {
        NumericalCell ncell = new NumericalCell();
        ncell.setValue(11);
        int returnedValue = ncell.getValue();
        assertEquals(returnedValue, 11);
    }

    @Test
    public void checkCellStartsEmpty() {
        NumericalCell ncell = new NumericalCell();
        assertTrue(ncell.isEmpty());
    }





}
