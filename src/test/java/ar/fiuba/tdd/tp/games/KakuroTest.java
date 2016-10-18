package ar.fiuba.tdd.tp.games;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.Region;
import ar.fiuba.tdd.tp.parser.Parser;
import ar.fiuba.tdd.tp.rule.RuleCheckSum;
import ar.fiuba.tdd.tp.rule.RuleDistinctElements;
import org.junit.Test;

public class KakuroTest {
    @Test
    public void name() throws Exception {
        Parser parser = new Parser("gameFiles/kakuro.json");
        Game game = parser.getGame();



    }
}

