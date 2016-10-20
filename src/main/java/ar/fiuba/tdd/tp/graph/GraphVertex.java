package ar.fiuba.tdd.tp.graph;

import java.util.*;

public class GraphVertex {
    private List<GraphVertex> adjacencyList = new ArrayList<>();
    private Map<String, String> attributes = new HashMap<>();

    public String getAttribute(String attribute) {
        return attributes.get(attribute);
    }

    public void setAttribute(String attribute, String value) {
        attributes.put(attribute, value);
    }

    public boolean hasAttribute(String attribute) {
        return attributes.containsKey(attribute);
    }

    public void removeAttribute(String attribute) {
        attributes.remove(attribute);
    }

    public void addEdge(GraphVertex vertex) {
        adjacencyList.add(vertex);
    }

    public List<GraphVertex> getAdjacencyList() {
        return adjacencyList;
    }

    public Set<Map.Entry<String, String>> getKeysValues() {
        return attributes.entrySet();
    }

    /**
     * Esta clase se va a borrar, hablar con Chris que la usa para testear or some shit.
     */
    public void print() {
        System.out.println((String) getAttribute("pos"));
    }

    public void removeEdge(GraphVertex vertex) {
        adjacencyList.remove(vertex);
    }

    public boolean isAdjacent(GraphVertex other) {
        return adjacencyList.contains(other);
    }

    public void clearEdges() {
        adjacencyList = new ArrayList<>();
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
