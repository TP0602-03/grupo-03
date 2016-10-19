package ar.fiuba.tdd.tp.games;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.parser.Parser;
import org.junit.Test;

public class CountryTest {
    @Test
    public void test() throws Exception {
        Parser parser = new Parser("gameFiles/country.json");
        Game game = parser.getGame();
    }
}
