package ar.fiuba.tdd.tp.view;

import javafx.util.Pair;

import org.json.simple.parser.ParseException;

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
        ImageIcon auxImageIcon = new ImageIcon(this.relativePath + "/" + symbol + ".png");

        return new ImageIcon(this.resizer.getScreenScaledImage(auxImageIcon.getImage()));
    }

    public Icon getImage(String key, String value) {
        String translatedValue = this.imageTranslator.translate(new Pair<String, String>(key, value));
        ImageIcon auxImageIcon = new ImageIcon(this.relativePath + "/" + translatedValue + ".png");
        return new ImageIcon(this.resizer.getScreenScaledImage(auxImageIcon.getImage()));
    }

    public ArrayList<IconValue> getImages(ArrayList<Pair<String, String>> allowedValues) {
        ArrayList<IconValue> iconValues = new ArrayList<>();

        for (Pair<String, String> allowedValue : allowedValues) {
            String translatedValue = this.imageTranslator.translate(allowedValue);
            iconValues.add(new IconValue(this.getImage(translatedValue), allowedValue.getKey(), allowedValue.getValue()));
        }

        return iconValues;
    }


    public Icon getEmptyImage() {
        return this.getImage("NullContent");
    }
}
