package dev;

public class ThirtyTranslator implements IPointTranslator {

    @Override
    public boolean applies(int number) {
        return number == 2;
    }

    @Override
    public String translate(int points) {
        if(!applies(points)) {
            throw new IllegalArgumentException("Must be a number");
        }
        return "Thirty";
    }
}
