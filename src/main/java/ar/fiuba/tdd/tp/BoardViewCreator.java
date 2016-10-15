package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.parser.*;
import ar.fiuba.tdd.tp.parser.Parser;
import ar.fiuba.tdd.tp.view.BoardGameView;
import ar.fiuba.tdd.tp.view.CellView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class BoardViewCreator {

    public BoardViewCreator() {

    }

    public void CreateBoard(Game game) {
        try {
            BoardGameView board = new BoardGameView();

            for (int i = 0; i < game.getWidth(); i++) {
                for (int j = 0; j < game.getHeight(); j++) {
                    ArrayList<String> contents = new ArrayList<String>();
                    for (Map.Entry<String, Object> key: game.getCellKeysValues(i,j)) {
                        String content;
                        try {
                            content = key.getValue().toString();
                        } catch (Exception ex) {
                            content = "  ";
                        }
                        contents.add(content);
                    }
                    CellView panel = new CellView(contents);
                    board.set(i, j, 50, 50, panel);
                }
            }
        } catch (Exception ex) {

        }
    }
}