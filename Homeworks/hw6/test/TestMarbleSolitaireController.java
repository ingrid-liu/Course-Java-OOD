import cs5004.marblesolitaire.controller.MarbleSolitaireController;
import cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static junit.framework.TestCase.assertEquals;


public class TestMarbleSolitaireController {
    String initBoard;

    @Before
    public void setMyInitBoard() {
        initBoard = "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n";
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor() {
        new MarbleSolitaireControllerImpl(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2() {
        new MarbleSolitaireControllerImpl(null, new StringBuilder("test"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3() {
        new MarbleSolitaireControllerImpl(new StringReader("test"), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testControllerWithNullModel() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("3 3 3 3 Q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(null);
    }

    @Test
    public void testController1() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("6 4 4 4 Q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "Score: 31\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "Score: 31", ap.toString());
    }

    @Test
    public void testController2() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("6 4 4 4 3 4 5 4 q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "Score: 31\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O _ O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "Score: 30\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O _ O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "Score: 30", ap.toString());
    }

    @Test
    public void testController3() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("2 2 2 2 Q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "Invalid move. Play again. Move must be valid\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 32\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 32", ap.toString());
    }

    @Test
    public void testController4() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("3 3 3 3 6 4 4 4 Q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "Invalid move. Play again. Move must be valid\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 32\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "Score: 31\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "Score: 31", ap.toString());
    }

    @Test
    public void testController5() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("4 4 5 5 Q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "Invalid move. Play again. Move must be valid\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 32\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 32", ap.toString());
        // System.out.println(ap.toString());
    }

    @Test
    public void testController6() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("2 4 4 4 Q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "    O O O\n" +
                "    O _ O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 31\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                "    O O O\n" +
                "    O _ O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 31", ap.toString());
    }

    @Test
    public void testController7() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("6 4 4 4 3 4 5 4 4 2 4 4 Q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "Score: 31\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O _ O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "Score: 30\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O _ O O O\n" +
                "O _ _ O O O O\n" +
                "O O O O O O O\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "Score: 29\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O _ O O O\n" +
                "O _ _ O O O O\n" +
                "O O O O O O O\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "Score: 29", ap.toString());
    }

    @Test
    public void playUntilGameOver() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("6 4 4 4 3 4 5 4 4 2 4 4 1 4 3 4 4 4 6 4 7 4 5 4 4 6 4 4" +
                " 4 4 2 4 3 2 3 4 3 5 3 3 3 7 3 5 5 7 3 7 5 5 5 7 5 3 5 5 7 3 5 3 6 5 4 5 5 2 5 4 2 3 4 3" +
                " 3 5 5 5 5 5 5 3 4 3 6 3 1 5 3 5 Q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "Score: 31\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O _ O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "Score: 30\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O _ O O O\n" +
                "O _ _ O O O O\n" +
                "O O O O O O O\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "Score: 29\n" +
                "    O _ O\n" +
                "    O _ O\n" +
                "O O O O O O O\n" +
                "O _ _ O O O O\n" +
                "O O O O O O O\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "Score: 28\n" +
                "    O _ O\n" +
                "    O _ O\n" +
                "O O O O O O O\n" +
                "O _ _ _ O O O\n" +
                "O O O _ O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 27\n" +
                "    O _ O\n" +
                "    O _ O\n" +
                "O O O O O O O\n" +
                "O _ _ _ O O O\n" +
                "O O O O O O O\n" +
                "    O _ O\n" +
                "    O _ O\n" +
                "Score: 26\n" +
                "    O _ O\n" +
                "    O _ O\n" +
                "O O O O O O O\n" +
                "O _ _ O _ _ O\n" +
                "O O O O O O O\n" +
                "    O _ O\n" +
                "    O _ O\n" +
                "Score: 25\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "O O O _ O O O\n" +
                "O _ _ _ _ _ O\n" +
                "O O O O O O O\n" +
                "    O _ O\n" +
                "    O _ O\n" +
                "Score: 24\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "O _ _ O O O O\n" +
                "O _ _ _ _ _ O\n" +
                "O O O O O O O\n" +
                "    O _ O\n" +
                "    O _ O\n" +
                "Score: 23\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "O _ O _ _ O O\n" +
                "O _ _ _ _ _ O\n" +
                "O O O O O O O\n" +
                "    O _ O\n" +
                "    O _ O\n" +
                "Score: 22\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "O _ O _ O _ _\n" +
                "O _ _ _ _ _ O\n" +
                "O O O O O O O\n" +
                "    O _ O\n" +
                "    O _ O\n" +
                "Score: 21\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "O _ O _ O _ O\n" +
                "O _ _ _ _ _ _\n" +
                "O O O O O O _\n" +
                "    O _ O\n" +
                "    O _ O\n" +
                "Score: 20\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "O _ O _ O _ O\n" +
                "O _ _ _ _ _ _\n" +
                "O O O O _ _ O\n" +
                "    O _ O\n" +
                "    O _ O\n" +
                "Score: 19\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "O _ O _ O _ O\n" +
                "O _ _ _ _ _ _\n" +
                "O O _ _ O _ O\n" +
                "    O _ O\n" +
                "    O _ O\n" +
                "Score: 18\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "O _ O _ O _ O\n" +
                "O _ _ _ _ _ _\n" +
                "O O O _ O _ O\n" +
                "    _ _ O\n" +
                "    _ _ O\n" +
                "Score: 17\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "O _ O _ O _ O\n" +
                "O _ _ _ O _ _\n" +
                "O O O _ _ _ O\n" +
                "    _ _ _\n" +
                "    _ _ O\n" +
                "Score: 16\n" +
                "    O _ O\n" +
                "    O O O\n" +
                "O _ O _ O _ O\n" +
                "O _ _ _ O _ _\n" +
                "O _ _ O _ _ O\n" +
                "    _ _ _\n" +
                "    _ _ O\n" +
                "Score: 15\n" +
                "    O _ O\n" +
                "    _ O O\n" +
                "O _ _ _ O _ O\n" +
                "O _ O _ O _ _\n" +
                "O _ _ O _ _ O\n" +
                "    _ _ _\n" +
                "    _ _ O\n" +
                "Score: 14\n" +
                "    O _ O\n" +
                "    _ O O\n" +
                "O _ _ _ _ _ O\n" +
                "O _ O _ _ _ _\n" +
                "O _ _ O O _ O\n" +
                "    _ _ _\n" +
                "    _ _ O\n" +
                "Score: 13\n" +
                "    O _ O\n" +
                "    _ O O\n" +
                "O _ _ _ _ _ O\n" +
                "O _ O _ _ _ _\n" +
                "O _ O _ _ _ O\n" +
                "    _ _ _\n" +
                "    _ _ O\n" +
                "Score: 12\n" +
                "    O _ O\n" +
                "    _ O O\n" +
                "O _ _ _ _ _ O\n" +
                "O _ _ _ _ _ _\n" +
                "O _ _ _ _ _ O\n" +
                "    O _ _\n" +
                "    _ _ O\n" +
                "Score: 11\n" +
                "    O _ _\n" +
                "    _ O _\n" +
                "O _ _ _ O _ O\n" +
                "O _ _ _ _ _ _\n" +
                "O _ _ _ _ _ O\n" +
                "    O _ _\n" +
                "    _ _ O\n" +
                "Score: 10\n" +
                "Game over!\n" +
                "    O _ _\n" +
                "    _ O _\n" +
                "O _ _ _ O _ O\n" +
                "O _ _ _ _ _ _\n" +
                "O _ _ _ _ _ O\n" +
                "    O _ _\n" +
                "    _ _ O\n" +
                "Score: 10\n", ap.toString());
    }

    @Test
    public void testUpperCaseQ() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("Q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                initBoard +
                "Score: 32", ap.toString());
    }

    @Test
    public void testLowerCaseQ() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                initBoard +
                "Score: 32", ap.toString());
    }

    @Test
    public void test2Qs() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("q Q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                initBoard +
                "Score: 32", ap.toString());
    }

    @Test
    public void test1NumberQuit() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("3 q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                initBoard +
                "Score: 32", ap.toString());
    }

    @Test
    public void test2NumbersQuit() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("2 1 q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                initBoard +
                "Score: 32", ap.toString());
    }

    @Test
    public void test3NumbersQuit() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("2 1 3 q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                initBoard +
                "Score: 32", ap.toString());
    }

    @Test
    public void test5NumbersQuit() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("1 2 3 4 4 q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "Invalid move. Play again. Move must be valid\n" +
                initBoard +
                "Score: 32\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                initBoard +
                "Score: 32", ap.toString());
    }

    @Test
    public void quitBeforeMove() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("Q 1 2 3 4");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                initBoard +
                "Score: 32", ap.toString());
    }

    @Test(expected = IllegalStateException.class)
    public void testBadInputs1() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);

        control.playGame(new MarbleSolitaireModelImpl());
    }

    @Test(expected = IllegalStateException.class)
    public void testBadInputs2() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader(" ");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
    }

    @Test
    public void testBadInputs3() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("TEST BAD INPUT Q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                initBoard +
                "Score: 32", ap.toString());
    }

    @Test
    public void testBadInputs4() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("-3 4 t 2 p 4 i 4 q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O _ _ O O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 31\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O _ _ O O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 31", ap.toString());
    }

    @Test(expected = IllegalStateException.class)
    public void failedTransmit() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("1 3 3 4");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
    }

    @Test
    public void invalidMove1() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("3 4 4 4 Q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "Invalid move. Play again. Move must be valid\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 32\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O\n" +
                "Score: 32", ap.toString());
    }

    @Test
    public void invalidMove2() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("10 10 10 10 Q");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
        assertEquals(initBoard +
                "Score: 32\n" +
                "Invalid move. Play again. Move must be valid\n" +
                initBoard +
                "Score: 32\n" +
                "Game quit!\n" +
                "State of game when quit:\n" +
                initBoard +
                "Score: 32", ap.toString());
    }

    @Test(expected = IllegalStateException.class)
    public void ranOutOfInputs() {
        StringBuilder ap = new StringBuilder();
        Reader rd = new StringReader("2 2 8 0");
        MarbleSolitaireController control = new MarbleSolitaireControllerImpl(rd, ap);
        control.playGame(new MarbleSolitaireModelImpl());
    }


    // TODO CHECK IF ALL THE EXCEPTIONS ARE COVERED!
}