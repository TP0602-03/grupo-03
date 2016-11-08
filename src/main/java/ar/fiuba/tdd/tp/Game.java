package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.action.Action;
import ar.fiuba.tdd.tp.graph.GraphVertex;
import ar.fiuba.tdd.tp.graph.GridGraph;
import javafx.util.Pair;

import java.util.*;

public class Game {

    private GridGraph cells;
    private List<Region> regions = new ArrayList<>();
    private int width;
    private int height;

    private Stack<Pair<Pair<Integer, Integer>, Pair<String, String>>> plays;

    private HashMap<String, ArrayList<String>> possibleValues = new HashMap<>();
    private HashMap<Pair<Integer, Integer>, ArrayList<String>> allowedPositions = new HashMap<>();

    private Map<Pair<String, String>, List<Action>> actions = new HashMap<>();
    private ArrayList<Pair<String, String>> allowedValues = new ArrayList<>();
    private String name;

    public Game(String name, int width, int height) {
        plays = new Stack<>();
        this.width = width;
        this.height = height;
        this.name = name;
        cells = new GridGraph(2 * width + 1, 2 * height + 1);
    }

    public HashMap<String, ArrayList<String>> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(HashMap<String, ArrayList<String>> newPossibleValues) {
        possibleValues = newPossibleValues;
    }

    public HashMap<Pair<Integer, Integer>, ArrayList<String>> getAllowedPositions() {
        return allowedPositions;
    }

    public void setAllowedPositions(HashMap<Pair<Integer, Integer>, ArrayList<String>> newAllowedPositions) {
        allowedPositions = newAllowedPositions;
    }

    public void addActions(String attribute, String value, List<Action> actions) {
        this.actions.putIfAbsent(new Pair<>(attribute, value), actions);
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
        for (Region region : regions) {

            result = region.validate();
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public void playCell(int row, int col, String att, String newValue) {
        if (allowedPositions.containsKey(new Pair<>(row, col))) {
            Pair<String, String> oldValue = new Pair<>(att, getCell(row, col).getAttribute(att));
            Pair<Pair<Integer, Integer>, Pair<String, String>> old = new Pair<>(new Pair<>(row, col), oldValue);
            plays.push(old);
            runActions(row, col, att, newValue);
        } else {
            System.out.println("This cell is not editable!");
        }

    }

    private void runActions(int row, int col, String att, String newValue) {
        cells.clearEdges();
        getCell(row, col).setAttribute(att, newValue);
        runActionsForCell(row, col);

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                runActionsForCell(r, c);
            }
        }
    }

    private void runActionsForCell(int row, int col) {
        GraphVertex cell = getCell(row, col);
        Set<Map.Entry<String, String>> entrySet = cell.getAttributes().entrySet();

        for (Map.Entry<String, String> attribute : entrySet) {
            Pair<String, String> entry = new Pair<>(attribute.getKey(), attribute.getValue());
            if (actions.get(entry) != null) {
                for (Action action : actions.get(entry)) {
                    action.run(cells, 2 * row + 1, 2 * col + 1);
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
        return cells.getVertex(2 * row + 1, 2 * col + 1).getKeysValues();
    }

    public ArrayList<Pair<String, String>> getAllowedValues() {
        return allowedValues;
    }

    public void addAllowedValues(ArrayList<String> strings, String attribute) {
        for (String value : strings) {
            allowedValues.add(new Pair<>(attribute, value));
        }
    }

    public Set<Map.Entry<String, String>> getVertexKeysValues(int row, int col) {
        return cells.getVertex(2 * row, 2 * col).getKeysValues();
    }

    public String getName() {
        return name;
    }

    public void undoPlay() {
        if (plays.size() == 0) {
            return;
        }
        Pair<Pair<Integer, Integer>, Pair<String, String>> lastPlay = plays.pop();
        int row = lastPlay.getKey().getKey();
        int col = lastPlay.getKey().getValue();
        String att = lastPlay.getValue().getKey();
        String value = lastPlay.getValue().getValue();

        runActions(row, col, att, value);
    }
}
