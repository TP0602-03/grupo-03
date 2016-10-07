package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.controller.Controller;
import ar.fiuba.tdd.tp.parser.GameParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.IOException;

public class Main {

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                /*JFrame frame = new JFrame("Grid Game - TP1");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new BoardView(9, 9));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);*/

/*                GridParser gridParser = null;
                try {
                    gridParser = new GridParser("gameFiles/sudoku2.json");
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Grid<SudokuCell> grid = new Grid<>(gridParser.getRowsCount(), gridParser.getColumnsCount());
                try {
                    gridParser.loadGridFromFile(grid);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String gameName = gridParser.getGameName();

                SudokuCell cell = grid.getValue(1,1);

                SudokuGameManager gameManager = new SudokuGameManager(grid);
                SudokuController sudokuController = new SudokuController(gameManager);
                sudokuController.setView();*/


                GameParser parser = new GameParser();
                try {
                    Controller controller = parser.getGameFromFile("gameFiles/sudoku2.json");

                    controller.setView();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                /*Controller controller = new MagicSquareController(new MagicSquareGameManager());
                controller.setView();*/

            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}