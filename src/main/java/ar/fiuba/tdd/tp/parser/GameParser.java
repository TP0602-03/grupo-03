package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.cell.KakuroCell;
import ar.fiuba.tdd.tp.cell.SudokuCell;
import ar.fiuba.tdd.tp.gamemanager.GameManager;
import ar.fiuba.tdd.tp.gamemanager.KakuroGameManager;
import ar.fiuba.tdd.tp.gamemanager.SudokuGameManager;
import ar.fiuba.tdd.tp.grid.Grid;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by mvbattan on 29/09/16.
 */
public class GameParser {
    private GridParser gridParser;

    public GameParser() {    }

    public GameManager getGameFromFile(String pathToFile) throws ParseException, java.text.ParseException, IOException {
        this.gridParser = new GridParser(pathToFile);
        String gameName = this.gridParser.getGameName();
        // TODO: Delete repeated code !
        if (gameName.equals("kakuro")) {
            KakuroGameManager kakuroGameManager = new KakuroGameManager();
            Grid<KakuroCell> kakuroCellGrid = new Grid<>(this.gridParser.getRowsCount(), this.gridParser.getColumnsCount());
            this.gridParser.loadGridFromFile(kakuroCellGrid);
            kakuroGameManager.setGrid(kakuroCellGrid);
            return kakuroGameManager;
        } else if(gameName.equals("sudoku")) {
            SudokuGameManager sudokuGameManager = new SudokuGameManager();
            Grid<SudokuCell> sudokuCellGrid = new Grid<>(this.gridParser.getRowsCount(), this.gridParser.getColumnsCount());
            this.gridParser.loadGridFromFile(sudokuCellGrid);
            sudokuGameManager.setGrid(sudokuCellGrid);
            return sudokuGameManager;
        }
        throw new java.text.ParseException("Game Name is invalid to create a GameManager", 0);
    }
}
