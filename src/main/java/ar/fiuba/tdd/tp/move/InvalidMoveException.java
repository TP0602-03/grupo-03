package ar.fiuba.tdd.tp.move;

/**
 * Created by luciano on 15/10/16.
 */
public class InvalidMoveException extends Exception {


    public InvalidMoveException() {}

    public InvalidMoveException(String message)
    {
        super(message);
    }
}
