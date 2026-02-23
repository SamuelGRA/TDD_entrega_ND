package dev;

public class WinTranslator implements IDeuceAdvantageTranslator {
    @Override
    public boolean applies(int number1, int number2) {
        return (Math.abs(number1 - number2) == 2);
    }
    @Override
    public String translate(int number1, int number2) {
        if(!applies(number1, number2)) {
            throw new IllegalArgumentException("Must be numbers");
        }
        if(number1 > number2) {
            return "Player one wins";
        } else {
            return "Player two wins";
        }
    }
}
