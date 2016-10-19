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
                    for (Map.Entry<String, Object> key : game.getCellKeysValues(i, j)) {
                        String content;
                        try {
                            content = key.getValue().toString();
                        } catch (Exception ex) {
                            content = "  ";
                        }
                        contents.add(content);
                    }

                    ImageManager imageGetter = new ImageManager("gameFiles/images");
                    IconValue[] icons = new IconValue[4];
                    icons[0] = new IconValue(imageGetter.getImage("1"), "1");
                    icons[1] = new IconValue(imageGetter.getImage("2"), "2");
                    icons[2] = new IconValue(imageGetter.getImage("3"), "3");
                    icons[3] = new IconValue(imageGetter.getImage("4"), "4");

                    CellView panel = new CellView(contents);
                    panel.setHandlers(new MouseCellHandler(icons, game, i, j, panel));
                    board.set(i, j, 50, 50, panel);
                }
            }
        } catch (Exception ex) {

        }
    }
}