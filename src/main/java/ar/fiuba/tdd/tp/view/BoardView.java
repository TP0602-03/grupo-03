package ar.fiuba.tdd.tp.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;


public class BoardView extends JPanel {

    public BoardView(int rows, int cols) {
        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                gridBagConstraints.gridx = col;
                gridBagConstraints.gridy = row;

                JPanel cellView = new JPanel();



                // TODO: SET CUSTOM VALUES FROM FILE
                TextField label = new TextField();
                //Label label = new Label();

                // FIXME Componente generico

                label.setText("1");
                cellView.add(label, 0);
                // END TODO

                // TODO: The board should be focusable, not the cellView
                cellView.setFocusable(true);

                Border border = null;
                if (row < rows - 1) {
                    if (col < rows - 1) {
                        border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                    }
                } else {
                    if (col < cols - 1) {
                        border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    }
                }
                cellView.setBorder(border);
                add(cellView, gridBagConstraints);
            }
        }
    }
}
