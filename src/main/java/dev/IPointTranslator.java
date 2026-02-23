package dev;

public interface IPointTranslator {

    boolean applies(int number);

    String translate(int points);
}
