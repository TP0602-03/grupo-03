package ar.fiuba.tdd.tp.view;

import javafx.util.Pair;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by mvbattan on 15/10/16.
 */
public class ImageManager {

    private String relativePath;
    private ImageResizer resizer;
    private ImageTranslator imageTranslator;

    public ImageManager(String pathToImages, int rowCount) {
        this.relativePath = pathToImages;
        this.resizer = new ImageResizer(rowCount);
        this.imageTranslator = new ImageTranslator();
    }

    public ImageIcon getImage(String symbol) {
        ImageIcon auxImageIcon = new ImageIcon(this.relativePath + "/" + symbol + ".png");

        return new ImageIcon(this.resizer.getScreenScaledImage(auxImageIcon.getImage()));
    }

    public ArrayList<IconValue> getImages(ArrayList<Pair<String, String>> allowedValues) {
        ArrayList<IconValue> iconValues = new ArrayList<>();

        for (Pair<String,String> allowedValue : allowedValues) {
            String translatedValue = this.imageTranslator.translate(allowedValue);
            iconValues.add(new IconValue(this.getImage(translatedValue), translatedValue));
        }

        return iconValues;
    }

    public Icon getImage(String key, String value) {
        String symbol = value;
        if (key.compareTo("small_num") == 0) {
            symbol = "leftTop" + value;
        }

        return this.getImage(symbol);
    }

    public Icon getEmptyImage() {
        return this.getImage("NullContent");
    }
}
