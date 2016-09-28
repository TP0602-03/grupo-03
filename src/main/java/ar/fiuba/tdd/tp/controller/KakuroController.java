package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.view.BoardGameView;
import ar.fiuba.tdd.tp.view.KakuroDefaultCell;
import ar.fiuba.tdd.tp.view.KakuroEmptyCell;

/**
 * Created by martin on 9/28/16.
 */
public class KakuroController implements Controller {

    BoardGameView view = new BoardGameView();


    @Override
    public void setView() {
        int rows = 9;
        int columns = 9;

        // we ask the model for the size


        for (int indexR = 1 ; indexR <= rows; indexR++){
            for (int indexC = 1; indexC <= columns; indexC++){
                // Here we ask the model and we instance
                // the right cell
                // and also the default value (Sudoku we only have one kind of cell)

                //KakuroEmptyCell cell = new KakuroEmptyCell(this);
                KakuroDefaultCell cell = new KakuroDefaultCell(this);
                cell.setFirstNumber(1);
                cell.setSecondNumber(2);
                // cell.setPosition(indexR, indexC );
                view.set(indexR, indexC, cell);
            }
        }
    }

    @Override
    public void notifyModel(int x, int y, int userInput) {

    }
}
