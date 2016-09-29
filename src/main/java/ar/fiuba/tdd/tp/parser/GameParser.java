package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.cell.KakuroCell;
import ar.fiuba.tdd.tp.cell.SudokuCell;
import ar.fiuba.tdd.tp.controller.Controller;
import ar.fiuba.tdd.tp.controller.KakuroController;
import ar.fiuba.tdd.tp.controller.SudokuController;
import ar.fiuba.tdd.tp.gamemanager.GameManager;
import ar.fiuba.tdd.tp.gamemanager.KakuroGameManager;
import ar.fiuba.tdd.tp.gamemanager.SudokuGameManager;
import ar.fiuba.tdd.tp.grid.Grid;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class GameParser {
    private GridParser gridParser;

    public GameParser() {
    }


    private Controller getKakuro() throws ParseException, java.text.ParseException, IOException {
        Grid<KakuroCell> kakuroCellGrid = new Grid<>(this.gridParser.getRowsCount(), this.gridParser.getColumnsCount());
        this.gridParser.loadGridFromFile(kakuroCellGrid);
        KakuroGameManager kakuroGameManager = new KakuroGameManager(kakuroCellGrid);
        return new KakuroController(kakuroGameManager);
    }

    private Controller getSudoku() throws ParseException, java.text.ParseException, IOException {
        Grid<SudokuCell> sudokuCellGrid = new Grid<>(this.gridParser.getRowsCount(), this.gridParser.getColumnsCount());
        this.gridParser.loadGridFromFile(sudokuCellGrid);
        SudokuGameManager sudokuGameManager = new SudokuGameManager(sudokuCellGrid);

        return new SudokuController(sudokuGameManager);
    }

    public Controller getGameFromFile(String pathToFile) throws ParseException, java.text.ParseException, IOException {
        this.gridParser = new GridParser(pathToFile);
        String gameName = this.gridParser.getGameName();
        // TODO: Delete repeated code !
        if (gameName.equals("kakuro")) {
            return this.getKakuro();

        } else if (gameName.equals("sudoku")) {
            return this.getSudoku();

        }
        throw new java.text.ParseException("Game Name is invalid to create a GameManager", 0);
    }
}
