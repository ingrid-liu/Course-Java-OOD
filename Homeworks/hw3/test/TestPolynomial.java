import org.junit.*;
import static org.junit.Assert.*;

/**
 * Junit test for class Polynomial.
 * @author  'Ingrid' Xiaoying Liu
 * @version 1.0
 * @since   2021-06-22
 */
public class TestPolynomial {
    private TermNode termA0 = new TermNode();
    private TermNode termA1 = new TermNode();
    private TermNode termA2 = new TermNode();
    private TermNode termA3 = new TermNode();
    private TermNode termB1 = new TermNode();
    private TermNode termB2 = new TermNode();

    private PolynomialImpl pEmty = new PolynomialImpl();        // todo Question1: can I set as Polynomial only :(
    private PolynomialImpl p1 = new PolynomialImpl();
    private PolynomialImpl p2 = new PolynomialImpl();

   @Before
   public void myTestSetUp() {
       TermNode termA1 = new TermNode(5, 4);
       TermNode termA2 = new TermNode(2, 3);
       TermNode termA3 = new TermNode(3, 2);
       TermNode termB1 = new TermNode(-5, 5);
       TermNode termB2 = new TermNode(-5, 2);

       termA1.link = termA2;
       termA2.link = termA3;
       termB1.link = termB2;

       p1.head = termA1;
       p2.head = termB1;
   }

    @Test
    public void testConstructor() {
       Polynomial pTest = new PolynomialImpl();
        assertEquals(null, null);
    }

    @Test
    public void testConstructor2() {
        Polynomial pTest1 = new PolynomialImpl("-5x^6 +5x^2 +2x^1");
        assertEquals("-5x^6 +5x^2 +2x^1", pTest1.toString());

        Polynomial pTest2 = new PolynomialImpl("5x^2 +2x^1");
        assertEquals("5x^2 +2x^1", pTest2.toString());

        Polynomial pTest3 = new PolynomialImpl("7x^8 -5x^6 +5x^2 +2x^1");
        assertEquals("7x^8 -5x^6 +5x^2 +2x^1", pTest3.toString());

        // todo Question2 it won't work if I only pass x^2 or -x^2; I need to give it an 1
        Polynomial pTest4 = new PolynomialImpl("3x^5 -1x^4 +3x^3 -2x^2");
        assertEquals("3x^5 -x^4 +3x^3 -2x^2", pTest4.toString());
    }

    @Test
    public void testAddTerm() {
        // addTerm to an empty polynomial
        assertEquals("4x^2", pEmty.addTerm(4, 2).toString());

        // addTerm to existing polynomial
        // Original p1 = 5x^4 +2x^3 +3x^2
        assertEquals("3x^5 +5x^4 +2x^3 +3x^2", p1.addTerm(3,5).toString());
        assertEquals("3x^5 +5x^4 +x^3 +3x^2", p1.addTerm(-1, 3).toString());
        assertEquals("3x^5 +5x^4 +x^3 +3x^2 -5x^1", p1.addTerm(-5, 1).toString());
    }

    @Test (expected = Exception.class)
    public void testAddTermException() throws Exception {
        p1.addTerm(3, -3);
    }

    @Test
    public void testAdd() {
        PolynomialImpl p1 = new PolynomialImpl("5x^4 +2x^3 +3x^2");
        PolynomialImpl p2 = new PolynomialImpl("-5x^5 -5x^2");          // Todo: can't set Polynomial because add() needs a PolyImpl :(

        assertEquals("-5x^5 +5x^4 +2x^3 -2x^2", p1.add(p2).toString());
    }

//    @Test (expected = Exception.class)
//    public void testAddException() throws Exception {
//        p1.add(termA1);
//    }

    @Test
    public void testRemoveTerm () {
        System.out.println(p1);
        // p1 = 5x^4 +2x^3 +3x^2
        // p1.removeTerm(4);   // Todo Result:  +2x^3 +3x^2 (first node should remove whitespace & +
        p1.removeTerm(3);       // Todo result: 5x^4  +3x^2     (should delete one white space!!!!
        assertEquals("5x^4  +3x^2", p1.toString());
        p1.removeTerm(2);
        assertEquals("5x^4  ", p1.toString());   // Todo should delete th white space!!!!
    }

    @Test (expected = Exception.class)
    public void testRemoveTermException() throws Exception {
       p1.removeTerm(-2);
    }

    @Test
    public void testGetDegree () {
        /**
         * p1 = 5x^4 +2x^3 +3x^2
         * p2 = -5x^5 -5x^2
         */
        assertEquals(4, p1.getDegree());
        assertEquals(5, p2.getDegree());
    }

    @Test (expected = Exception.class)
    public void testGetCoefException() throws Exception {
        p1.getCoefficient(-2);
    }

    @Test
    public void testGetCoefficient () {
        /**
         * p1 = 5x^4 +2x^3 +3x^2
         * p2 = -5x^5 -5x^2
         */
        assertEquals(2, p1.getCoefficient(3));
        assertEquals(5, p1.getCoefficient(4));
        assertEquals(-5, p2.getCoefficient(2));
        assertEquals(0, p2.getCoefficient(6));
    }

    @Test
    public void testEvaluate () {
        /**
         * p1 = 5x^4 +2x^3 +x^2 (x=2.0) result = 100.0
         * p1 = 5x^4 +2x^3 +x^2 (x=-1) result = 4.0
         */
        assertEquals(108.0, p1.evaluate(2.0), 0.01);
        assertEquals(6.0, p1.evaluate(-1), 0.01);
        assertEquals(-19.64, p2.evaluate(1.2), 0.01);
        assertEquals(-0.2, p2.evaluate(-0.2), 0.01);
    }

    @Test
    public void testToString () {
        assertEquals("5x^4 +2x^3 +3x^2", p1.toString());
        assertEquals("-5x^5 -5x^2", p2.toString());
    }












}
