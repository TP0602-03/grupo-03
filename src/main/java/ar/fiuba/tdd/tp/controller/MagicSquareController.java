package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.gamemanager.MagicSquareGameManager;
import ar.fiuba.tdd.tp.gamemanager.SudokuGameManager;
import ar.fiuba.tdd.tp.view.BoardGameView;
import ar.fiuba.tdd.tp.view.SudokuCell;

/**
 * Created by tomi on 06/10/16.
 */
public class MagicSquareController extends AbstractController {
    private BoardGameView view = new BoardGameView();
    private MagicSquareGameManager magicSquareGameManager;

    public MagicSquareController (MagicSquareGameManager magicSquareGameManager){
        this.magicSquareGameManager = magicSquareGameManager;
    }

    @Override
    public void setView() {
        this.createView(3,3);
    }

    @Override
    public void notifyModel(int collumn, int row, int userInput) {
        this.magicSquareGameManager.setValueOnGrid(collumn, row, userInput);
        if (this.magicSquareGameManager.isGameWon()) {
            view.won();
        }
    }

    @Override
    protected void setViewCoordinates(int indexR, int indexC) {
        SudokuCell cell = new SudokuCell(this);
        cell.setPosition(indexR, indexC);
        cell.setDefault(0);
        view.set(indexR, indexC, cell);
    }
}
