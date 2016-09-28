package ar.fiuba.tdd.tp.grid;

import ar.fiuba.tdd.tp.cell.InvalidValueTypeException;
import ar.fiuba.tdd.tp.cell.OneDigitCell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by luciano on 26/09/16.
 * This class lods a grid from a file
 */
public class FileGridLoader extends GridLoader {

    protected Scanner fileScanner;

    @Override
    protected void fillGrid(Grid grid) {
    }

    public FileGridLoader(String newFilename) throws FileNotFoundException {

        this.fileScanner = new Scanner(new File(newFilename),"UTF-8");

    }

    public Boolean isComment(String line){
        Pattern regex = Pattern.compile("^#.*$");
        Matcher match = regex.matcher(line);
        return match.matches();
    }



}
