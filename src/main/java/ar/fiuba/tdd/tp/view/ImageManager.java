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
}
