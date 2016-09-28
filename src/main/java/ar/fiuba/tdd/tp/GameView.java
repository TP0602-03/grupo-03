package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.controller.SudokuController;
import ar.fiuba.tdd.tp.view.BoardView;
import ar.fiuba.tdd.tp.view.SudokuCell;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;

public class GameView {

    public static void main(String[] args) {
        new GameView();
    }

    public GameView() {
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
                (new SudokuController()).setView();

                // For Kakuro it'd be:
                // new ModelKukuru
                // (new KukuruController()).setView();

            }
        });
    }
}