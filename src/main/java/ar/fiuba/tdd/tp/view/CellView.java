package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.CellController;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

public class CellView extends JPanel {

    protected ImageGetter imageGetter = new ImageGetter("gameFiles/images");
    private ArrayList<String> contents;
    protected Color defaultBackground = Color.WHITE;

    public CellView(ArrayList<String> contents) {
        this.contents = contents;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new OverlayLayout(this));
        this.add(new JLabel(this.imageGetter.getImage("  ")));
        for (String content: contents){
            this.add(new JLabel(this.imageGetter.getImage(content)));
        }
        setHandlers();

    }

    private void setHandlers() {
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(contents.get(0));
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