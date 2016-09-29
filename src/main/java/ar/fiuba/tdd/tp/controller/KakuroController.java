package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.gamemanager.KakuroGameManager;
import ar.fiuba.tdd.tp.view.BoardGameView;
import ar.fiuba.tdd.tp.view.KakuroDefaultCell;
import ar.fiuba.tdd.tp.view.KakuroEmptyCell;
import ar.fiuba.tdd.tp.view.KakuroValueCell;

public class KakuroController extends AbstractController {

    private BoardGameView view = new BoardGameView();
    private KakuroGameManager manager;

    public KakuroController(KakuroGameManager manager) {
        this.manager = manager;
    }

    @Override
    public void setView() {
        this.createView(manager.getGridHeight(),manager.getGridWidth());
    }

    @Override
    public void notifyModel(int row, int column, int userInput) {

        manager.setValueOnGrid(row, column, userInput);
        if (manager.isGameWon()) {
            view.won();
        }
    }

    protected void setViewCoordinates(int indexR, int indexC) {
        if (manager.getCenter(indexR, indexC) != null) {
            KakuroValueCell cell = new KakuroValueCell(this);
            cell.setPosition(indexR, indexC);
            cell.setDefault(manager.getCenter(indexR, indexC));
            view.set(indexR, indexC, cell);
        } else {
            Integer upperRight = manager.getUpperRight(indexR, indexC);
            Integer lowerLeft = manager.getLowerLeft(indexR, indexC);
            if (upperRight == null && lowerLeft == null && manager.getCenter(indexR, indexC) == null) {
                KakuroEmptyCell cell = new KakuroEmptyCell();
                view.set(indexR, indexC, cell);
            } else if (upperRight != null || lowerLeft != null) {
                KakuroDefaultCell cell = new KakuroDefaultCell(this);
                cell.setFirstNumber(upperRight);
                cell.setSecondNumber(lowerLeft);
                view.set(indexR, indexC, cell);
            }
        }


//        if (indexC % 3 == 0) {
//            KakuroEmptyCell cell = new KakuroEmptyCell();
//            view.set(indexR, indexC, cell);
//        } else if (indexC % 3 == 1) {
//            KakuroDefaultCell cell = new KakuroDefaultCell(this);
//            cell.setFirstNumber(1);
//            cell.setSecondNumber(2);
//            view.set(indexR, indexC, cell);
//        } else {
//            KakuroValueCell cell = new KakuroValueCell(this);
//            cell.setPosition(indexR, indexC);
//            cell.setDefault(0);
//            view.set(indexR, indexC, cell);
//        }
    }

}