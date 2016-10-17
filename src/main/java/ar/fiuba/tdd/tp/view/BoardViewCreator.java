package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.controller.MouseCellHandler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

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
                    ImageManager imageGetter = new ImageManager("gameFiles/images");
                    IconValue[] icons = new IconValue[1];
                    icons[0] = new IconValue(imageGetter.getImage("0"), "0");

                    CellView panel = new CellView(contents, new MouseCellHandler(icons));
                    board.set(i, j, 50, 50, panel);
                }
            }
        } catch (Exception ex) {

        }
    }
}