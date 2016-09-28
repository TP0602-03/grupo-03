package ar.fiuba.tdd.tp.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * Created by martin on 9/28/16.
 */
public class BoardGameView {

    //private board
    JPanel cellContainer;
    JFrame frame;

    public BoardGameView(){
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


    public void set(int indexR, int indexC, Component sudokuCell) {

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = indexC;
        gridBagConstraints.gridy = indexR;

        JPanel cellView = new JPanel();

        // TODO: SET CUSTOM VALUES FROM FILE
        //Label label = new Label();

        // FIXME Componente generico


        cellView.add(sudokuCell, 0);

        Border border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
        cellView.setBorder(border);

        cellContainer.add(cellView, gridBagConstraints);


        frame.pack();
    }

    public void won() {
        JOptionPane.showMessageDialog(null, "You won!");
    }
}

