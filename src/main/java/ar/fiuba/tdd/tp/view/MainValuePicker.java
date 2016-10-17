package ar.fiuba.tdd.tp.view;
import com.sun.codemodel.internal.JOp;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.Objects;


public class MainValuePicker {

    IconValue[] options;
    public  MainValuePicker(IconValue[] options){
        this.options = options;
    }

    public Object GetValuePicker(JPanel panel){
        JOptionPane jOptionPane = new JOptionPane();
        jOptionPane.setOptions(GetOptions(jOptionPane));
        jOptionPane.setMessage("Choose a move");
        JFrame jFrame = new JFrame();

        JDialog jDialog = jOptionPane.createDialog(jFrame,"Move");
        jDialog.setVisible(true);
        return jOptionPane.getValue();
    }

    private JButton[] GetOptions(JOptionPane optionPane){
        JButton[] buttons = new JButton[options.length];
        for (int i = 0; i < options.length; i++){
            buttons[i] = GetButton(options[i], optionPane);
        }
        return buttons;
    }

    private JButton GetButton(IconValue icon, JOptionPane optionPane){
        JButton button = new JButton("", icon.getIcon());
        ActionListener actionListener = GetAction(icon.getValue(), optionPane);
        button.addActionListener(actionListener);
        return button;
    }

    private ActionListener GetAction(String returnValue, JOptionPane optionPane){
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                // Return current text label, instead of argument to method
                optionPane.setValue(returnValue);
                System.out.println(returnValue);
            }
        };
    }

}

