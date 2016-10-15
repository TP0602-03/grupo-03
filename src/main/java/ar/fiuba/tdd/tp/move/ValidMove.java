package ar.fiuba.tdd.tp.move;

/**
 * Created by luciano on 15/10/16.
 */
public class ValidMove extends Move {

    private int x;
    private int y;
    private String value;

    public ValidMove(int newId,int newX,int newY,String newValue){

        this.id = newId;
        this.value = newValue;
        this.x = newX;
        this.y = newY;

    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public String getValue(){
        return this.value;
    }

}
