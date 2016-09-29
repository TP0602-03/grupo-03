package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.cell.KakuroCell;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by luciano on 28/09/16.
 */
public class KakuroRule {

    public Boolean check(ArrayList<KakuroCell> values, int sumValue) {

        int sum = 0;
        for ( int i = 0;i < values.size();i++) {
            sum += values.get(i).getCenter();
        }
        return (sum == sumValue);
    }


}
