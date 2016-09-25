package ar.fiuba.tdd.template;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by luciano on 24/09/16.
 */
public class NumericalCellTests {



    @Test
    public void checkGetValue() {
        NumericalCell ncell = new NumericalCell(10);
        int returnedValue = ncell.getValue();
        assertEquals(returnedValue, 10);
    }

    @Test
    public void checkSetValue() {
        NumericalCell ncell = new NumericalCell(10);
        ncell.setValue(11);
        int returnedValue = ncell.getValue();
        assertEquals(returnedValue, 11);
    }




}
