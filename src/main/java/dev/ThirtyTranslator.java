package dev;

public class ThirtyTranslator implements IPointTranslator {

    @Override
    public boolean applies(int number) {
        return number == 2;
    }

    @Override
    public String translate(int points) {
        return "Thirty";
    }
}
