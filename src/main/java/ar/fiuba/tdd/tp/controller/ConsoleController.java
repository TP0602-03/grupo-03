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
        this.moveFactory = newMoveFactory;
        this.moveCount = 0;
    }

    private int getCoord(String message) throws IOException {
        String coord = this.getValue(message);

        return Integer.parseInt(coord);
    }

    private String getValue(String message) throws IOException {
        System.out.print(message);
        InputStreamReader streamReader = new InputStreamReader(System.in, Charset.defaultCharset());
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        return bufferedReader.readLine();
    }

    public Move getMove() throws IOException {

        int newId = this.moveCount;
        int positionX = 0;
        int positionY = 0;
        String value = null;
        String attribute = null;

        try {
            positionX = this.getCoord("Set X position: ");
            positionY = this.getCoord("Set Y position: ");
            attribute = this.getValue("Get cell attribute: ");
            value = this.getValue("Set cell value: ");
        } catch (NumberFormatException exception) {
            System.out.println("Invalid value");
        }

        Move moveToReturn = this.moveFactory.createMove(newId, positionX, positionY, attribute, value);

        if (!moveToReturn.isValid()) {
            System.out.println("Invalid Move");
        } else {
            this.moveCount++;
        }
        return moveToReturn;

    }
}
