package ar.fiuba.tdd.tp.gridtest;

import ar.fiuba.tdd.tp.cell.BarredCell;
import ar.fiuba.tdd.tp.cell.InvalidValueTypeException;
import ar.fiuba.tdd.tp.grid.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by luciano on 28/09/16.
 */
public class KakuroFileGridLoadTest {

    @Test
    public void notExistentFileThrowsExceptionTest() {

        try {
            FileGridLoader gridLoader = new KakuroFileGridLoader("inexistentFile");
        } catch (Exception catchedException) {

            assertTrue(catchedException instanceof FileNotFoundException);
        }



    }

    @Test
    public void correctGridLoadTest()  throws FileNotFoundException,UnsupportedEncodingException,InvalidFileLayoutException,
            InvalidValueTypeException {

        //Create a file to load from
        PrintWriter writer = new PrintWriter("correctFile", "UTF-8");
        writer.println("1 2 3 4");
        writer.println("5 6 7 8");

        writer.close();


        KakuroGridFactory kakuroFactory = new KakuroGridFactory();
        FileGridLoader gridLoader = new KakuroFileGridLoader("correctFile");
        kakuroFactory.setLoader(gridLoader);
        Grid grid = kakuroFactory.createGrid();

        BarredCell cell1 = (BarredCell) grid.getCell(1,2);
        BarredCell cell2 = (BarredCell) grid.getCell(5,6);

        Integer[] values1 = cell1.getValue();
        Integer[] values2 = cell2.getValue();

        int value1a = values1[0];
        int value1b = values1[1];
        int value2a = values2[0];
        int value2b = values2[1];

        assertEquals(value1a,3);
        assertEquals(value1b,4);
        assertEquals(value2a,7);
        assertEquals(value2b,8);


    }
}
