package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.cell.SudokuCell;
import ar.fiuba.tdd.tp.cells.KakuroCell;
import ar.fiuba.tdd.tp.grid.Grid;
import ar.fiuba.tdd.tp.parser.GridParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by mvbattan on 29/09/16.
 */
public class ParserTests {
    @Test
    public void testParsingASudokuGameShouldBeCorrect() throws ParseException, org.json.simple.parser.ParseException, IOException {
        GridParser gridParser = new GridParser("gameFiles/sudokuGame.json");

        Grid<SudokuCell> grid = new Grid<>(gridParser.getRowsCount(), gridParser.getColumnsCount());
        String gameName = gridParser.loadGridFromFile(grid);

        Assert.assertEquals(gameName, "sudoku");

        SudokuCell cell = grid.getValue(1,1);

        Assert.assertEquals(1, cell.getValue());
    }

    @Test
    public void testParsingAKakuroGameShouldBeCorrect() throws org.json.simple.parser.ParseException, ParseException, IOException {
        GridParser gridParser = new GridParser("gameFiles/kakuroGame.json");

        Grid<KakuroCell> grid = new Grid<>(gridParser.getRowsCount(), gridParser.getColumnsCount());
        String gameName = gridParser.loadGridFromFile(grid);

        Assert.assertEquals(gameName, "kakuro");

        KakuroCell cell = grid.getValue(1,1);

        Assert.assertEquals(new Integer(1), cell.getCenter());
    }
}
