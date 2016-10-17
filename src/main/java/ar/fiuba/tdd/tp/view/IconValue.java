package ar.fiuba.tdd.tp.view;

import javax.swing.*;

/**
 * Created by ms0359 on 10/16/16.
 */
public class IconValue {
    private Icon icon;
    private String value;

    public Icon getIcon() {
        return icon;
    }

    public String getValue() {
        return value;
    }

    public IconValue(Icon icon, String value) {
        this.icon = icon;
        this.value = value;
    }

}
