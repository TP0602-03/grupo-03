package ar.fiuba.tdd.tp.grid;

import ar.fiuba.tdd.tp.cell.OneDigitCell;
import ar.fiuba.tdd.tp.cell.UnreachableCell;

/**
 * Created by luciano on 28/09/16.
 */
public class KakuroGridFactory extends GridFactory {

    public KakuroGridFactory(){}


    @Override
    protected void loadGrid() {
        if (this.loader != null) {
            this.loader.fillGrid(this.grid);
        }
    }

    private void createEmptyKakuroGrid() {

        int height = 9;
        int width = 9;
        this.grid = new Grid(height,width);

        //Has to turn every cell in the grid to an unreachable one
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.grid.setCell(i,j,new UnreachableCell());
            }
        }
    }

    public Grid createGrid() {

        this.createEmptyKakuroGrid();
        this.loadGrid();
        return this.grid;
    }
}
