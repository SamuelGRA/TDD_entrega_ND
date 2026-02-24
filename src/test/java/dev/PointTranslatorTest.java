package dev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void testPlayerOneScoresThreeTimes_ShouldBeFortyLove(){
        PointTranslator translator = new PointTranslator();

        String res = translator.translate("3-0");

        assertEquals("Forty-Love", res);
    }

    @Test
    void testPlayerTwoScoresThreeTimes_ShouldBeLoveForty(){
        PointTranslator translator = new PointTranslator();

        String res = translator.translate("0-3");

        assertEquals("Love-Forty", res);
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

    //Extra tests

    @Test
    void shouldThrowExceptionOnNegativePunctuations() {
        PointTranslator translator = new PointTranslator();

        assertThrows(IllegalArgumentException.class,() -> translator.translate("-1--2"));
    }

    @Test
    void shouldThrowExceptionOnNotNumericParameters() {
        PointTranslator translator = new PointTranslator();

        assertThrows(IllegalArgumentException.class,() -> translator.translate("a-b"));
    }

    @Test
    void shouldThrowExceptionOnWrongFormat() {
        PointTranslator translator = new PointTranslator();

        assertThrows(IllegalArgumentException.class,() -> translator.translate("2 2"));
    }

    @Test
    void shouldThrowExceptionOnImpossibleScore() {
        PointTranslator translator = new PointTranslator();

        assertThrows(IllegalStateException.class,() -> translator.translate("7-1"));
    }

    @Test
    void shouldThrowExceptionOnOverWin() {
        PointTranslator translator = new PointTranslator();

        assertThrows(IllegalStateException.class,() -> translator.translate("0-5"));
    }

    @Test
    void largeEqualsAdvantage_ShouldBeDeuce() {
        PointTranslator translator = new PointTranslator();

        String res = translator.translate("11-11");

        assertEquals("Deuce", res);
    }

    @Test
    void largePlayerOneAdvantage_ShouldBeAdvantagePlayerOne() {
        PointTranslator translator = new PointTranslator();

        String res = translator.translate("22-21");

        assertEquals("Advantage player one", res);
    }

    @Test
    void largePlayerTwoAdvantage_ShouldBeAdvantagePlayerTwo() {
        PointTranslator translator = new PointTranslator();

        String res = translator.translate("14-15");

        assertEquals("Advantage player two", res);
    }

    @Test
    void largePlayerOneWin_ShouldBePlayerOneWins() {
        PointTranslator translator = new PointTranslator();

        String res = translator.translate("50-48");

        assertEquals("Player one wins", res);
    }

    @Test
    void largePlayerTwoWin_ShouldBePlayerTwoWins() {
        PointTranslator translator = new PointTranslator();

        String res = translator.translate("98-100");

        assertEquals("Player two wins", res);
    }

}
