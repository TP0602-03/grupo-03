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
                    ImageManager imageGetter = new ImageManager("gameFiles/images");

                    CellView panel = new CellView(game.getCellKeysValues(i, j));
                    panel.setHandlers(new MouseCellHandler(imageGetter.getImages(game.getAllowedValues()), game, i, j, panel));
                    board.set(i, j, 50, 50, panel);
                }
            }
        } catch (Exception ex) {

        }
    }
}