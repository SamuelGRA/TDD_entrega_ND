package dev;

public class AdvantageTranslator implements IDeuceAdvantageTranslator {
    @Override
    public boolean applies(int number1, int number2) {
        return (number1 == 4 || number2 == 4);
    }

    @Override
    public String translate(int number1, int number2) {
        if(!applies(number1, number2)){
            throw new IllegalArgumentException("Must be numbers");
        }
        if(number1 > number2){
            return "Advantage player one";
        } else {
            return "Advantage player two";
        }
    }
}
