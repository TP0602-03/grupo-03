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
public class FileGridLoader extends GridLoader {

    private Scanner fileScanner;

    public FileGridLoader(String newFilename) throws FileNotFoundException {

        this.fileScanner = new Scanner(new File(newFilename),"UTF-8");

    }

    protected void fillGrid(Grid grid) {


        Scanner fileScanner = this.fileScanner;


        while (fileScanner.hasNextLine()) {
            String cellInfo = fileScanner.nextLine();
            System.out.print(cellInfo);
            String[] parameters = cellInfo.split(" ");
            int row = Integer.parseInt(parameters[0]);
            int column = Integer.parseInt(parameters[1]);
            int value = Integer.parseInt(parameters[2]);
            grid.setCell(row,column,new OneDigitCell(value));

        }

        fileScanner.close();
    }


}
