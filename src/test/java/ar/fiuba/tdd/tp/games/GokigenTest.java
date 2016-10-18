package ar.fiuba.tdd.tp.games;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.parser.Parser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GokigenTest {

    @Test
    public void test1() throws Exception {
        Parser parser = new Parser("gameFiles/gokigen.json");
        Game gogiken = parser.getGame();

        gogiken.playCell(0, 0, "diagonal", "\\");
        gogiken.addNodeEdge(new Coord(0, 0), new Coord(1, 1));
        System.out.println("gogiken = " + gogiken.validateRules());

        gogiken.playCell(0, 1, "diagonal", "/");
        gogiken.addNodeEdge(new Coord(1, 1), new Coord(0, 2));
        System.out.println("gogiken = " + gogiken.validateRules());

        gogiken.playCell(0, 2, "diagonal", "/");
        gogiken.addNodeEdge(new Coord(1, 2), new Coord(0, 3));
        System.out.println("gogiken = " + gogiken.validateRules());

        gogiken.playCell(1, 0, "diagonal", "\\");
        gogiken.addNodeEdge(new Coord(1, 0), new Coord(2, 1));
        System.out.println("gogiken = " + gogiken.validateRules());

        gogiken.playCell(1, 1, "diagonal", "/");
        gogiken.addNodeEdge(new Coord(2, 1), new Coord(1, 2));
        System.out.println("gogiken = " + gogiken.validateRules());

        gogiken.playCell(1, 2, "diagonal", "/");
        gogiken.addNodeEdge(new Coord(2, 2), new Coord(1, 3));
        System.out.println("gogiken = " + gogiken.validateRules());

        gogiken.playCell(2, 0, "diagonal", "/");
        gogiken.addNodeEdge(new Coord(2, 0), new Coord(3, 1));
        System.out.println("gogiken = " + gogiken.validateRules());

        gogiken.playCell(2, 1, "diagonal", "/");
        gogiken.addNodeEdge(new Coord(2, 1), new Coord(3, 2));
        System.out.println("gogiken = " + gogiken.validateRules());

        gogiken.playCell(2, 2, "diagonal", "/");
        gogiken.addNodeEdge(new Coord(2, 2), new Coord(3, 3));
        System.out.println("gogiken = " + gogiken.validateRules());
        assertTrue(gogiken.validateRules());
    }

}
