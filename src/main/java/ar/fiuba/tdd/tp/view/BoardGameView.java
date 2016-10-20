package ar.fiuba.tdd.tp.view;

import javax.swing.*;
import java.awt.*;


public class BoardGameView extends JPanel {

    //private board
    JPanel cellContainer;
    JFrame frame;
    GridBagLayout gbl;

    public BoardGameView() {

        cellContainer = new JPanel();
        frame = new JFrame("Grid Game - TP1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.pack();
        frame.add(cellContainer);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        gbl = new GridBagLayout();
        cellContainer.setLayout(gbl);

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

    public Component get(int row, int col) {
        return cellContainer.getComponent(row * gbl.getLayoutDimensions()[0].length + col);
    }

    public void won() {
        JOptionPane.showMessageDialog(null, "You won!");
    }
}

