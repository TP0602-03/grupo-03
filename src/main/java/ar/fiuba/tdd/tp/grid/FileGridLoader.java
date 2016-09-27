package ar.fiuba.tdd.tp.grid;

import ar.fiuba.tdd.tp.cell.InvalidValueTypeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by luciano on 26/09/16.
 * This class lods a grid from a file
 */
public class FileGridLoader extends GridLoader {

    private String filename;
    private File file;

    public FileGridLoader(String newFilename) throws FileNotFoundException {

        this.filename = newFilename;
        this.file = new File(this.filename);

    }

    public void fillGrid(Grid grid) throws InvalidFileLayoutException,FileNotFoundException {


        Scanner fileScanner = new Scanner(this.file,"UTF-8");

        while (fileScanner.hasNextLine()) {
            String cellInfo = fileScanner.nextLine();
            String[] parameters = cellInfo.split(" ");
            int row = Integer.parseInt(parameters[0]);
            int column = Integer.parseInt(parameters[1]);
            int value = Integer.parseInt(parameters[2]);
            try {
                grid.getCell(row, column).setValue(value);
            } catch (InvalidValueTypeException e) {
                throw new InvalidFileLayoutException("Invalid layout or value");
            }
        }

        fileScanner.close();
    }


}
