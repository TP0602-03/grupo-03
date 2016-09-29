package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.grid.Grid;
import org.json.simple.JSONObject;

/**
 * Created by mvbattan on 29/09/16.
 */
public interface IFiller {
    public void fill(Grid grid, JSONObject jsonGame);
}
