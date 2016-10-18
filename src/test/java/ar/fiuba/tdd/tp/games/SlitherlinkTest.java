package ar.fiuba.tdd.tp.games;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.parser.Parser;
import org.junit.Test;

public class SlitherlinkTest {
    @Test
    public void name() throws Exception {
        Parser parser = new Parser("gameFiles/slitherlink.json");
        Game game = parser.getGame();

    }
}
