package ar.fiuba.tdd.tp.graph;

public class Coord {
    private final Integer coordinateX;
    private final Integer coordinateY;

    public Coord(Integer coordinateX, Integer coordinateY) {

        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public Integer getY() {
        return coordinateY;
    }

    public Integer getX() {
        return coordinateX;
    }
}
