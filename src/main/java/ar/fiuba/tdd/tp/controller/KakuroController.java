package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.gamemanager.KakuroGameManager;
import ar.fiuba.tdd.tp.view.BoardGameView;
import ar.fiuba.tdd.tp.view.KakuroDefaultCell;
import ar.fiuba.tdd.tp.view.KakuroEmptyCell;
import ar.fiuba.tdd.tp.view.KakuroValueCell;

/**
 * Created by martin on 9/28/16.
 */
public class KakuroController extends AbstractController {

    BoardGameView view = new BoardGameView();
    KakuroGameManager manager;


    public KakuroController(KakuroGameManager manager){
        this.manager = manager;
    }

    @Override
    public void setView() {
        this.createView();
    }


    @Override
    public void notifyModel(int collumn, int raw, int userInput) {
        manager.setValueOnGrid(collumn,raw,userInput);
    }

    protected void setViewCoordenade(int indexR, int indexC) {
        if (indexC % 3 == 0) {
            KakuroEmptyCell cell = new KakuroEmptyCell();
            view.set(indexR, indexC, cell);
        } else if (indexC % 3 == 1) {
            KakuroDefaultCell cell = new KakuroDefaultCell(this);
            cell.setFirstNumber(1);
            cell.setSecondNumber(2);
            view.set(indexR, indexC, cell);
        } else {
            KakuroValueCell cell = new KakuroValueCell(this);
            cell.setPosition(indexR, indexC);
            cell.setDefault(0);
            view.set(indexR, indexC, cell);
        }
    }

}