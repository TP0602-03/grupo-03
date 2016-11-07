package ar.fiuba.tdd.tp;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new MainRun());
    }

    private static class MainRun implements Runnable {
        private static final MainWindow window = new MainWindow();

        @Override
        public void run() {
            window.show();
        }
    }
}
