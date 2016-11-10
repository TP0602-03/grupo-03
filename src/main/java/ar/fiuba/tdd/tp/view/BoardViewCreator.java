package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.Game;
import ar.fiuba.tdd.tp.controller.MouseCellHandler;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class BoardViewCreator {

    public BoardViewCreator() {

    }

    public BoardGameView createBoard(Game game) {
        BoardGameView board = new BoardGameView(game);

        try {
            loadCells(game, board);
            loadVertices(game, board);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return board;
    }

    private void loadVertices(Game game, BoardGameView board) throws Exception {
        for (int i = 0; i < game.getWidth() + 1; i++) {
            for (int j = 0; j < game.getHeight() + 1; j++) {

                Set<Map.Entry<String, String>> vertexKeysValues = game.getVertexKeysValues(i, j);
                int gridSize = game.getHeight() * 2 + 1;

                ImageManager imageGetter = new ImageManager("gameFiles/images", gridSize);

                CellView panel = new CellView(vertexKeysValues, imageGetter, "NullContent");

                panel.setOpaque(false);

                board.setVertex(i, j, 15, 15, panel);
            }
        }
    }

    private void loadCells(Game game, BoardGameView board) throws Exception {
        for (int i = 0; i < game.getWidth(); i++) {
            for (int j = 0; j < game.getHeight(); j++) {

                ImageManager imageGetter = new ImageManager("gameFiles/images", game.getHeight());
                Set<Map.Entry<String, String>> cellKeysValues = game.getCellKeysValues(i, j);

                CellView panel = new CellView(cellKeysValues, imageGetter, "NullContent");

                panel.setBorder();
                panel.setOpaque(false);

                ArrayList<IconValue> images = imageGetter.getImages(game.getAllowedValues());
                MouseCellHandler mouseCellHandler = new MouseCellHandler(board, images, game, i, j);

                panel.setHandlers(mouseCellHandler);

                board.setCell(i, j, 0, 0, panel);
            }
        }
    }
}