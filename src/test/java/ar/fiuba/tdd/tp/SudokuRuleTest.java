package ar.fiuba.tdd.tp;

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

        ArrayList<Integer> elements = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        SudokuRule rule = new SudokuRule();

        assertTrue(rule.check(elements));

    }

    @Test
    public void testRuleFailsWithTwoEqualElements() {
        ArrayList<Integer> elements = new ArrayList<>(Arrays.asList(1,2,3,4,5,5,7,8,9));

        SudokuRule rule = new SudokuRule();

        assertFalse(rule.check(elements));
    }


}
