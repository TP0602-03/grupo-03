package ar.fiuba.tdd.tp.view;

import org.json.simple.parser.ParseException;

import java.awt.*;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.*;

public class CellView extends JPanel {

    private final String emptyImage;
    private ImageManager imageGetter;
    private HashMap<String, String> contents = new HashMap<>();

    public CellView(Set<Map.Entry<String, String>> contents, ImageManager imageGetter, String emptyImage) throws IOException, ParseException {

        this.imageGetter = imageGetter;
        this.emptyImage = emptyImage;
        this.setContents(contents);

        generateLabels();
        //this.revalidate();
        //this.repaint();
    }

    public void setBorder() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void setContents(Set<Map.Entry<String, String>> newContents) {
        System.out.println("Called setContents");
        for (Map.Entry<String, String> content : newContents) {
            this.contents.put(content.getKey(), content.getValue());
        }
    }

    public void setHandlers(MouseListener mouseListener) {
        this.addMouseListener(mouseListener);
    }

    public void generateLabels() {
        System.out.println("Called generateLabels");
        this.removeAll();
        this.setLayout(new OverlayLayout(this));
        ImageIcon emptyLabel = this.imageGetter.getImage(emptyImage);
        JLabel label = new JLabel(emptyLabel);
        this.add(label);
        for (String key : contents.keySet()) {
            String value = contents.get(key);
            Icon image = this.imageGetter.getImage(key, value);
            JLabel imageLabel = new JLabel(image);
            this.add(imageLabel);
        }

    }

    public void setContent(String key, String newValue) {
        this.contents.put(key, newValue);
    }

}