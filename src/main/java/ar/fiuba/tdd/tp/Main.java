package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.cell.InvalidValueTypeException;

import javax.swing.*;

public class Main extends JFrame {

    private JLabel text;

    public Main() {
        setLayout(null);
        text = new JLabel("Hello World !");
        text.setBounds(100,100,200,40);
        add(text);
    }

    public static void main(String[] args) throws InvalidValueTypeException {
        Main mainWindow = new Main();
        mainWindow.setBounds(500,250,300,250);
        mainWindow.setVisible(true);
        mainWindow.setResizable(false);
    }
}

