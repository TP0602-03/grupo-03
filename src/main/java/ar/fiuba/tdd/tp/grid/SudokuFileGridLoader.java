package ar.fiuba.tdd.tp.grid;

import ar.fiuba.tdd.tp.cell.OneDigitCell;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by luciano on 27/09/16.
 */
public class SudokuFileGridLoader extends FileGridLoader {


    public SudokuFileGridLoader(String newFilename) throws FileNotFoundException {
        super(newFilename);
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
