package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.controller.KakuroController;
import ar.fiuba.tdd.tp.controller.SudokuController;

import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

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
                // (new SudokuController()).setView();

                // For Kakuro it'd be:
                // new ModelKukuru
                (new KakuroController()).setView();

            }
        });
    }
}