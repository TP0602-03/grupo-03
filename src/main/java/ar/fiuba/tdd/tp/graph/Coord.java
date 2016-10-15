package ar.fiuba.tdd.tp.graph;

public class Coord {
    private final Integer coordinateX;
    private final Integer coordinateY;

    public Coord(Integer coordinateX, Integer coordinateY) {

        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

    public Integer getCoordinateX() {
        return coordinateX;
    }
}
