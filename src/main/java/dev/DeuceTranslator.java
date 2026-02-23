package dev;

public class DeuceTranslator implements IDeuceAdvantageTranslator {

    @Override
    public boolean applies(int number1, int number2) {
        return (number1 == 3 && number2 == 3);
    }

    @Override
    public String translate(int number1, int number2) {
        if (!applies(number1, number2)) {
            throw new IllegalArgumentException("Must be numbers");
        }
        return "Deuce";
    }
}
