package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.rule.RuleCheckSum;
import ar.fiuba.tdd.tp.rule.RuleDistinctElements;
import org.junit.Test;

public class KakuroTest {
    @Test
    public void name() throws Exception {
        // Kakuro
        Game kakuro = new Game(4, 4);
        kakuro.getCell(0, 0).setAttribute("black", null);
        kakuro.getCell(0, 1).setAttribute("num_down", 17);
        kakuro.getCell(0, 2).setAttribute("num_down", 11);
        kakuro.getCell(0, 3).setAttribute("num_down", 17);

        kakuro.getCell(1, 0).setAttribute("num_right", 12);
        kakuro.getCell(2, 0).setAttribute("num_right", 21);
        kakuro.getCell(3, 0).setAttribute("num_right", 12);

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                kakuro.getCell(i, j).setAttribute("num", 0);
            }
        }

        Region reg1 = new Region();
        reg1.addVertex(kakuro.getCell(1, 1));
        reg1.addVertex(kakuro.getCell(1, 2));
        reg1.addVertex(kakuro.getCell(1, 3));

        reg1.addRule(new RuleCheckSum("num", 12));


        Region reg2 = new Region();
        reg2.addVertex(kakuro.getCell(2, 1));
        reg2.addVertex(kakuro.getCell(2, 2));
        reg2.addVertex(kakuro.getCell(2, 3));

        reg2.addRule(new RuleCheckSum("num", 21));

        Region reg3 = new Region();
        reg3.addVertex(kakuro.getCell(3, 1));
        reg3.addVertex(kakuro.getCell(3, 2));
        reg3.addVertex(kakuro.getCell(3, 3));

        reg3.addRule(new RuleCheckSum("num", 12));

        Region reg4 = new Region();
        reg4.addVertex(kakuro.getCell(1, 1));
        reg4.addVertex(kakuro.getCell(2, 1));
        reg4.addVertex(kakuro.getCell(3, 1));

        reg4.addRule(new RuleCheckSum("num", 17));

        Region reg5 = new Region();
        reg5.addVertex(kakuro.getCell(1, 2));
        reg5.addVertex(kakuro.getCell(2, 2));
        reg5.addVertex(kakuro.getCell(3, 2));

        reg5.addRule(new RuleCheckSum("num", 11));

        Region reg6 = new Region();
        reg6.addVertex(kakuro.getCell(1, 3));
        reg6.addVertex(kakuro.getCell(2, 3));
        reg6.addVertex(kakuro.getCell(3, 3));

        reg6.addRule(new RuleCheckSum("num", 17));

        reg1.addRule(new RuleDistinctElements("num"));
        reg2.addRule(new RuleDistinctElements("num"));
        reg3.addRule(new RuleDistinctElements("num"));
        reg4.addRule(new RuleDistinctElements("num"));
        reg5.addRule(new RuleDistinctElements("num"));
        reg6.addRule(new RuleDistinctElements("num"));

        kakuro.addRegion(reg1);
        kakuro.addRegion(reg2);
        kakuro.addRegion(reg3);
        kakuro.addRegion(reg4);
        kakuro.addRegion(reg5);
        kakuro.addRegion(reg6);

        System.out.println("---kakuro---");

        System.out.println("--- row 1 ---");

        kakuro.playCell(1, 1, "num", 1);
        System.out.println("--- 1 ---");
        kakuro.validateRules();
        kakuro.playCell(1, 2, "num", 5);
        System.out.println("--- 5 ---");
        kakuro.validateRules();
        kakuro.playCell(1, 3, "num", 6);
        System.out.println("--- 6 ---");
        kakuro.validateRules();

        System.out.println("--- row 2 ---");

        System.out.println("--- 9 ---");
        kakuro.playCell(2, 1, "num", 9);
        kakuro.validateRules();
        System.out.println("--- 4 ---");
        kakuro.playCell(2, 2, "num", 4);
        kakuro.validateRules();
        System.out.println("--- 8 ---");
        kakuro.playCell(2, 3, "num", 8);
        kakuro.validateRules();

        System.out.println("--- row 3 ---");

        System.out.println("--- 7 ---");
        kakuro.playCell(3, 1, "num", 7);
        kakuro.validateRules();
        System.out.println("--- 2 ---");
        kakuro.playCell(3, 2, "num", 2);
        kakuro.validateRules();
        System.out.println("--- 3 ---");
        kakuro.playCell(3, 3, "num", 3);
        kakuro.validateRules();

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                System.out.print(kakuro.getCell(i, j).getAttribute("num") + " ");
            }
            System.out.println();
        }

    }
}

