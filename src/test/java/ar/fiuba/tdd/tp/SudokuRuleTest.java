package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.cell.SudokuCell;
import ar.fiuba.tdd.tp.rule.SudokuRule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by luciano on 28/09/16.
 */
public class SudokuRuleTest {


    @Test
    public void testRulePassesWithAllDifferentElements() {

        ArrayList<SudokuCell> elements = new ArrayList<>();
        for(int i = 1; i < 10 ; i++) {
            SudokuCell cell = new SudokuCell(0);
            cell.setValue(i);
            elements.add(cell);
        }

        SudokuRule rule = new SudokuRule();

        assertTrue(rule.check(elements));

    }

    @Test
    public void testRuleFailsWithTwoEqualElements() {
        ArrayList<SudokuCell> elements = new ArrayList<>();
        for(int i = 1; i < 10 ; i++) {
            SudokuCell cell = new SudokuCell(0);
            cell.setValue(i%2); //So that equal elements appear
            elements.add(cell);
        }

        SudokuRule rule = new SudokuRule();

        assertFalse(rule.check(elements));
    }


}
