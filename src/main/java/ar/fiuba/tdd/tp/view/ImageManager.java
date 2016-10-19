package ar.fiuba.tdd.tp.view;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by mvbattan on 15/10/16.
 */
public class ImageManager {

    private String relativePath;

    public ImageManager(String pathToImages) {
        this.relativePath = pathToImages;
    }

    public ImageIcon getImage(String symbol) {
        return new ImageIcon(this.relativePath + "/" + symbol + ".png");
    }

    public ArrayList<IconValue> getImages(ArrayList<String> allowedValues) {
        ArrayList<IconValue> iconValues = new ArrayList<>();

        for (String allowedValue : allowedValues) {
            iconValues.add(new IconValue(this.getImage(allowedValue), allowedValue));
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
