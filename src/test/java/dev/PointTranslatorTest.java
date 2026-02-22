package dev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTranslatorTest {

    //Basic scoring

    @Test
    void shouldReturnLoveLove_OnStart(){

        PointsTranslator translator = new PointsTranslator();

        String res = translator.translate("0-0");

        assertEquals("Love-Love", res);

    }

    @Test
    void testPlayerOneScoresOnce_ShouldBeFifteenLove(){

        PointsTranslator translator = new PointsTranslator();

        String res = translator.translate("1-0");

        assertEquals("Fifteen-Love", res);
    }

    @Test
    void testPlayerTwoScoresOnce_ShouldBeLoveFifteen(){

        PointsTranslator translator = new PointsTranslator();

        String res = translator.translate("0-1");

        assertEquals("Love-Fifteen", res);
    }

    @Test
    void testBothPlayersScoreOnce_ShouldBeFifteenAll(){

        PointsTranslator translator = new PointsTranslator();

        String res = translator.translate("1-1");

        assertEquals("Fifteen-All", res);
    }

    @Test
    void testPlayerOneScoresTwice_ShouldBeThirtyLove(){

        PointsTranslator translator = new PointsTranslator();

        String res = translator.translate("2-0");

        assertEquals("Thirty-Love", res);
    }

    @Test
    void testplayerTwoScoresTwice_ShouldBeLoveThirty(){

        PointsTranslator translator = new PointsTranslator();

        String res = translator.translate("0-2");

        assertEquals("Love-Thirty", res);
    }

    //Deuce and advantage

    @Test
    void testScoreIsFortyAll_ShouldBeDeuce(){

        PointsTranslator translator = new PointsTranslator();

        String res = translator.translate("3-3");

        assertEquals("Deuce", res);
    }

    @Test
    void testPlayerOneAdvantageAfterDeuce_ShouldBeAdvantagePlayerOne(){

        PointsTranslator translator = new PointsTranslator();

        String res = translator.translate("4-3");

        assertEquals("Advantage player one", res);
    }

    @Test
    void testPlayerTwoAdvantageAfterDeuce_ShouldBeAdvantagePlayerTwo(){

        PointsTranslator translator = new PointsTranslator();

        String res = translator.translate("3-4");

        assertEquals("Advantage player two", res);
    }

    @Test
    void testPlayerOneWinsAfterAdvantage_ShouldBeWinPlayerOne(){

        PointsTranslator translator = new PointsTranslator();

        String res = translator.translate("5-3");

        assertEquals("Player one wins", res);
    }

    @Test
    void testPlayerTwoWinsAfterAdvantage_ShouldBeWinPlayerTwo(){

        PointsTranslator translator = new PointsTranslator();

        String res = translator.translate("3-5");

        assertEquals("Player two wins", res);
    }

    @Test
    void testAdvantageLost_BackToDeuce() {

        PointsTranslator translator = new PointsTranslator();

        String res = translator.translate("4-4");

        assertEquals("Deuce", res);

    }

    //Winning the game

    @Test
    void testPlayerOneWinsByTwoPoints_ShouldBeWinPlayerOne() {

        PointsTranslator translator = new PointsTranslator();

        String res = translator.translate("5-3");

        assertEquals("Player one wins", res);
    }

    @Test
    void testPlayerTwoWinsByTwoPoints_ShouldBeWinPlayerTwo() {

        PointsTranslator translator = new PointsTranslator();

        String res = translator.translate("3-5");

        assertEquals("Player two wins", res);
    }
}
