package ar.fiuba.tdd.tp.grid;

import ar.fiuba.tdd.tp.cell.InvalidValueTypeException;
import ar.fiuba.tdd.tp.cell.OneDigitCell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by luciano on 26/09/16.
 * This class lods a grid from a file
 */
public abstract class FileGridLoader extends GridLoader {

    protected Scanner fileScanner;

    public FileGridLoader(String newFilename) throws FileNotFoundException {

        this.fileScanner = new Scanner(new File(newFilename),"UTF-8");

    }



}
