package dev;

public class EqualsFormatter implements IEqualsFormatter {
    @Override
    public boolean applies(int p1, int p2) {
        return (p1 == p2 && p1 > 0 && p1 < 3); //Fifteen-all y thirty-all
    }

    @Override
    public String format(String basicScore) {
        return basicScore.split("-")[0] + "-All";
    }
}
