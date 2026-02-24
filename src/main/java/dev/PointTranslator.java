package dev;

import java.util.List;

public class PointTranslator {

    private final IPointTranslator[] pointsTranslators;
    private final IDeuceAdvantageTranslator[] deuceAdvantageTranslators;
    private final IEqualsFormatter equalsFormatter;

    public PointTranslator() {
        pointsTranslators = new IPointTranslator[] {
                new LoveTranslator(),
                new FifteenTranslator(),
                new ThirtyTranslator(),
                new FortyTranslator()
        };
        deuceAdvantageTranslators = new IDeuceAdvantageTranslator[] {
                new DeuceTranslator(),
                new AdvantageTranslator(),
                new WinTranslator()
        };
        equalsFormatter = new EqualsFormatter();
    }

    public String translate(String stringPoints) {
        List<Integer> intPoints = ScoreParser.parse(stringPoints);
        List<Integer> normalizedPoints = ScoreNormalizer.normalize(intPoints);

        int p1 = normalizedPoints.get(0);
        int p2 = normalizedPoints.get(1);

        if (p1 + p2 >= 6) {
            return findEndgameTranslator(p1, p2).translate(p1, p2);
        }

        String score = formatScore(p1, p2);
        return equalsFormatter.applies(p1, p2)
                ? equalsFormatter.format(score)
                : score;

    }
    private String formatScore ( int p1, int p2){
        return formatPlayer(p1) + "-" + formatPlayer(p2);
    }

    private String formatPlayer ( int points){
        for (IPointTranslator translator : pointsTranslators) {
            if (translator.applies(points)) {
                return translator.translate(points);
            }
        }
        throw new IllegalStateException("No suitable translator found for points: " + points);
    }

    private IDeuceAdvantageTranslator findEndgameTranslator ( int p1, int p2) {
        for (IDeuceAdvantageTranslator translator : deuceAdvantageTranslators) {
            if (translator.applies(p1, p2)) {
                return translator;
            }
        }
        throw new IllegalStateException("No suitable translator found for " + p1 + "-" + p2);
    }

}
