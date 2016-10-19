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
    private Map<String, Map<String, List<Action>>> actions = new HashMap<>();


    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new GridGraph(2 * width + 1, 2 * height + 1);
        nodes = new GridGraph(width + 1, height + 1);
    }

    public void addActions(String attribute, String value, List<Action> actions) {
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
        boolean result;
        for (Region region :
                regions) {

            result = region.validate();
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public void playCell(int row, int col, String att, String newValue) {
        cells.clearEdges();
        cells.getVertex(2 * row + 1, 2 * col + 1).setAttribute(att, newValue);

        //System.out.println("********* REBUILDING GRAPH: **********");

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                GraphVertex cell = getCell(i, j);
                //System.out.println("******* Actions for Cell: " + i + " , " + j);
                for (Map.Entry<String, String> attribute :
                        cell.getAttributes().entrySet()) {
                    if (actions.get(attribute.getKey()) != null) {
                        for (Action action :
                                actions.get(attribute.getKey()).get(attribute.getValue())) {
                            //System.out.println("action = " + action);
                            action.run(cells, 2 * i + 1, 2 * j + 1);
                        }

                    }
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Set<Map.Entry<String, String>> getCellKeysValues(int row, int col) {
        return cells.getVertex(2 * row + 1,2 * col + 1).getKeysValues();
    }
}
