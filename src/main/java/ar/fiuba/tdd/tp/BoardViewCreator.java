package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.parser.*;
import ar.fiuba.tdd.tp.parser.Parser;
import ar.fiuba.tdd.tp.view.BoardGameView;
import ar.fiuba.tdd.tp.view.CellView;

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
                    String content;
                    try {
                        content = game.getCell(i, j).getAttribute("num").toString();
                    } catch (Exception ex) {
                        content = "  ";
                    }
                    CellView panel = new CellView(content);
                    board.set(i, j, 50, 50, panel);
                }
            }
        } catch (Exception ex) {

        }
    }
}