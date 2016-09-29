package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.CellController;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class CellView extends JPanel {

    private Color defaultBackground = Color.WHITE;

    public CellView() {
        addMouseListener(new CellController(this));

        // TODO: Move this to another controller
        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                setCellText(keyEvent);
            }

            @Override
            public void keyTyped(KeyEvent keyEvent) {
                setCellText(keyEvent);
            }
        });

        this.setBackground(defaultBackground);
    }

    private void setCellText(KeyEvent keyEvent) {
        JLabel label = (JLabel) this.getComponent(0);
        label.setText("" + keyEvent.getKeyChar());
    }

    public void setDefaultBackground() {
        this.setBackground(defaultBackground);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(50, 50);
    }
}