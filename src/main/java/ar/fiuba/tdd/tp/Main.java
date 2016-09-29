package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.cell.KakuroCell;
import ar.fiuba.tdd.tp.cell.SudokuCell;
import ar.fiuba.tdd.tp.controller.Controller;
import ar.fiuba.tdd.tp.controller.KakuroController;
import ar.fiuba.tdd.tp.controller.SudokuController;
import ar.fiuba.tdd.tp.gamemanager.GameManager;
import ar.fiuba.tdd.tp.gamemanager.KakuroGameManager;
import ar.fiuba.tdd.tp.gamemanager.SudokuGameManager;
import ar.fiuba.tdd.tp.grid.Grid;

import java.awt.*;

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

                // Here we shoud give the model as parameter
                // new ModelSudoku
                //(new SudokuController(ModeloSudoku)).setView();
                //(new SudokuController()).setView();

                // For Kakuro it'd be:
                // new ModelKukuru
                Grid<SudokuCell> grid = new Grid<>(9,9);
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 9; j++) {
                        grid.setValue(i,j,new SudokuCell((j+3*i)%9+1));
                    }
                }

                for (int i = 3; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        grid.setValue(i,j,new SudokuCell((j+3*i+1)%9+1));
                    }
                }

                for (int i = 6; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        grid.setValue(i,j,new SudokuCell((j+3*i+2)%9+1));
                    }
                }

                for (int i = 0; i < 9; i++) {
                    grid.setValue(i,i,new SudokuCell(0));
                }

                SudokuGameManager gameManager = new SudokuGameManager(grid);
                SudokuController sudokuController = new SudokuController(gameManager);
                sudokuController.setView();

            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}