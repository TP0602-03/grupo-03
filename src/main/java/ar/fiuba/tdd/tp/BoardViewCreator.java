package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.parser.*;
import ar.fiuba.tdd.tp.parser.Parser;
import ar.fiuba.tdd.tp.view.BoardGameView;

import javax.swing.*;
import java.awt.*;

public class BoardViewCreator {

    public BoardViewCreator() {

    }

    public void CreateBoard(Game game) {
        try {

            BoardGameView board = new BoardGameView();

            for (int i = 0; i < game.getWidth(); i++) {
                for (int j = 0; j < game.getHeight(); j++) {
                    JPanel panel = new JPanel();
                    panel.setBorder(BorderFactory.createLineBorder(Color.black));
                    try {
                        panel.add(new JLabel(game.getCell(i, j).getAttribute("num").toString()));
                    } catch (Exception ex) {
                        panel.add(new JLabel("  "));
                    }
                    board.set(i, j, 50, 50, panel);
                }
            }
        } catch (Exception ex) {

        }
    }
}