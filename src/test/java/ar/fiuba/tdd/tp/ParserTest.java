package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.parser.Parser;

import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by luciano on 20/10/16.
 */
public class ParserTest {

    String sudokuFile = "gameFiles/sudoku.json";

    @Test
    public void restrictionsLoadingIsOK() throws IOException, ParseException, org.json.simple.parser.ParseException {

        Parser parser = new Parser(sudokuFile);
        Game game = parser.getGame();

        System.out.println(game.getAllowedPositions().toString());
        System.out.println(game.getPosibleValues().toString());

    }


}
