package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.CellController;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class CellView extends JPanel {

    protected ImageGetter imageGetter = new ImageGetter("gameFiles/images");
    private String content;
    protected Color defaultBackground = Color.WHITE;

    public CellView(String content) {
        this.content = content;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(new JLabel(this.imageGetter.getImage(content)));
        setHandlers();
    }

    private void setHandlers() {
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(content);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}