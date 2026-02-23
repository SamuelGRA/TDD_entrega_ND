package dev;

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

    public String translate(String points) {
        String result = "";
        int pointsPlayer1 = Integer.parseInt(points.trim().split("-")[0]);
        int pointsPlayer2 = Integer.parseInt(points.trim().split("-")[1]);

        if(pointsPlayer1 + pointsPlayer2 >=  6) { //Hay que ver aqui como hacer para que la ventaja se quede siempre entre 5 y 3
            for(IDeuceAdvantageTranslator translator : deuceAdvantageTranslators) {
                if(translator.applies(pointsPlayer1, pointsPlayer2)) {
                    result = translator.translate(pointsPlayer1, pointsPlayer2);
                }
            }
        } else {
            for (IPointTranslator translator1 : pointsTranslators) {
                if (translator1.applies(pointsPlayer1)) {
                    result += translator1.translate(pointsPlayer1);
                    result += "-";
                }
            }
            for (IPointTranslator translator2 : pointsTranslators) {
                if(translator2.applies(pointsPlayer2)) {
                    result += translator2.translate(pointsPlayer2);
                }
            }
            if(equalsFormatter.applies(pointsPlayer1, pointsPlayer2)) {
                result = equalsFormatter.format(result);
            }
        }


        return result.isEmpty() ? points : result;
    }

}
