package dev;

public class FortyTranslator implements IPointTranslator {
    @Override
    public boolean applies(int number) {
        return number == 3;
    }

    @Override
    public String translate(int points) {
        if (!applies(points)) {
            throw new IllegalArgumentException("Must be a number");
        }
        return "Forty";
    }
}
