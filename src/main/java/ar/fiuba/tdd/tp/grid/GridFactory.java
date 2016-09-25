package ar.fiuba.tdd.tp.grid;

/**
 * Created by luciano on 25/09/16.
 * This class handles the construction of different grids according to the game.
 * It changes the type of cell a grid has so that it accepts different types of values
 *
 */



public abstract class GridFactory {

    protected Grid grid;

    public abstract Grid createGrid();

}
