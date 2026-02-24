package dev;

public class LoveTranslator implements IPointTranslator{

    @Override
    public boolean applies(int number) {
        return number == 0;
    }

    @Override
    public String translate(int points) {
        return "Love";
    }
}
