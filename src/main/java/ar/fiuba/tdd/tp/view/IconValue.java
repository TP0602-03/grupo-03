package ar.fiuba.tdd.tp.view;

import javafx.util.Pair;

import javax.swing.*;

/**
 * Created by ms0359 on 10/16/16.
 */
public class IconValue {
    private Icon icon;
    private Pair<String, String> keyValue;

    public Icon getIcon() {
        return icon;
    }

    public String getKey(){
        return keyValue.getKey();
    }

    public String getValue() {
        return keyValue.getValue();
    }

    public Pair<String, String> getKeyValue(){
        return keyValue;
    }

    public IconValue(Icon icon, String key, String value) {
        this.icon = icon;
        this.keyValue = new Pair<>(key, value);
    }

}
