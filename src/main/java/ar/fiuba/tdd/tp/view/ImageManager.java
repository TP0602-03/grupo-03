package ar.fiuba.tdd.tp.view;

import javafx.util.Pair;

import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Created by mvbattan on 15/10/16.
 */

public class ImageManager {

    private String relativePath;
    private ImageResizer resizer;
    private ImageTranslator imageTranslator;

    public ImageManager(String pathToImages, int rowCount) throws IOException, ParseException {
        this.relativePath = pathToImages;
        this.resizer = new ImageResizer(rowCount);
        this.imageTranslator = new ImageTranslator();
    }

    public ImageIcon getImage(String symbol) {
        String path = this.relativePath + "/" + symbol + ".png";
        ImageIcon auxImageIcon = new ImageIcon(path);
        Image scaledImage = this.resizer.getScreenScaledImage(auxImageIcon.getImage());
        return new ImageIcon(scaledImage);
    }

    public Icon getImage(String key, String value) {
        String translatedValue = this.imageTranslator.translate(new Pair<>(key, value));
        String path = this.relativePath + "/" + translatedValue + ".png";
        ImageIcon auxImageIcon = new ImageIcon(path);
        Image scaledImage = this.resizer.getScreenScaledImage(auxImageIcon.getImage());
        return new ImageIcon(scaledImage);
    }

    public ArrayList<IconValue> getImages(ArrayList<Pair<String, String>> allowedValues) {
        ArrayList<IconValue> iconValues = new ArrayList<>();

        for (Pair<String, String> allowedValue : allowedValues) {
            String translatedValue = this.imageTranslator.translate(allowedValue);
            ImageIcon image = this.getImage(translatedValue);
            String key = allowedValue.getKey();
            String value = allowedValue.getValue();
            IconValue iconValue = new IconValue(image, key, value);
            iconValues.add(iconValue);
        }

        return iconValues;
    }

}
