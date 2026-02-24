package dev;

import java.util.ArrayList;
import java.util.List;

public class ScoreParser {

    public static List<Integer> parse(String stringScore) {
        List<Integer> res = new ArrayList<>();
        String[] parts = stringScore.split("-");
        if(parts.length != 2 || !isNumeric(parts[0]) || !isNumeric(parts[1])) {
            throw new IllegalArgumentException("Invalid score format");
        }
        int p1 = Integer.parseInt(parts[0]);
        res.add(p1);
        int p2 = Integer.parseInt(parts[1]);
        res.add(p2);
        return res;
    }

    private static boolean isNumeric(String str) {
        if(str.isEmpty()) return false;
        for (Character c: str.toCharArray()) {
            if(!Character.isDigit(c)) return false;
        }
        return true;
    }
}
