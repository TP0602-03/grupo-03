package ar.fiuba.tdd.tp.view;

import javafx.util.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by mvbattan on 19/10/16.
 */
public class ImageTranslator {

    private HashMap<String, String> translateDict;
    private HashMap<Pair<String, String>, String> retroTranslateDict;

    public ImageTranslator() throws IOException, ParseException {
        this.retroTranslateDict = new HashMap<>();
        JSONParser parser = new JSONParser();
        JSONArray all = (JSONArray) parser.parse(new InputStreamReader(new FileInputStream("gameFiles/images.json"), "UTF-8"));
        for (Object obj : all) {
            JSONObject attImagesJson = (JSONObject) obj;
            String attributeName = (String) attImagesJson.get("attribute");
            JSONArray attValuesImages = (JSONArray) attImagesJson.get("values");
            for (Object objVal : attValuesImages) {
                JSONObject valueImage = (JSONObject) objVal;
                String value = (String) valueImage.get("value");
                String image = (String) valueImage.get("image");
                retroTranslateDict.put(new Pair<>(attributeName, value), image);
                System.out.println("att:" + attributeName + "val: " + value + "img:" + image);
            }

        }




/*        this.translateDict = new HashMap<>();
        this.translateDict.put("small_num", "leftTop");
        this.translateDict.put("left", "leftVerticalPipe");
        this.translateDict.put("bottom", "bottomHorizontalPipe");
        this.translateDict.put("top", "topHorizontalPipe");
        this.translateDict.put("right", "rightVerticalPipe");

        this.translateDict.put("diagonal", "");
        this.translateDict.put("num", "");*/


    }

    public String translate(Pair<String, String> allowedValue) {
       /* System.out.println("allowed value key is: " + allowedValue.getKey());
        System.out.println("allowed value value is: " + allowedValue.getValue());
        String trailingData = allowedValue.getValue();

        if (!Objects.equals(allowedValue.getKey(), "diagonal") && !Objects.equals(allowedValue.getKey(), "small_num") && !Objects.equals(allowedValue.getKey(), "num"))
            trailingData = "";
        System.out.println("dict size: " + this.translateDict.size());
        System.out.println("dict size: " + this.translateDict.size());
        System.out.println("dict: " + this.translateDict.get(allowedValue.getKey()));
        System.out.println("translated: " + this.translateDict.get(allowedValue.getKey()) + trailingData);
        return this.translateDict.get(allowedValue.getKey()) + trailingData;*/
        System.out.println("image for: " + allowedValue.getKey() + " " + allowedValue.getValue() + " is" + this.retroTranslateDict.get(allowedValue));
        return this.retroTranslateDict.get(allowedValue);
    }

    public String translate(String imageName) {
        return "";
    }
}
