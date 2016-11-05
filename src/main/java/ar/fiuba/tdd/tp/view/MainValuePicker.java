package ar.fiuba.tdd.tp.view;

import javafx.util.Pair;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class MainValuePicker {

    ArrayList<IconValue> options;

    public MainValuePicker(ArrayList<IconValue> options) {
        this.options = options;
    }

    public Object getValuePicker() {
        JOptionPane optionPane = new JOptionPane();
        optionPane.setOptions(getOptions(optionPane));
        optionPane.setMessage("Choose a move");
        JFrame frame = new JFrame();

        JDialog dialog = optionPane.createDialog(frame, "Move");
        dialog.setVisible(true);
        return optionPane.getValue();
    }

    private JButton[] getOptions(JOptionPane optionPane) {
        JButton[] buttons = new JButton[options.size()];
        for (int i = 0; i < options.size(); i++) {
            buttons[i] = getButton(options.get(i), optionPane);
        }
        return buttons;
    }

    private JButton getButton(IconValue icon, JOptionPane optionPane) {
        JButton button = new JButton("", icon.getIcon());
        ActionListener actionListener = getAction(icon.getKeyValue(), optionPane);
        button.addActionListener(actionListener);
        return button;
    }

    private ActionListener getAction(Pair<String, String> returnValue, JOptionPane optionPane) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                // Return current text label, instead of argument to method
                optionPane.setValue(returnValue);
            }
        };
    }

}

