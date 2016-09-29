package ar.fiuba.tdd.tp.gamemanager;

import ar.fiuba.tdd.tp.Obtainer.KakuroObtainer;
import ar.fiuba.tdd.tp.cell.KakuroCell;
import ar.fiuba.tdd.tp.grid.Grid;
import ar.fiuba.tdd.tp.rule.KakuroRule;

import java.util.ArrayList;

/**
 * Created by luciano on 29/09/16.
 */
public class KakuroGameManager extends GameManager {

    private Grid<KakuroCell> grid;
    private KakuroRule rule;
    private KakuroObtainer obtainer;

    public KakuroGameManager(Grid<KakuroCell> grid){
        this.grid = grid;
        rule = new KakuroRule();
        obtainer = new KakuroObtainer(grid);
    }

    public Boolean isGameWon(){
        ArrayList<KakuroCell> cells = obtainer.getHorizontalSection(2,2);
        return rule.check(cells,3);
    }

    public void setGrid(Grid<KakuroCell> newGrid) {
        this.grid = newGrid;
    }

    public void setValueOnGrid(int row, int column, int newValue){
        this.grid.getValue(row,column).setCenter(newValue);
    }

    public int getValueFromGrid(int row,int column){
        return this.grid.getValue(row,column).getCenter();
    }

}
