package ar.fiuba.tdd.tp.view;

import java.awt.*;
import javax.swing.*;

public class BoardGameView {

    //private board
    JPanel cellContainer;
    JFrame frame;

    public BoardGameView() {
        cellContainer = new JPanel();

        frame = new JFrame("Grid Game - TP1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        //frame.add(new BoardView(9, 9));
        frame.add(cellContainer);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        cellContainer.setLayout(new GridBagLayout());
    }


    public void set(int indexR, int indexC, Component cell) {

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = indexC;
        gridBagConstraints.gridy = indexR;

        cellContainer.add(cell, gridBagConstraints);


        frame.pack();
    }

    public void won() {
        JOptionPane.showMessageDialog(null, "You won!");
    }
}
