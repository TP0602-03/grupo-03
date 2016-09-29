package ar.fiuba.tdd.tp.gamemanager;

import ar.fiuba.tdd.tp.cell.KakuroCell;
import ar.fiuba.tdd.tp.grid.Grid;
import ar.fiuba.tdd.tp.obtainer.KakuroObtainer;


import ar.fiuba.tdd.tp.rule.KakuroRule;

import java.util.ArrayList;

public class KakuroGameManager extends GameManager {

    private Grid<KakuroCell> grid;
    private KakuroRule rule;
    private KakuroObtainer obtainer;

    public KakuroGameManager(Grid<KakuroCell> grid) {
        this.grid = grid;
        rule = new KakuroRule();
        obtainer = new KakuroObtainer(grid);
    }

    private boolean checkHorizontalSections() {
        ArrayList<Integer[]> horizontalDelimeters = obtainer.getAllHorizontalDelimetersPosition();
        for (Integer[] delimeterPosition :
                horizontalDelimeters) {
            int delimeter = obtainer.getHorizontalSectionDelimeter(delimeterPosition[0], delimeterPosition[1] + 1);
            ArrayList<KakuroCell> sectionCells = obtainer.getHorizontalSection(delimeterPosition[0], delimeterPosition[1] + 1);
            if (!rule.check(sectionCells, delimeter)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkVerticalSections() {
        ArrayList<Integer[]> verticalDelimeters = obtainer.getAllVerticalDelimetersPosition();
        for (Integer[] delimeterPosition :
                verticalDelimeters) {
            int delimeter = obtainer.getVerticalSectionDelimeter(delimeterPosition[0] + 1, delimeterPosition[1]);
            ArrayList<KakuroCell> sectionCells = obtainer.getVericalSection(delimeterPosition[0] + 1, delimeterPosition[1]);
            if (!rule.check(sectionCells, delimeter)) {
                return false;
            }
        }
        return true;
    }

    public Boolean isGameWon() {
        return checkHorizontalSections() && checkVerticalSections();


    }

    public void setGrid(Grid<KakuroCell> newGrid) {
        this.grid = newGrid;
        obtainer = new KakuroObtainer(newGrid);
    }

    public void setValueOnGrid(int row, int column, int newValue) {
        this.grid.getValue(row, column).setCenter(newValue);
    }

    public int getValueFromGrid(int row, int column) {
        return this.grid.getValue(row, column).getCenter();
    }

}
