package ar.fiuba.tdd.tp.gridtest;

import ar.fiuba.tdd.tp.cell.InvalidValueTypeException;
import ar.fiuba.tdd.tp.grid.FileGridLoader;
import ar.fiuba.tdd.tp.grid.Grid;
import ar.fiuba.tdd.tp.grid.InvalidFileLayoutException;
import ar.fiuba.tdd.tp.grid.SudokuGridFactory;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by luciano on 26/09/16.
 */
public class FileGridLoaderTest {


    @Test
    public void notExistentFileThrowsExceptionTest() {

        SudokuGridFactory sudokuFactory = new SudokuGridFactory();
        Grid grid = sudokuFactory.createGrid();
        try {
            FileGridLoader gridLoader = new FileGridLoader("inexistentFile");
        } catch (Exception catchedException) {

            assertTrue(catchedException instanceof FileNotFoundException);
        }



    }

    @Test
    public void norrectGridLoad()  throws FileNotFoundException,UnsupportedEncodingException,InvalidFileLayoutException,
            InvalidValueTypeException {

        //Create a file to load from
        PrintWriter writer = new PrintWriter("correctFile", "UTF-8");
        writer.println("1 2 3");
        writer.println("4 5 6");
        writer.println("7 8 9");


        writer.close();


        SudokuGridFactory sudokuFactory = new SudokuGridFactory();
        Grid grid = sudokuFactory.createGrid();
        FileGridLoader gridLoader = new FileGridLoader("correctFile");


        gridLoader.fillGrid(grid);

        assertEquals(grid.getCell(1,2).getValue(),3);
        assertEquals(grid.getCell(4,5).getValue(),6);
        assertEquals(grid.getCell(7,8).getValue(),9);


    }


}
