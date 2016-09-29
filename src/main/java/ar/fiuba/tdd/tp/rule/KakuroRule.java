package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.cell.KakuroCell;
import java.util.ArrayList;

public class KakuroRule {

    public Boolean check(ArrayList<KakuroCell> values, int sumValue) {

        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i).getCenter();
        }
        return (sum == sumValue);
    }


}
