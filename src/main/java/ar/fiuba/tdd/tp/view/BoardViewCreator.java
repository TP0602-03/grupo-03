package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.controller.MouseCellHandler;

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
                    for (Map.Entry<String, String> key : game.getCellKeysValues(i, j)) {
                        String content;
                        try {
                            content = key.getValue();
                        } catch (Exception ex) {
                            content = "  ";
                        }
                        contents.add(content);
                    }

                    ImageManager imageGetter = new ImageManager("gameFiles/images");
                    IconValue[] icons = new IconValue[4];

                    CellView panel = new CellView(contents);
                    panel.setHandlers(new MouseCellHandler(imageGetter.getImages(game.getAllowedValues()), game, i, j, panel));
                    board.set(i, j, 50, 50, panel);
                }
            }
        } catch (Exception ex) {

        }
    }
}