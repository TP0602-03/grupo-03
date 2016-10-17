package ar.fiuba.tdd.tp.view;
import com.sun.codemodel.internal.JOp;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class MainValuePicker {

    Icon[] options;
    public  MainValuePicker(Icon[] options){
        this.options = options;
    }

    public void GetValuePicker(JPanel panel){
        JOptionPane jOptionPane = new JOptionPane();
        jOptionPane.setOptions(GetOptions(jOptionPane));
        jOptionPane.setMessage("Choose a move");
        JFrame jFrame = new JFrame();

        JDialog jDialog = jOptionPane.createDialog(jFrame,"Move");
        jDialog.setVisible(true);
    }

    private JButton[] GetOptions(JOptionPane optionPane){
        JButton[] buttons = new JButton[options.length];
        for (int i = 0; i < options.length; i++){
            buttons[i] = GetButton(options[i], optionPane);
        }
        return buttons;
    }

    private JButton GetButton(Icon icon, JOptionPane optionPane){
        JButton button = new JButton("hola", icon);
        ActionListener actionListener = GetAction(button, optionPane);
        button.addActionListener(actionListener);
        return button;
    }

    private ActionListener GetAction(JButton button, JOptionPane optionPane){
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                // Return current text label, instead of argument to method
                optionPane.setValue(button.getText());
                System.out.println(button.getText());
            }
        };
    }

}

