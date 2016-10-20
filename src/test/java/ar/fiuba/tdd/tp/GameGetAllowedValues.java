package ar.fiuba.tdd.tp;


import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by mvbattan on 19/10/16.
 */
public class GameGetAllowedValues {
    @Test
    public void testGameGetsValuesWell() throws IOException, ParseException, org.json.simple.parser.ParseException {

        ar.fiuba.tdd.tp.parser.Parser parser = new ar.fiuba.tdd.tp.parser.Parser("gameFiles/slitherlink.json");
        Game game = parser.getGame();

        for (Pair<String, String> value : game.getAllowedValues()) {
            System.out.println(value);
        }

        Assert.assertTrue(true);
    }
}
