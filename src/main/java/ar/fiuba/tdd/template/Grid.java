package ar.fiuba.tdd.template;
import java.util.ArrayList;

public class Grid {
    private ArrayList<ArrayList<Cell>> grid = new ArrayList<ArrayList<Cell>>();

    public Grid(int w, int h) {
        for (int i = 0; i < h; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < w; j++) {
                grid.get(i).add(new NumericalCell(1));
            }
        }

    }

    public int getWidth(){
        return grid.get(0).size();
    }
    public int getHeight(){
        return grid.size();
    }
    public Cell get(int row, int column){
        return (grid.get(row).get(column));
    }

    public void set(int row, int column,int v) throws InvalidValueTypeException{
            (grid.get(row).get(column)).setValue(v);

    }

    public void print() throws  InvalidValueTypeException{
        for (int i = 0; i < grid.get(0).size(); i++) {
            System.out.print("--");
        }
        System.out.println();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                System.out.print(grid.get(i).get(j).getValue() + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < grid.get(0).size(); i++) {
            System.out.print("--");
        }
        System.out.println();
    }
}
