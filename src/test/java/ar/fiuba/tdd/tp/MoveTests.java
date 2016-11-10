package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.move.InvalidMove;
import ar.fiuba.tdd.tp.move.InvalidMoveException;
import ar.fiuba.tdd.tp.move.ValidMove;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoveTests {

    @Test
    public void validMoveCreationGetSetOK() {

        ValidMove move = new ValidMove(1, 0, 0, "attribute", "value");

        assertEquals(move.getId(), 1);
        assertEquals(move.getValue(), "value");
        assertEquals(move.getX(), 0);
        assertEquals(move.getY(), 0);
        assertEquals(move.getAttribute(), "attribute");

    }

    @Test
    public void invalidMoveGetIdOK() {

        InvalidMove move = new InvalidMove(1);
        assertEquals(move.getId(), 1);

    }

    @Test
    public void invalidMoveGetValueRaisesException() throws InvalidMoveException {

        InvalidMove move = new InvalidMove(1);

        try {
            move.getValue();
        } catch (Exception exception) {
            assertTrue(exception.getClass() == InvalidMoveException.class);
        }
    }

    @Test
    public void invalidMoveGetXRaisesException() throws InvalidMoveException {

        InvalidMove move = new InvalidMove(1);

        try {
            move.getX();
        } catch (Exception exception) {
            assertTrue(exception.getClass() == InvalidMoveException.class);
        }
    }

    @Test
    public void invalidMoveGetYRaisesException() throws InvalidMoveException {

        InvalidMove move = new InvalidMove(1);

        try {
            move.getY();
        } catch (Exception exception) {
            assertTrue(exception.getClass() == InvalidMoveException.class);
        }
    }

    @Test
    public void invalidMoveGetAttributeRaisesException() throws InvalidMoveException {

        InvalidMove move = new InvalidMove(1);

        try {
            move.getAttribute();
        } catch (Exception exception) {
            assertTrue(exception.getClass() == InvalidMoveException.class);
        }
    }
}

