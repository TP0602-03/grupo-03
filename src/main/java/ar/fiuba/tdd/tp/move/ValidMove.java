package ar.fiuba.tdd.tp.move;

/**
 * Created by luciano on 15/10/16.
 */
public class ValidMove extends Move {

    private int coordinateX;
    private int coordinateY;
    private String value;

    public ValidMove(int newId, int newX, int newY, String newValue) {

        this.id = newId;
        this.value = newValue;
        this.coordinateX = newX;
        this.coordinateY = newY;

    }

    public int getX() {
        return this.coordinateX;
    }

    public int getY() {
        return this.coordinateY;
    }

    public String getValue() {
        return this.value;
    }

}
