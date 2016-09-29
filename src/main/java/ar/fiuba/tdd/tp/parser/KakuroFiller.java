package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.cell.KakuroCell;
import ar.fiuba.tdd.tp.grid.Grid;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by mvbattan on 29/09/16.
 */
public class KakuroFiller implements IFiller {

    @Override
    public void fill(Grid grid, JSONObject jsonGame) {
        JSONArray values = (JSONArray) jsonGame.get("values");

        for (Object obj : values) {
            JSONObject value = (JSONObject) obj;
            boolean isWritable = (boolean) value.get("isWritable");

            KakuroCell cell = new KakuroCell();

            if (isWritable) {
                Integer content = ((Long) value.get("content")).intValue();
                cell.setCenter(content);
            } else {
                Long readedUpperRight = (Long) value.get("upperRight");
                Integer upperRight;

                if (readedUpperRight == null) {
                    upperRight = null;
                } else {
                    upperRight = readedUpperRight.intValue();
                }

                Long readedLowerLeft = (Long) value.get("lowerLeft");
                Integer lowerLeft;
                if (readedLowerLeft == null) {
                    lowerLeft = null;
                } else {
                    lowerLeft = (readedLowerLeft).intValue();
                }

                cell.setLowerLeft(lowerLeft);
                cell.setUpperRight(upperRight);
            }

            int row = ((Long) value.get("x")).intValue();
            int column = ((Long) value.get("y")).intValue();
            cell.setWritable(isWritable);
            grid.setValue(row, column, cell);
        }
    }
}
