package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.action.Action;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.graph.GridGraph;

import java.util.*;

public class Game {
    private GridGraph cells;
    private GridGraph nodes;
    private List<Region> regions = new ArrayList<>();
    private int width;
    private int height;
    private Map<String, Map<Object, List<Action>>> actions = new HashMap<>();

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new GridGraph(2 * width + 1, 2 * height + 1);
        nodes = new GridGraph(width + 1, height + 1);
    }

    public void addActions(String attribute, Object value, List<Action> actions) {
        this.actions.putIfAbsent(attribute, new HashMap<>());
        this.actions.get(attribute).put(value, actions);
    }

    public void addRegion(Region region) {
        regions.add(region);
    }

    public GraphVertex getCell(int row, int col) {
        return cells.getVertex(2 * row + 1, 2 * col + 1);
    }

    public GraphVertex getCorner(int row, int col) {
        return cells.getVertex(2 * row, 2 * col);
    }

    public GraphVertex getVertex(int row, int col) {
        return cells.getVertex(row, col);
    }

    public boolean validateRules() {
        boolean result = false;
        //System.out.println("regions: " + regions.size());
        for (Region region :
                regions) {

            result = region.validate();
            //System.out.println("Region is " + (result ? "OK" : "NOT OK"));
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public void playCell(int row, int col, String att, Object value) {
        //System.out.println("play cell: " + "(" + row + "," + col + ")" + " att: " + att + "  value: " + value);

        cells.getVertex(2 * row + 1, 2 * col + 1).setAttribute(att, value);
        if (actions.get(att) != null) {
            for (Action action :
                    actions.get(att).get(value)) {
                action.run(cells, 2 * row + 1, 2 * col + 1);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Set<Map.Entry<String, Object>> getCellKeysValues(int row, int col) {
        return cells.getVertex(row, col).getKeysValues();
    }
}
