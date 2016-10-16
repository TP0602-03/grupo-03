package ar.fiuba.tdd.tp.move;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by luciano on 15/10/16.
 */
public abstract class Move {

    protected int id;

    public abstract String getValue() throws InvalidMoveException;

    public abstract int getX() throws InvalidMoveException;

    public abstract int getY() throws InvalidMoveException;

    public abstract String getAttribute() throws InvalidMoveException;

    public int getId() {
        return this.id;
    }

    public abstract Boolean isValid();

}
