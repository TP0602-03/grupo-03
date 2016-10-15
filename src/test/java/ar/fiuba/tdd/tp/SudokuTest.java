package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.parser.Parser;
import org.junit.Test;

public class SudokuTest {
    public void printBoard(Game game) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Object a = game.getCell(i, j).getAttribute("num");
                if (a != null) {
                    System.out.print(" " + a + " |");
                } else {
                    System.out.print("   |");
                }

            }
            System.out.println();
            System.out.println("----------------");
        }
    }

    @Test
    public void sudokuTest() throws Exception {

        Parser parser = new Parser("gameFiles/sudoku.json");
        Game game = parser.getGame();


        printBoard(game);


        game.playCell(0, 3, "num", 2);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());


        game.playCell(1, 0, "num", 1);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());


        game.playCell(1, 2, "num", 3);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());

        game.playCell(1, 3, "num", 4);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());

        game.playCell(2, 1, "num", 3);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());

        game.playCell(2, 3, "num", 1);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());

        game.playCell(2, 0, "num", 4);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());

        game.playCell(3, 0, "num", 2);
        printBoard(game);
        System.out.println("rules ok: " + game.validateRules());


/*        Parser parser = null;
        try {
            parser = new Parser("gameFiles/sudoku.json");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        Game game = parser.getGame();


        printBoard(game);
        Scanner in = new Scanner(System.in);

        while(!game.validateRules()){
            System.out.println("row: ");
            int row = in.nextInt();

            System.out.println("col: ");
            int col = in.nextInt();
            System.out.println("num: ");
            int num = in.nextInt();
            game.playCell(row,col,"num",num);
            printBoard(game);
            System.out.println("rules ok: " + game.validateRules());
        }
        System.out.println("YOU WON!");*/
        /*public static void printBoard(Game game){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    Object a = game.getCell(i,j).getAttribute("num");
                    if (a != null) {
                        System.out.print(" " + a + " |");
                    } else {
                        System.out.print("   |");
                    }

                }
                System.out.println();
                System.out.println("----------------");
            }
        }*/
    }
}
