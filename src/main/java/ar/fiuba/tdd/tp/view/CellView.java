package ar.fiuba.tdd.tp.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CellView extends JPanel {

    protected ImageManager imageGetter = new ImageManager("gameFiles/images");
    private ArrayList<String> contents;
    protected Color defaultBackground = Color.WHITE;

    public CellView(ArrayList<String> contents, MouseListener mouseListener) {
        this.contents = contents;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new OverlayLayout(this));
        this.add(new JLabel(this.imageGetter.getImage("  ")));
        for (String content : contents) {
            this.add(new JLabel(this.imageGetter.getImage(content)));
        }
        setHandlers(mouseListener);
    }

    private void setHandlers(MouseListener mouseListener) {
        this.addMouseListener(mouseListener);
    }


}