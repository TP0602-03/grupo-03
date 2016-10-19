package ar.fiuba.tdd.tp.view;

import javax.swing.*;
import java.awt.*;

public class BoardGameView extends JPanel {

    //private board
    JPanel cellContainer;
    JFrame frame;

    public BoardGameView() {
        cellContainer = new JPanel();

        frame = new JFrame("Grid Game - TP1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.pack();
        frame.add(cellContainer);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        cellContainer.setLayout(new GridBagLayout());

    }


    public void set(int indexR, int indexC, int width, int height, Component cell) {

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = indexC;
        gridBagConstraints.gridy = indexR;
        gridBagConstraints.ipadx = width;
        gridBagConstraints.ipady = height;


        cellContainer.add(cell, gridBagConstraints);


        frame.pack();
    }

    public void won() {
        JOptionPane.showMessageDialog(null, "You won!");
    }
}

