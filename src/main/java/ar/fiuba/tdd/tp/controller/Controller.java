package ar.fiuba.tdd.tp.controller;

public interface Controller {

    void setView();

    void notifyModel(int column, int row, int userInput);

}