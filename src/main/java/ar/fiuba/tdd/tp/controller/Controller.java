package ar.fiuba.tdd.tp.controller;

public interface Controller {

    void setView();

    void notifyModel(int collumn, int raw, int userInput);

}