package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.graph.Coord;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordTests {

    @Test
    public void coordGetX() {
        Coord coordinate = new Coord(1, 1);
        Integer num = 1;
        assertEquals(coordinate.getCoordinateX(), num);
    }

    @Test
    public void coordGetY() {
        Coord coordinate = new Coord(2, 2);
        Integer num = 2;
        assertEquals(coordinate.getCoordinateY(), num);
    }

}
