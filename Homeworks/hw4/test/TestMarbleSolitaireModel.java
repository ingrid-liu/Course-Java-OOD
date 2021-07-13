import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import org.junit.Before;
import org.junit.Test;

public class TestMarbleSolitaireModel {
    MarbleSolitaireModel modelTest = new MarbleSolitaireModelImpl();

    @Before
    public void setUpTest() {
        // no pre-setup this time
    }

    @Test
    public void testConstructor1() {
        MarbleSolitaireModelImpl modelTest1 = new MarbleSolitaireModelImpl();
        System.out.println(modelTest1.getGameState());
    }

    @Test
    public void testConstructor2() {
        MarbleSolitaireModelImpl modelTest2 = new MarbleSolitaireModelImpl(3,2);
        System.out.println(modelTest2.getGameState());
    }

    // Test on passing an invalid centerCell position
    @Test (expected = Exception.class)
    public void testConstructor2ExceptionCase1() {
        MarbleSolitaireModelImpl modelTest2 = new MarbleSolitaireModelImpl(1,5);
    }

    @Test
    public void testConstructor3() {
        MarbleSolitaireModelImpl modelTest3 = new MarbleSolitaireModelImpl(7);
        System.out.println(modelTest3.getGameState());
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
        System.out.println(modelTest4.getGameState());
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
        System.out.println(modelTest.getGameState());
//        modelTest.move(5,3, 3, 3);
//        System.out.println(modelTest.getGameState());

        MarbleSolitaireModelImpl modelTest2 = new MarbleSolitaireModelImpl(5);
        System.out.println(modelTest2.getGameState());

        MarbleSolitaireModelImpl modelTest3 = new MarbleSolitaireModelImpl(7);
        System.out.println(modelTest3.getGameState());

        MarbleSolitaireModelImpl modelTest4 = new MarbleSolitaireModelImpl(9);
        System.out.println(modelTest4.getGameState());
    }


}
