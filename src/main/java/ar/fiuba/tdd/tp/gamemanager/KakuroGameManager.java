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
        ArrayList<Integer[]> horizontalDelimiters = obtainer.getAllHorizontalDelimitersPosition();
        for (Integer[] delimiterPosition:
             horizontalDelimiters) {
            int delimiter = obtainer.getHorizontalSectionDelimiter(delimiterPosition[0], delimiterPosition[1] + 1);
            ArrayList<KakuroCell> sectionCells = obtainer.getHorizontalSection(delimiterPosition[0], delimiterPosition[1] + 1);
            if (!rule.check(sectionCells,delimiter)){
                return false;
            }
        }

        ArrayList<Integer[]> verticalDelimiters = obtainer.getAllVerticalDelimitersPosition();
        for (Integer[] delimiterPosition:
                verticalDelimiters) {
            int delimiter = obtainer.getVerticalSectionDelimiter(delimiterPosition[0] + 1, delimiterPosition[1]);
            ArrayList<KakuroCell> sectionCells = obtainer.getVerticalSection(delimiterPosition[0] + 1, delimiterPosition[1]);
            if (!rule.check(sectionCells,delimiter)){
                return false;
            }
        }
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
