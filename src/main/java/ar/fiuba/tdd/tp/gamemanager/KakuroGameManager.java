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
        ArrayList<Integer[]> horizontalDelimeters = obtainer.getAllHorizontalDelimetersPosition();
        for (Integer[] delimeterPosition:
             horizontalDelimeters) {
            //TODO: this should work without having to add +1 at the end, didn't have time to check it
            int delimeter = obtainer.getHorizontalSectionDelimeter(delimeterPosition[0], delimeterPosition[1] + 1);
            ArrayList<KakuroCell> sectionCells = obtainer.getHorizontalSection(delimeterPosition[0], delimeterPosition[1] + 1);
            if (!rule.check(sectionCells,delimeter)){
                return false;
            }
        }

        //TODO: HACER LO MISMO PARA VERTICAL
        return true;
    }

    public void setGrid(Grid<KakuroCell> newGrid) {
        this.grid = newGrid;
        obtainer = new KakuroObtainer(newGrid);
    }

    public void setValueOnGrid(int row, int column, int newValue){
        this.grid.getValue(row,column).setCenter(newValue);
    }

    public int getValueFromGrid(int row,int column){
        return this.grid.getValue(row,column).getCenter();
    }

}
