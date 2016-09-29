package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.Controller;

public class KakuroDefaultCell extends SingleValueCell {

    String firstNumber;
    String secondNumber;

    public KakuroDefaultCell(Controller controller) {
        super(controller);
        this.textView.setEditable(false);
        this.textView.setFocusable(false);
    }

    public void setFirstNumber(Integer number) {

        firstNumber = String.valueOf(number);
        update();
    }

    public void setSecondNumber(Integer number) {

        secondNumber = String.valueOf(number);
        update();
    }

    private void update() {
        this.textView.setText(firstNumber + "\\" + secondNumber);
    }

    ;
}
