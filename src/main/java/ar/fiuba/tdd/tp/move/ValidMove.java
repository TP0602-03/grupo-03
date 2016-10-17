package ar.fiuba.tdd.tp.move;

/**
 * Created by luciano on 15/10/16.
 */
public class ValidMove extends Move {

    private int coordinateX;
    private int coordinateY;
    private String value;
    private String attribute;

    public ValidMove(int newId, int newX, int newY, String newAttribute, String newValue) {

        this.id = newId;
        this.attribute = newAttribute;
        this.value = newValue;
        this.coordinateX = newX;
        this.coordinateY = newY;

    }

    public String getAttribute() {
        return this.attribute;
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

    public Boolean isValid() {
        return Boolean.TRUE;
    }
}
