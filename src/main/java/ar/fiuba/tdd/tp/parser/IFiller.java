package ar.fiuba.tdd.tp.parser;

import ar.fiuba.tdd.tp.grid.Grid;
import org.json.simple.JSONObject;

public interface IFiller {
    public void fill(Grid grid, JSONObject jsonGame);
}
