package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.rule.KakuroRule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by luciano on 28/09/16.
 */
public class KakuroRuleTests {

    @Test
    public void testPassesWhenAllElementsAddToTheSumValue() {

        ArrayList<Integer> elements = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        KakuroRule rule = new KakuroRule();

        //assertTrue(rule.check(elements,45));

    }

    @Test
    public void testFailsWhenAllElementsDontAddToTheSumValue() {

        ArrayList<Integer> elements = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        KakuroRule rule = new KakuroRule();

        //assertFalse(rule.check(elements,28));

    }
}
