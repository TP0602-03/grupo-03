package ar.fiuba.tdd.tp.rule;

import ar.fiuba.tdd.tp.graph.GraphVertex;

import java.util.List;

public abstract class Rule {
    public abstract boolean check(List<GraphVertex> vertices);
}
