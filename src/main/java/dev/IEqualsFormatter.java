package dev;

public interface IEqualsFormatter {

    boolean applies (int p1, int p2);

    String format(String basicScore);
}
