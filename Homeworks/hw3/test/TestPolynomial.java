import org.junit.*;
import static org.junit.Assert.*;

/**
 * Junit test for class Polynomial.
 * @author  'Ingrid' Xiaoying Liu
 * @version 1.0
 * @since   2021-06-22
 */
public class TestPolynomial {
    /**
     * Test Polynomial Class.
     * Created enough test cases for the testsuite.
     */
    private PolynomialImpl p1;
    private PolynomialImpl p2;
    private PolynomialImpl p3;
    private PolynomialImpl p4;
    private PolynomialImpl p5;

    private PolynomialImpl Fx1;
    private PolynomialImpl Fx2;

    private PolynomialImpl pEmpty;

    private PolynomialImpl pTest;


    /**
     * The myTestSetUp() is setting up the value of the polynomial I create.
     */
    @Before
    public void myTestSetUp() {
        p1 = new PolynomialImpl(5, 2);      // 5x^2
        p2 = new PolynomialImpl(4, 1);
        p3 = new PolynomialImpl(2, 0);
        p4 = new PolynomialImpl(-5, 1);
        p5 = new PolynomialImpl(-5, 0);

    }

    /**
     * The testConstructor tests the constructors of the Polynomial.
     */
    @Test
    public void testConstructor() {
        assertEquals("0", pEmpty.toString());
        pTest = new PolynomialImpl(-1, 3);
        assertEquals("-1x^3", pTest.toString());
    }

    /**
     * The testToString is testing the toString method of the Polynomial.
     */
    @Test
    public void testToString() {
        assertEquals("5x^2", p1.toString());
    }

    /**
     * The testToString is testing the addTerm method of the Polynomial.
     */
    @Test
    public void testAddTerm() {
        Polynomial pAddTerm1 = new PolynomialImpl();
        pAddTerm1 = p1.addTerm(4, 1);
        assertEquals("5x^2 + 4x", pAddTerm1.toString());

        Polynomial pAddTerm2 = new PolynomialImpl();
        pAddTerm2 = pAddTerm1.addTerm(2, 0);
        assertEquals("5x^2 + 4x + 2", pAddTerm2.toString());
    }

    /**
     * The testAdd is testing the add method of the Polynomial.
     */
    @Test
    public void testAdd() {
        Fx1 = new PolynomialImpl();
        Fx1 = (PolynomialImpl) p1.addTerm(4, 1).addTerm(2, 0);

        Fx2 = new PolynomialImpl();
        Fx2 = (PolynomialImpl) p4.addTerm(-5, 0);

        Polynomial Fx = new PolynomialImpl();
        Fx = Fx1.add(Fx2);

        assertEquals("5x^2 - 1x - 3", Fx.toString());
    }

    /**
     * The testGetDegree is testing the getDegree method of the Polynomial.
     */
    @Test
    public void testGetDegree() {
        Polynomial pTest1 = new PolynomialImpl(5, 3);
        pTest1 = pTest1.addTerm(6, 8).addTerm(3, 2);
        assertEquals(8,pTest1.getDegree());

        Polynomial pTest2 = new PolynomialImpl(-1, 0);
        assertEquals(0, pTest2.getDegree());
    }

    /**
     * The testParse is testing the constructor which receives a string of a polynomial.
     */
    @Test
    public void testParse() {
        Polynomial polyParse = new PolynomialImpl("5x^2 +4x^1 +2x^0");
        System.out.println(polyParse);

    }


}
