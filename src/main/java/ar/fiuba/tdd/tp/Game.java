package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.graph.Coord;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.graph.GridGraph;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private GridGraph cells;
    private GridGraph nodes;
    private List<Region> regions = new ArrayList<>();

    public Game(int width, int height) {
        cells = new GridGraph(width, height);
        nodes = new GridGraph(width + 1, height + 1);
    }

    public void addRegion(Region region) {
        regions.add(region);
    }

    public GraphVertex getCell(int row, int col) {
        return cells.getVertex(row, col);
    }

    public GraphVertex getNode(int row, int col) {
        return nodes.getVertex(row, col);
    }

    public void validateRules() {
        boolean result = false;
        for (Region region :
                regions) {

            result = region.validate();
            System.out.println("Region is " + (result ? "OK" : "NOT OK"));
        }
    }

    public void playCell(int row, int col, String num, Object value) {
        cells.getVertex(row, col).setAttribute(num, value);
    }

    public void playNode(int row, int col, String num, int value) {
        nodes.getVertex(row, col).setAttribute(num, value);
    }

    public void addNodeEdge(Coord nodeA, Coord nodeB) {
        nodes.addEdge(nodeA, nodeB);
        //validateRules();
    }

    public void addCellEdge(Coord cellA, Coord cellB) {
        cells.addEdge(cellA, cellB);
        //validateRules();
    }
}