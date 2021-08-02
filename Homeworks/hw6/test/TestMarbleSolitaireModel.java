import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMarbleSolitaireModel {
    MarbleSolitaireModel modelTest = new MarbleSolitaireModelImpl();

    @Before
    public void setUpTest() {
        // no pre-setup this time
    }

    @Test
    public void testConstructor1() {
        MarbleSolitaireModelImpl modelTest1 = new MarbleSolitaireModelImpl();

        String expected = "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O";
        assertEquals(expected, modelTest1.getGameState());

    }

    @Test
    public void testConstructor2() {
        MarbleSolitaireModelImpl modelTest2 = new MarbleSolitaireModelImpl(3,2);

        String expected = "    O O O\n" +
                "    O O O\n" +
                "O O O O O O O\n" +
                "O O _ O O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O";
        assertEquals(expected, modelTest2.getGameState());
    }

    // Test on passing an invalid centerCell position
    @Test (expected = Exception.class)
    public void testConstructor2ExceptionCase1() {
        MarbleSolitaireModelImpl modelTest2 = new MarbleSolitaireModelImpl(1,5);
    }

    @Test
    public void testConstructor3() {
        MarbleSolitaireModelImpl modelTest3 = new MarbleSolitaireModelImpl(7);

        String expected = "        O O O O O O O\n" +
                "        O O O O O O O\n" +
                "        O O O O O O O\n" +
                "        O O O O O O O\n" +
                "O O O O O O O O O O O O O O O\n" +
                "O O O O O O O O O O O O O O O\n" +
                "O O O O O O O O O O O O O O O\n" +
                "O O O O O O O _ O O O O O O O\n" +
                "O O O O O O O O O O O O O O O\n" +
                "O O O O O O O O O O O O O O O\n" +
                "O O O O O O O O O O O O O O O\n" +
                "        O O O O O O O\n" +
                "        O O O O O O O\n" +
                "        O O O O O O O\n" +
                "        O O O O O O O";
        assertEquals(expected, modelTest3.getGameState());
    }

    // Test on passing a negative thickness to the constructor
    @Test (expected = Exception.class)
    public void testConstructor3ExceptionCase1() {
        MarbleSolitaireModelImpl modelTest3a = new MarbleSolitaireModelImpl(-3);
    }

    // Test on passing a even thickness to the constructor
    @Test (expected = Exception.class)
    public void testConstructor3ExceptionCase2() {
        MarbleSolitaireModelImpl modelTest3b = new MarbleSolitaireModelImpl(6);
    }

    @Test
    public void testConstructor4() {
        MarbleSolitaireModelImpl modelTest4 = new MarbleSolitaireModelImpl(5,4,5);

        String expected = "      O O O O O\n" +
                "      O O O O O\n" +
                "      O O O O O\n" +
                "O O O O O O O O O O O\n" +
                "O O O O O _ O O O O O\n" +
                "O O O O O O O O O O O\n" +
                "O O O O O O O O O O O\n" +
                "O O O O O O O O O O O\n" +
                "      O O O O O\n" +
                "      O O O O O\n" +
                "      O O O O O";
        assertEquals(expected, modelTest4.getGameState());

    }

    @Test (expected = Exception.class)
    public void testConstructor4ExceptionCase1() {
        MarbleSolitaireModelImpl modelTest4a = new MarbleSolitaireModelImpl(-1,4,5);

    }
    @Test (expected = Exception.class)
    public void testConstructor4ExceptionCase2() {
        MarbleSolitaireModelImpl modelTest4b = new MarbleSolitaireModelImpl(4,3,3);
    }

    @Test(expected = Exception.class)
    public void testConstructor4ExceptionCase3() {
        MarbleSolitaireModelImpl modelTest4c = new MarbleSolitaireModelImpl(5,0,2);
    }

    @Test
    public void testMove() {
        modelTest.move(5,3,3,3);
        modelTest.move(2,3,4,3);
        modelTest.move(3,1,3,3);
        modelTest.move(0,3,2,3);
        modelTest.move(3,3,5,3);
        modelTest.move(6,3,4,3);
        modelTest.move(3,5,3,3);
        modelTest.move(3,3,1,3);
        modelTest.move(2,1,2,3);
        modelTest.move(2,4,2,2);
        modelTest.move(2,6,2,4);
        modelTest.move(4,6,2,6);
        String expected = "    O _ O\n" +
                "    O O O\n" +
                "O _ O _ O _ O\n" +
                "O _ _ _ _ _ _\n" +
                "O O O O O O _\n" +
                "    O _ O\n" +
                "    O _ O";
        assertEquals(expected, modelTest.getGameState());


        modelTest.move(4,4,4,6);
        modelTest.move(4,2,4,4);
        modelTest.move(6,2,4,2);
        modelTest.move(5,4,3,4);
        modelTest.move(4,1,4,3);
        modelTest.move(1,2,3,2);
        modelTest.move(2,4,4,4);
        modelTest.move(4,4,4,2);
        modelTest.move(3,2,5,2);
        modelTest.move(0,4,2,4);

        String expected2 = "    O _ _\n" +
                "    _ O _\n" +
                "O _ _ _ O _ O\n" +
                "O _ _ _ _ _ _\n" +
                "O _ _ _ _ _ O\n" +
                "    O _ _\n" +
                "    _ _ O";
        assertEquals(expected2, modelTest.getGameState());

    }

    @Test
    public void testIsGameOver() {
        modelTest.move(5,3,3,3);
        modelTest.move(2,3,4,3);
        modelTest.move(3,1,3,3);
        modelTest.move(0,3,2,3);
        modelTest.move(3,3,5,3);
        modelTest.move(6,3,4,3);
        modelTest.move(3,5,3,3);
        modelTest.move(3,3,1,3);
        modelTest.move(2,1,2,3);
        modelTest.move(2,4,2,2);
        modelTest.move(2,6,2,4);
        modelTest.move(4,6,2,6);
        assertFalse(modelTest.isGameOver());

        modelTest.move(4,4,4,6);
        modelTest.move(4,2,4,4);
        modelTest.move(6,2,4,2);
        modelTest.move(5,4,3,4);
        modelTest.move(4,1,4,3);
        modelTest.move(1,2,3,2);
        modelTest.move(2,4,4,4);
        modelTest.move(4,4,4,2);
        modelTest.move(3,2,5,2);
        modelTest.move(0,4,2,4);
        assertTrue(modelTest.isGameOver());
    }

    @Test
    public void testGetScore() {
        modelTest.move(5,3,3,3);
        modelTest.move(2,3,4,3);
        modelTest.move(3,1,3,3);
        modelTest.move(0,3,2,3);
        modelTest.move(3,3,5,3);
        modelTest.move(6,3,4,3);
        modelTest.move(3,5,3,3);
        modelTest.move(3,3,1,3);
        modelTest.move(2,1,2,3);
        modelTest.move(2,4,2,2);
        modelTest.move(2,6,2,4);
        modelTest.move(4,6,2,6);
        assertEquals(20, modelTest.getScore());

        modelTest.move(4,4,4,6);
        modelTest.move(4,2,4,4);
        modelTest.move(6,2,4,2);
        modelTest.move(5,4,3,4);
        modelTest.move(4,1,4,3);
        modelTest.move(1,2,3,2);
        modelTest.move(2,4,4,4);
        modelTest.move(4,4,4,2);
        modelTest.move(3,2,5,2);
        modelTest.move(0,4,2,4);
        assertEquals(10, modelTest.getScore());
    }

}
