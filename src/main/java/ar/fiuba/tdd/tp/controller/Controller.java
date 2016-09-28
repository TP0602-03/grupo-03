package ar.fiuba.tdd.tp.controller;

/**
 * Created by martin on 9/28/16.
 */
public interface Controller {
    void setView();

    void notifyModel(int x, int y, int userInput);
}
