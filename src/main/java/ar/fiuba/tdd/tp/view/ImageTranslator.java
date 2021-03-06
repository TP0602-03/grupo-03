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

    private HashMap<Pair<String, String>, String> keyValueImageMap;

    public ImageTranslator() throws IOException, ParseException {
        this.keyValueImageMap = new HashMap<>();
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
                keyValueImageMap.put(new Pair<>(attributeName, value), image);

            }
        }

    }

    public String translate(Pair<String, String> allowedValue) {
        return this.keyValueImageMap.get(allowedValue);
    }

}
