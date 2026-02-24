package dev;

public class FifteenTranslator implements IPointTranslator {

    @Override
    public boolean applies(int number) {
        return number == 1;
    }

    @Override
    public String translate(int points) {
        return "Fifteen";
    }
}
