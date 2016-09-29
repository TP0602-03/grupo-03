package ar.fiuba.tdd.tp.parser;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mvbattan on 29/09/16.
 */
public class FillerResolver {

    private HashMap<String, IFiller> fillerHashMap;

    public FillerResolver() {
        this.fillerHashMap = new HashMap<>();
        this.fillerHashMap.put("kakuro", new KakuroFiller());
        this.fillerHashMap.put("sudoku", new SudokuFiller());
    }

    public IFiller getFiller(String name) {
        return this.fillerHashMap.get(name);
    }
}
