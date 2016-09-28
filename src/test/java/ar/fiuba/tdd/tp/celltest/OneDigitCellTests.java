package ar.fiuba.tdd.tp.celltest;

import ar.fiuba.tdd.tp.cell.NumericalCell;
import ar.fiuba.tdd.tp.cell.OneDigitCell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by luciano on 25/09/16.
 */
public class OneDigitCellTests {

    @Test
    public void checkSetGetValue() {
        OneDigitCell ncell = new OneDigitCell();
        ncell.setValue(new Integer(1));
        int returnedValue = ncell.getValue();
        assertEquals(returnedValue, 1);
    }

    @Test
    public void checkCellStartsEmpty() {
        OneDigitCell ncell = new OneDigitCell();
        assertTrue(ncell.isEmpty());
    }

    @Test
    public void checkCellRefusesNotOneDigitNumbers() {
        OneDigitCell ncell = new OneDigitCell();
        ncell.setValue(new Integer(5));
        ncell.setValue(new Integer(20));
        assertEquals(5, (int) ncell.getValue());

    }


}
