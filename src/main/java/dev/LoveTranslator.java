package dev;

public class LoveTranslator implements IPointTranslator{

    @Override
    public boolean applies(int number) {
        return number == 0;
    }

    @Override
    public String translate(int points) {
        if(!applies(points)) {
            throw new IllegalArgumentException("Must be a number");
        }
        return "Love";
    }
}
