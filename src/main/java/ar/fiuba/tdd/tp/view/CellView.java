package ar.fiuba.tdd.tp.view;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.*;

public class CellView extends JPanel {

    private final String emptyImage;
    private ImageManager imageGetter;
    private HashMap<String, String> contents = new HashMap<>();

    public CellView(Set<Map.Entry<String, String>> contents, ImageManager imageGetter, String emptyImage) throws
            Exception {

        this.imageGetter = imageGetter;
        this.emptyImage = emptyImage;
        setContents(contents);
        generateLabels();

    }

    public void setBorder() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void setContents(Set<Map.Entry<String, String>> newContents) {
        for (Map.Entry<String, String> content : newContents) {
            contents.put(content.getKey(), content.getValue());
        }
    }

    public void setHandlers(MouseListener mouseListener) {
        addMouseListener(mouseListener);
    }

    public void generateLabels() {
        removeAll();
        setLayout(new OverlayLayout(this));
        ImageIcon emptyLabel = imageGetter.getImage(emptyImage);
        JLabel label = new JLabel(emptyLabel);
        add(label);
        for (String key : contents.keySet()) {
            String value = contents.get(key);
            Icon image = imageGetter.getImage(key, value);
            JLabel imageLabel = new JLabel(image);
            add(imageLabel);
        }

    }

    public void setContent(String key, String newValue) {
        contents.put(key, newValue);
    }

}