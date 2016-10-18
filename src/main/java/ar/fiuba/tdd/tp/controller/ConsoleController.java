package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.move.Move;
import ar.fiuba.tdd.tp.move.MoveFactory;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

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

    private int getCoord(String message) throws IOException{
        String coord = this.getValue(message);
        return Integer.parseInt(coord);
    }

    private String getValue(String message) throws IOException {
        System.out.print(message);
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        return bufferedReader.readLine();
    }

    public Move getMove() throws IOException{

        Console console = System.console();
        int newId = this.moveCount;

        int positionX = this.getCoord("Set X position: ");
        int positionY = this.getCoord("Set Y position: ");
        String value = this.getValue("Set cell value: ");


        Move moveToReturn = this.moveFactory.createMove(newId,positionX,positionY,value);

        if(!moveToReturn.isValid()){
            System.out.println("Invalid Move");
        }
         return moveToReturn;

    }
}
