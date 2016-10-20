package ar.fiuba.tdd.tp.view;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by mvbattan on 19/10/16.
 */
public class ImageTranslator {

    private HashMap<String, String> translateDict;

    public ImageTranslator() {
        this.translateDict = new HashMap<>();
        this.translateDict.put("small_num", "leftTop");
        this.translateDict.put("left", "leftVerticalPipe");
        this.translateDict.put("bottom", "bottomHorizontalPipe");
        this.translateDict.put("top", "topHorizontalPipe");
        this.translateDict.put("right", "rightVerticalPipe");
    }

    public String translate(Pair<String, String> allowedValue) {
        String trailingData = allowedValue.getValue();

        if (allowedValue.getKey() != "small_num") trailingData = "";

        return this.translateDict.get(allowedValue.getKey()) + trailingData;
    }
}
