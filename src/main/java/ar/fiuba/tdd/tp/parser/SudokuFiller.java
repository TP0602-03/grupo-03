package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.grid.Grid;
import ar.fiuba.tdd.tp.cell.SudokuCell;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by mvbattan on 29/09/16.
 */
public class SudokuFiller implements IFiller {

    @Override
    public void fill(Grid grid, JSONObject jsonGame) {
        JSONArray values = (JSONArray) jsonGame.get("values");
        for (Object obj : values) {
            JSONObject value = (JSONObject) obj;
            int row = ((Long) value.get("x")).intValue();
            int column = ((Long) value.get("y")).intValue();
            int content = ((Long) value.get("content")).intValue();
            SudokuCell cell = new SudokuCell();
            cell.setValue(content);
            grid.setValue(row, column, cell);
        }
    }
}
