package ar.fiuba.tdd.tp.celltest;

import ar.fiuba.tdd.tp.cell.Cell;
import ar.fiuba.tdd.tp.cell.InvalidValueTypeException;
import ar.fiuba.tdd.tp.cell.NumericalCell;
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
        Cell testedCell = new NumericalCell();
        Throwable exception = null;
        try {
            testedCell.setValue(new Integer(10));
        } catch (Exception ex) {
            exception = ex;
        }
        assertTrue(exception instanceof InvalidValueTypeException);
    }

    @Test
    public void checkgetValueRaiseException() {
        Cell testedCell = new NumericalCell();
        Throwable exception = null;
        try {
            Object returnedValue = testedCell.getValue();
        } catch (Exception ex) {
            exception = ex;
        }
        assertTrue(exception instanceof InvalidValueTypeException);
    }

}
