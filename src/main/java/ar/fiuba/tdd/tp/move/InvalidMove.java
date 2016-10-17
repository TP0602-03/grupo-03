package ar.fiuba.tdd.tp.move;


/**
 * Created by luciano on 15/10/16.
 */
public class InvalidMove extends Move {


    public InvalidMove(int newId) {
        this.id = newId;
    }

    public int getX() throws InvalidMoveException {
        throw new InvalidMoveException();
    }

    public int getY() throws InvalidMoveException {
        throw new InvalidMoveException();
    }

    public String getValue() throws InvalidMoveException {
        throw new InvalidMoveException();
    }

    public String getAttribute() throws InvalidMoveException {
        throw new InvalidMoveException();
    }

    public Boolean isValid() {
        return Boolean.FALSE;
    }

}
