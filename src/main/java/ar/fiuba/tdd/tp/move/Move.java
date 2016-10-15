package ar.fiuba.tdd.tp.move;

/**
 * Created by luciano on 15/10/16.
 */
public abstract class Move {

    int id;

    public abstract String getValue() throws InvalidMoveException;
    public abstract int getX() throws InvalidMoveException;
    public abstract int getY() throws  InvalidMoveException;

    public int getId() {
        return this.id;
    }

}
