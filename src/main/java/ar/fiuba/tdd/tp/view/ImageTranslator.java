package ar.fiuba.tdd.tp.view;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by mvbattan on 19/10/16.
 */
public class ImageTranslator {

    private HashMap<String, String> translateDict;
    private HashMap<String, Pair<String, String>> retroTranslateDict;

    public ImageTranslator() {
        this.translateDict = new HashMap<>();
        this.translateDict.put("small_num", "leftTop");
        this.translateDict.put("left", "leftVerticalPipe");
        this.translateDict.put("bottom", "bottomHorizontalPipe");
        this.translateDict.put("top", "topHorizontalPipe");
        this.translateDict.put("right", "rightVerticalPipe");

        this.retroTranslateDict.put("bottomHorizontalLine", new Pair<>("bottom", "true"));
        this.retroTranslateDict.put("topHorizontalLine", new Pair<>("top", "true"));
        this.retroTranslateDict.put("rightVerticalLine", new Pair<>("right", "true"));
    }

    public String translate(Pair<String, String> allowedValue) {
        String trailingData = allowedValue.getValue();

        if (allowedValue.getKey() != "small_num") trailingData = "";

        return this.translateDict.get(allowedValue.getKey()) + trailingData;
    }

    public String translate(String imageName) {
        return "";
    }
}
