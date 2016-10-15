package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.move.InvalidMove;
import ar.fiuba.tdd.tp.move.InvalidMoveException;
import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.ValidMove;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by luciano on 15/10/16.
 */
public class MoveTests {

    @Test
    public void ValidMoveCreationGetSetOK(){

        ValidMove move = new ValidMove(1,0,0,"value");

        assertEquals(move.getId(),1);
        assertEquals(move.getValue(),"value");
        assertEquals(move.getX(),0);
        assertEquals(move.getY(),0);

    }

    @Test
    public void InvalidMoveGetIdOK(){

        InvalidMove move = new InvalidMove(1);
        assertEquals(move.getId(),1);

    }

    @Test
    public void InvalidMoveGetRaisesException() throws InvalidMoveException {

        InvalidMove move = new InvalidMove(1);

        try {
            move.getValue();
        } catch ( Exception exception ) {
            assertTrue(exception.getClass() == InvalidMoveException.class);
        }


        try {
            move.getX();
        } catch ( Exception exception ) {
            assertTrue(exception.getClass() == InvalidMoveException.class);
        }


        try {
            move.getY();
        } catch ( Exception exception ) {
            assertTrue(exception.getClass() == InvalidMoveException.class);
        }


    }
}

