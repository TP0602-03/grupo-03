package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.cell.KakuroCell;
import ar.fiuba.tdd.tp.grid.Grid;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by mvbattan on 29/09/16.
 */
public class KakuroFiller implements IFiller {


    private void setCenter(KakuroCell cell, Long value) {
        cell.setCenter(value.intValue());
    }

    private void setUR(KakuroCell cell, Long value) {

        if (value == null) {
            cell.setUpperRight(null);
        } else {
            cell.setUpperRight(value.intValue());
        }
    }

    private void setLL(KakuroCell cell, Long value) {
        if (value == null) {
            cell.setLowerLeft(null);
        } else {
            cell.setLowerLeft(value.intValue());
        }
    }


    @Override
    public void fill(Grid grid, JSONObject jsonGame) {
        JSONArray values = (JSONArray) jsonGame.get("values");

        for (Object obj : values) {
            JSONObject value = (JSONObject) obj;
            boolean isWritable = (boolean) value.get("isWritable");
            KakuroCell cell = new KakuroCell();
            if (isWritable) {
                this.setCenter(cell, (Long) value.get("content"));
            } else {
                Long readedUpperRight = (Long) value.get("upperRight");

                this.setUR(cell, readedUpperRight);

                Long readedLowerLeft = (Long) value.get("lowerLeft");

                this.setLL(cell, readedLowerLeft);

            }
            int row = ((Long) value.get("y")).intValue();
            int column = ((Long) value.get("x")).intValue();
            cell.setWritable(isWritable);
            grid.setValue(row, column, cell);
        }

    }
}
