package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.controller.MouseCellHandler;

public class BoardViewCreator {

    public BoardViewCreator() {

    }

    public void createBoard(Game game) {
        try {
            BoardGameView board = new BoardGameView();

            for (int i = 0; i < game.getWidth(); i++) {
                for (int j = 0; j < game.getHeight(); j++) {
                    ImageManager imageGetter = new ImageManager("gameFiles/images", game.getHeight());

                    CellView panel = new CellView(game.getCellKeysValues(i, j), game.getHeight(), "NullContent");
                    panel.setBorder();
                    panel.setHandlers(new MouseCellHandler(board, imageGetter.getImages(game.getAllowedValues()), game, i, j));
                    panel.setOpaque(false);
                    board.setCell(i, j, 0, 0, panel);
                }
            }
            for (int i = 0; i < game.getWidth() + 1; i++) {
                for (int j = 0; j < game.getHeight() + 1; j++) {
                    CellView panel = new CellView(game.getVertexKeysValues(i, j), game.getHeight() * 2 + 1, "NullContent");
                    panel.setOpaque(false);
                    board.setVertex(i, j, 15, 15, panel);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}