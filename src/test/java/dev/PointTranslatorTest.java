package dev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTranslatorTest {

    //Basic scoring

    @Test
    void shouldReturnLoveLove_OnStart(){

        PointTranslator translator = new PointTranslator();

        String res = translator.translate("0-0");

        assertEquals("Love-Love", res);

    }

    @Test
    void testPlayerOneScoresOnce_ShouldBeFifteenLove(){

        PointTranslator translator = new PointTranslator();

        String res = translator.translate("1-0");

        assertEquals("Fifteen-Love", res);
    }

    @Test
    void testPlayerTwoScoresOnce_ShouldBeLoveFifteen(){

        PointTranslator translator = new PointTranslator();

        String res = translator.translate("0-1");

        assertEquals("Love-Fifteen", res);
    }

    @Test
    void testBothPlayersScoreOnce_ShouldBeFifteenAll(){

        PointTranslator translator = new PointTranslator();

        String res = translator.translate("1-1");

        assertEquals("Fifteen-All", res);
    }

    @Test
    void testPlayerOneScoresTwice_ShouldBeThirtyLove(){

        PointTranslator translator = new PointTranslator();

        String res = translator.translate("2-0");

        assertEquals("Thirty-Love", res);
    }

    @Test
    void testplayerTwoScoresTwice_ShouldBeLoveThirty(){

        PointTranslator translator = new PointTranslator();

        String res = translator.translate("0-2");

        assertEquals("Love-Thirty", res);
    }

    //Deuce and advantage

    @Test
    void testScoreIsFortyAll_ShouldBeDeuce(){

        PointTranslator translator = new PointTranslator();

        String res = translator.translate("3-3");

        assertEquals("Deuce", res);
    }

    @Test
    void testPlayerOneAdvantageAfterDeuce_ShouldBeAdvantagePlayerOne(){

        PointTranslator translator = new PointTranslator();

        String res = translator.translate("4-3");

        assertEquals("Advantage player one", res);
    }

    @Test
    void testPlayerTwoAdvantageAfterDeuce_ShouldBeAdvantagePlayerTwo(){

        PointTranslator translator = new PointTranslator();

        String res = translator.translate("3-4");

        assertEquals("Advantage player two", res);
    }

    @Test
    void testPlayerOneWinsAfterAdvantage_ShouldBeWinPlayerOne(){

        PointTranslator translator = new PointTranslator();

        String res = translator.translate("5-3");

        assertEquals("Player one wins", res);
    }

    @Test
    void testPlayerTwoWinsAfterAdvantage_ShouldBeWinPlayerTwo(){

        PointTranslator translator = new PointTranslator();

        String res = translator.translate("3-5");

        assertEquals("Player two wins", res);
    }

    @Test
    void testAdvantageLost_BackToDeuce() {

        PointTranslator translator = new PointTranslator();

        String res = translator.translate("3-3"); //Vuelve a ser 3-3, en vez de escalar, se resta 1 punto
                                                        //al jugador que pierde la ventaja

        assertEquals("Deuce", res);

    }

    //Winning the game

    @Test
    void testPlayerOneWinsByTwoPoints_ShouldBeWinPlayerOne() {

        PointTranslator translator = new PointTranslator();

        String res = translator.translate("5-3");

        assertEquals("Player one wins", res);
    }

    @Test
    void testPlayerTwoWinsByTwoPoints_ShouldBeWinPlayerTwo() {

        PointTranslator translator = new PointTranslator();

        String res = translator.translate("3-5");

        assertEquals("Player two wins", res);
    }
}
