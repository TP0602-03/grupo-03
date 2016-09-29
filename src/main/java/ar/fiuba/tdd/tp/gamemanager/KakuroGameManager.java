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
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(grid.getValue(i, j).getCenter() + " ");
//            }
//            System.out.println();
//        }
    }

    public Integer getCenter(int row, int column) {
        return this.grid.getValue(row, column).getCenter();
    }

    public Integer getUpperRight(int row, int column) {
        return this.grid.getValue(row, column).getUpperRight();
    }

    public Integer getLowerLeft(int row, int column) {
        return this.grid.getValue(row, column).getLowerLeft();
    }

    public int getValueFromGrid(int row, int column) {
        return this.grid.getValue(row, column).getCenter();
    }

}
