package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.MoveFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by luciano on 18/10/16.
 */
public class ConsoleController {

    private MoveFactory moveFactory;
    private int moveCount;

    public ConsoleController(MoveFactory newMoveFactory) {
        moveFactory = newMoveFactory;
        moveCount = 0;
    }

    private int getCoord(String message) throws IOException {
        String coord = getValue(message);

        return Integer.parseInt(coord);
    }

    private String getValue(String message) throws IOException {
        System.out.print(message);
        InputStreamReader streamReader = new InputStreamReader(System.in, Charset.defaultCharset());
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        return bufferedReader.readLine();
    }

    public Move getMove() throws IOException {

        int newId = moveCount;
        int positionX = 0;
        int positionY = 0;
        String value = null;
        String attribute = null;

        try {
            positionX = getCoord("Set X position: ");
            positionY = getCoord("Set Y position: ");
            attribute = getValue("Get cell attribute: ");
            value = getValue("Set cell value: ");
        } catch (NumberFormatException exception) {
            System.out.println("Invalid value");
        }

        Move moveToReturn = moveFactory.createMove(newId, positionX, positionY, attribute, value);

        if (!moveToReturn.isValid()) {
            System.out.println("Invalid Move");
        } else {
            moveCount++;
        }
        return moveToReturn;

    }
}
