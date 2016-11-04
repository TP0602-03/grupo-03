package ar.fiuba.tdd.tp.view;


import javax.swing.*;
import java.awt.*;


public class BoardGameView extends JPanel {

    //private board
    JPanel cellContainer;
    JPanel vertexContainer;
    JFrame frame;
    GridBagLayout gbl;
    GridBagLayout vgbl;
    OverlayLayout ol;
    public BoardGameView() {

        cellContainer = new JPanel();
        vertexContainer = new JPanel();
        frame = new JFrame("Grid Game - TP1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.pack();
        ol = new OverlayLayout(frame.getContentPane());
        frame.getContentPane().setLayout(ol);
        //frame.add(cellContainer);
        //frame.setLayout(ol);
        frame.add(vertexContainer);
        frame.add(cellContainer);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        gbl = new GridBagLayout();
        cellContainer.setLayout(gbl);
        cellContainer.setOpaque(false);
        vgbl = new GridBagLayout();
        vertexContainer.setLayout(vgbl);
        vertexContainer.setOpaque(false);

    }


    public void setCell(int indexR, int indexC, int width, int height, Component cell) {

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = indexC;
        gridBagConstraints.gridy = indexR;
        gridBagConstraints.ipadx = width;
        gridBagConstraints.ipady = height;


        cellContainer.add(cell, gridBagConstraints);

        frame.pack();
    }

    public void setVertex(int indexR, int indexC, int width, int height, Component vertex) {


        GridBagConstraints vgridBagConstraints = new GridBagConstraints();
        vgridBagConstraints.gridx = indexC;
        vgridBagConstraints.gridy = indexR;

        vgridBagConstraints.ipadx = 0;
        vgridBagConstraints.ipady = 0;
//        vgridBagConstraints.weightx = 1;
//        vgridBagConstraints.weighty = 1;
//        int a=0;
//        int b=0;
//        int c=0;
//        int d=0;
//
//        if(indexR == 0) {
//            a = 0; //top = 0
//            b = 0;
//        }
//        else{
//
//        }
//        if(indexC == 0) {
//
//        }
//        else{
//
//        }
        vgridBagConstraints.insets = new Insets(35, 35, 35, 35);

        vertexContainer.add(vertex, vgridBagConstraints);

        frame.pack();
    }

    public Component getCell(int row, int col) {
        return cellContainer.getComponent(row * gbl.getLayoutDimensions()[0].length + col);
    }

    public Component getVertex(int row, int col) {
        return vertexContainer.getComponent(row * vgbl.getLayoutDimensions()[0].length + col);
    }

    public void won() {
        JOptionPane.showMessageDialog(null, "You won!");
    }
}

