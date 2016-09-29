package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.Obtainer.SudokuObtainer;
import ar.fiuba.tdd.tp.cell.SudokuCell;
import ar.fiuba.tdd.tp.grid.Grid;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by luciano on 29/09/16.
 */
public class ObtainerTests {

    @Test
    public void testSquareObtainer(){
        Grid<SudokuCell> grid = new Grid<>(9,9);

        for(int i = 0; i < 9; i++) {
            for(int j = 0 ; j < 9; j++) {
                SudokuCell cell =  new SudokuCell();
                cell.setValue(i*10 + j);
                grid.setValue(i,j,cell);
            }
        }

        SudokuObtainer obtainer = new SudokuObtainer(grid);


        ArrayList<SudokuCell> square = obtainer.getSquare(4,4);
        ArrayList<Integer> expectedValues = new ArrayList<>(Arrays.asList(33,34,35,43,44,45,53,54,55));

        for(int i = 0; i < square.size(); i++ ){
            assertTrue(expectedValues.contains(square.get(i).getValue()));
        }



    }


}
