package ar.fiuba.tdd.tp.view;
import javax.swing.*;


public class MainValuePicker {

    JPanel[] options;
    public  MainValuePicker(JPanel[] options){
        this.options = options;
    }

    public void GetValuePicker(JPanel panel){
        String value = JOptionPane.showInputDialog(panel, options);
    }

}

