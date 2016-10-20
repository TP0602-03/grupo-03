package ar.fiuba.tdd.tp.view;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Objects;

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

        this.translateDict.put("diagonal", "");
        this.translateDict.put("num", "");

        this.retroTranslateDict = new HashMap<>();
        this.retroTranslateDict.put("bottomHorizontalLine", new Pair<>("bottom", "true"));
        this.retroTranslateDict.put("topHorizontalLine", new Pair<>("top", "true"));
        this.retroTranslateDict.put("rightVerticalLine", new Pair<>("right", "true"));
    }

    public String translate(Pair<String, String> allowedValue) {
        System.out.println("allowed value key is: " + allowedValue.getKey());
        System.out.println("allowed value value is: " + allowedValue.getValue());
        String trailingData = allowedValue.getValue();

        if (!Objects.equals(allowedValue.getKey(), "diagonal") && !Objects.equals(allowedValue.getKey(), "small_num") && !Objects.equals(allowedValue.getKey(), "num"))
            trailingData = "";
        System.out.println("dict size: " + this.translateDict.size());
        System.out.println("dict size: " + this.translateDict.size());
        System.out.println("dict: " + this.translateDict.get(allowedValue.getKey()));
        System.out.println("translated: " + this.translateDict.get(allowedValue.getKey()) + trailingData);
        return this.translateDict.get(allowedValue.getKey()) + trailingData;
    }

    public String translate(String imageName) {
        return "";
    }
}
