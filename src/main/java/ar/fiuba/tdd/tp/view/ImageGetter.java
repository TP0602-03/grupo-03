package ar.fiuba.tdd.tp.view;

import javax.swing.*;

/**
 * Created by mvbattan on 15/10/16.
 */
public class ImageGetter {

    private String relativePath;

    public ImageGetter(String pathToImages) {
        this.relativePath = pathToImages;
    }

    public ImageIcon getImage(String symbol) {
        return new ImageIcon(this.relativePath + "/" + symbol + ".png");
    }
}
