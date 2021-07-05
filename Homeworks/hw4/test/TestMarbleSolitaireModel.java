import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import org.junit.Before;
import org.junit.Test;

public class TestMarbleSolitaireModel {

    MarbleSolitaireModel modelTest1;
    MarbleSolitaireModel modelTest2;



    @Before
    public void setUpTest() {

    }


    @Test
    public void testConstructor1() {

    }

    @Test
    public void testConstructor2() {

    }

    // Test on passing a negative thickness to the constructor
    @Test (expected = Exception.class)
    public void testConstructor2ExceptionCase1() {
        modelTest1 = new MarbleSolitaireModelImpl(-3);
    }

    // Test on passing a even thickness to the constructor
    @Test (expected = Exception.class)
    public void testConstructor2ExceptionCase2() {
        modelTest1 = new MarbleSolitaireModelImpl(6);
    }

    @Test
    public void testConstructor3() {

    }

    @Test (expected = Exception.class)
    public void testConstructor3Exception() {

    }

    @Test
    public void testConstructor4() {

    }

    @Test (expected = Exception.class)
    public void testConstructor4Exception() {

    }










}
