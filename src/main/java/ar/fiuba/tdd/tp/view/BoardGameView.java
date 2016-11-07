package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.Game;

import java.awt.*;
import java.util.Map;
import java.util.Set;

import javax.swing.*;

public class BoardGameView extends JPanel {

    private final Game game;
    //private board
    JPanel panel;
    JPanel cellContainer;
    JPanel vertexContainer;
    GridBagLayout gbl;
    GridBagLayout vgbl;
    OverlayLayout ol;

    public BoardGameView(Game game) {
        this.game = game;
        cellContainer = new JPanel();
        vertexContainer = new JPanel();
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        ol = new OverlayLayout(panel);
        panel.setLayout(ol);
        panel.add(vertexContainer);
        panel.add(cellContainer);
        panel.setVisible(true);
        gbl = new GridBagLayout();
        cellContainer.setLayout(gbl);
        cellContainer.setOpaque(false);
        vgbl = new GridBagLayout();
        vertexContainer.setLayout(vgbl);
        vertexContainer.setOpaque(false);

    }

    public JPanel getPanel() {
        return panel;
    }

    public void setCell(int indexR, int indexC, int width, int height, Component cell) {

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = indexC;
        gridBagConstraints.gridy = indexR;
        gridBagConstraints.ipadx = width;
        gridBagConstraints.ipady = height;

        cellContainer.add(cell, gridBagConstraints);

    }

    public void setVertex(int indexR, int indexC, int width, int height, Component vertex) {

        GridBagConstraints vgridBagConstraints = new GridBagConstraints();
        vgridBagConstraints.gridx = indexC;
        vgridBagConstraints.gridy = indexR;

        vgridBagConstraints.ipadx = 0;
        vgridBagConstraints.ipady = 0;

        vgridBagConstraints.insets = new Insets(35, 35, 35, 35);

        vertexContainer.add(vertex, vgridBagConstraints);

    }

    public Component getCell(int row, int col) {
        return cellContainer.getComponent(row * gbl.getLayoutDimensions()[0].length + col);
    }

    public Component getVertex(int row, int col) {
        return vertexContainer.getComponent(row * vgbl.getLayoutDimensions()[0].length + col);
    }

    private void drawCells() {
        for (int i = 0; i < game.getHeight(); i++) {
            for (int j = 0; j < game.getWidth(); j++) {
                CellView cell = (CellView) getCell(i, j);
                Set<Map.Entry<String, String>> atts = game.getCellKeysValues(i, j);
                drawCellView(cell, atts);
            }
        }
    }

    private void drawCellView(CellView cell, Set<Map.Entry<String, String>> atts) {
        for (Map.Entry<String, String> att : atts) {
            cell.setContent(att.getKey(), att.getValue());
        }
        cell.generateLabels();
        cell.revalidate();
        cell.repaint();
    }

    private void drawVertices() {
        for (int i = 0; i < game.getHeight() + 1; i++) {
            for (int j = 0; j < game.getWidth() + 1; j++) {
                CellView cell = (CellView) getVertex(i, j);
                //Para que no falle CDP :p
                drawCellView(cell, game.getVertexKeysValues(i, j));
            }
        }
    }

    public void update() {
        drawVertices();

        drawCells();
    }

}

