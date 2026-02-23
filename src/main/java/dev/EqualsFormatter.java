package dev;

public class EqualsFormatter implements IEqualsFormatter {
    @Override
    public boolean applies(int p1, int p2) {
        return (p1 == p2 && p1 > 0 && p1 < 3); //Fifteen-all y thirty-all
    }

    @Override
    public String format(String basicScore) {
        if(!(basicScore.split("-")[0].equals("Fifteen") || basicScore.split("-")[0].equals("Thirty"))) {
            throw new IllegalArgumentException("Points are not equals");
        }
        return basicScore.split("-")[0] + "-All";
    }
}
