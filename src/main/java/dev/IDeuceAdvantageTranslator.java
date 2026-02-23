package dev;

public interface IDeuceAdvantageTranslator {

    boolean applies (int number1, int number2);

    String translate(int number1, int number2);
}
