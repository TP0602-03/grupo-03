package ar.fiuba.tdd.tp.view;

import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CellView extends JPanel {

    protected ImageManager imageGetter;
    protected Color defaultBackground = Color.WHITE;
    private HashMap<String, String> contents = new HashMap<>();

    public CellView(Set<Map.Entry<String, String>> contents, int gridSize) throws IOException, ParseException {

        this.imageGetter = new ImageManager("gameFiles/images", gridSize);
        this.setContents(contents);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        generateLabels();
    }

    public void setContents(Set<Map.Entry<String, String>> newContents)
    {
        for (Map.Entry<String, String> content : newContents) {
            this.contents.put(content.getKey(), content.getValue());
        }
    }

    public void setHandlers(MouseListener mouseListener) {
        this.addMouseListener(mouseListener);
    }

    public void generateLabels(){
        this.removeAll();

        this.setLayout(new OverlayLayout(this));
        this.add(new JLabel(this.imageGetter.getEmptyImage()));
        for (String key : contents.keySet()) {
            this.add(new JLabel(this.imageGetter.getImage(key, contents.get(key))));
        }
        this.revalidate();
        this.repaint();
    }

    public void setContent(String key, String newValue) {
        this.contents.put(key, newValue);
    }
}