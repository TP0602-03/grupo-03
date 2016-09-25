package ar.fiuba.tdd.tp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by luciano on 24/09/16.
 *
 */
public class CellTests {

    @Test
    public void checkSetValueRaiseException() {
        Cell testedCell = new Cell();
        Throwable exception = null;
        try {
            testedCell.setValue(10);
        } catch (Exception ex) {
            exception = ex;
        }
        assertTrue(exception instanceof InvalidValueTypeException);
    }

    @Test
    public void checkgetValueRaiseException() {
        Cell testedCell = new Cell();
        Throwable exception = null;
        try {
            int returnedValue = testedCell.getValue();
        } catch (Exception ex) {
            exception = ex;
        }
        assertTrue(exception instanceof InvalidValueTypeException);
    }

}
