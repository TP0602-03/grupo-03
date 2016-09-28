package ar.fiuba.tdd.tp.grid;

import ar.fiuba.tdd.tp.cell.BarredCell;
import ar.fiuba.tdd.tp.cell.OneDigitCell;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by luciano on 28/09/16.
 */
public class KakuroFileGridLoader extends FileGridLoader {

    public KakuroFileGridLoader(String newFilename) throws FileNotFoundException {
        super(newFilename);
    }

    protected void fillGrid(Grid grid) {

        Scanner fileScanner = this.fileScanner;


        while (fileScanner.hasNextLine()) {
            String cellInfo = fileScanner.nextLine();
            if(this.isComment(cellInfo)) {
                continue;
            }
            String[] parameters = cellInfo.split(" ");

            //Values should be row column value1 value2 (0 if null)

            int row = Integer.parseInt(parameters[0]);
            int column = Integer.parseInt(parameters[1]);
            Integer value1 = Integer.parseInt(parameters[2]);
            Integer value2 = Integer.parseInt(parameters[3]);
            if(value1 == 0) {
                value1 = null;
            }
            if(value2 == 0) {
                value2 = null;
            }

            BarredCell cell =  new BarredCell();
            cell.setValue(new Integer[]{value1,value2});
            grid.setCell(row,column,cell);

        }

        fileScanner.close();
    }



}
