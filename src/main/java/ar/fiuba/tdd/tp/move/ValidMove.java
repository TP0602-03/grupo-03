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

        id = newId;
        attribute = newAttribute;
        value = newValue;
        coordinateX = newX;
        coordinateY = newY;

    }

    public String getAttribute() {
        return attribute;
    }

    public int getX() {
        return coordinateX;
    }

    public int getY() {
        return coordinateY;
    }

    public String getValue() {
        return value;
    }

    public Boolean isValid() {
        return Boolean.TRUE;
    }
}
