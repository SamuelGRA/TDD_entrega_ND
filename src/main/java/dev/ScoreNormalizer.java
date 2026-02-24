package dev;

import java.util.ArrayList;
import java.util.List;

public class ScoreNormalizer {

    public static List<Integer> normalize(List<Integer> points) {
        List<Integer> res = new ArrayList<>();
        int p1 = points.get(0);
        int p2 = points.get(1);

        if(p1 <= 3 && p2 <= 3) {
            res.add(p1);
            res.add(p2);
            return res;
        }

        int diff = p1 - p2;
        if(diff < 0) {
            int p1norm = 3;
            int p2norm = 3 + Math.abs(diff);
            res.add(p1norm);
            res.add(p2norm);
        } else {
            int p2norm = 3;
            int p1norm = 3 + Math.abs(diff);
            res.add(p1norm);
            res.add(p2norm);
        }

        return res;

    }
}
