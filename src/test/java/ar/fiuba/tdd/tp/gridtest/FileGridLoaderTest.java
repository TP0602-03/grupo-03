package ar.fiuba.tdd.tp.gridtest;

import ar.fiuba.tdd.tp.grid.FileGridLoader;
import ar.fiuba.tdd.tp.grid.Grid;
import ar.fiuba.tdd.tp.grid.SudokuFileGridLoader;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by luciano on 28/09/16.
 */
public class FileGridLoaderTest {


    @Test
    public void isCommentReturnsTrueTest() throws FileNotFoundException,UnsupportedEncodingException {

        //Create a file to load from
        PrintWriter writer = new PrintWriter("commentFile", "UTF-8");
        writer.println("#this is a comment");
        writer.close();

        FileGridLoader floader = new SudokuFileGridLoader("commentFile"); //Only so that the creation does not throw exception.

        assertTrue(floader.isComment("#this is a comment"));


    }

    @Test
    public void isCommentReturnsFalseTest() throws FileNotFoundException,UnsupportedEncodingException {

        //Create a file to load from
        PrintWriter writer = new PrintWriter("commentFile", "UTF-8");
        writer.println("#this is a comment");
        writer.close();

        FileGridLoader floader = new SudokuFileGridLoader("commentFile"); //Only so that the creation does not throw exception.

        assertFalse(floader.isComment("this is not a comment"));


    }
}
