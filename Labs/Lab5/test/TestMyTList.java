import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * This class tests on the TListImpl, TNode and TList.
 *
 * @author Xiaoying 'Ingrid' Liu
 * @version 1.0
 */

public class TestMyTList {

    /**
     * This creates a TNode num1 in type integer.
     */
    TNode<Integer> num1;
    /**
     * This creates a TNode num2 in type integer.
     */
    TNode<Integer> num2;
    /**
     * This creates a TNode num3 in type integer.
     */
    TNode<Integer> num3;

    /**
     * This creates a TNode word1 in type String.
     */
    TNode<String> word1;
    /**
     * This creates a TNode word2 in type String.
     */
    TNode<String> word2;
    /**
     * This creates a TNode word3 in type String.
     */
    TNode<String> word3;

    /**
     * This creates a TListImpl in Integer type.
     */
    private TListImpl<Integer> numList;
    /**
     * This creates a TListImpl in String type.
     */
    private TListImpl<String> strList;

    /**
     * This creates an empty TListImpl in Double type.
     */
    private TListImpl<Double> emptyList;

    /**
     * This setup my test cases by passing values to these
     * TNodes and TLists I created above.
     */
    @Before
    public void myTestSetUp() {
        num3 = new TNode<>(3);
        num2 = new TNode<>(2, num3);
        num1 = new TNode<>(1, num2);

        word3 = new TNode<>("c");
        word2 = new TNode<>("b", word3);
        word1 = new TNode<>("a", word2);

        numList = new TListImpl<>();
        numList.head = num1;

        strList = new TListImpl<>();
        strList.head = word1;

        emptyList = new TListImpl<>();
    }

    /**
     * This is the required test 4-1, which is testOddTs. It tests that
     * whether my testOddTs works.
     */
    @Test
    public void testOddTs() {
        numList.add(4); numList.add(5); numList.add(6); numList.add(7); numList.add(8);
        assertEquals("2 4 6 8 ", numList.oddTs().toString());

        strList.add("d"); strList.add("e"); strList.add("f"); strList.add("g"); strList.add("h");
        assertEquals("b d f h ", strList.oddTs().toString());
    }

    /**
     * This is the required test 4-2, which is testOddTs with an Exception throws.
     * It tests that whether my testOddTs' exception throws as expected.
     * @throws IllegalArgumentException as expected
     */
    @Test (expected = IllegalArgumentException.class)
    public void testOddTsException() {
        emptyList.oddTs();
        strList.remove(2); strList.remove(1); strList.remove(0);
        strList.oddTs();
    }

    /**
     * This is the required test 4-3, which is testEvenTs. It tests that
     * whether my testEvenTs works.
     */
    @Test
    public void testEvenTs() {
        numList.add(4); numList.add(5); numList.add(6); numList.add(7); numList.add(8);
        assertEquals("1 3 5 7 ", numList.evenTs().toString());

        strList.add("d"); strList.add("e"); strList.add("f"); strList.add("g"); strList.add("h");
        assertEquals("a c e g ", strList.evenTs().toString());
    }

    /**
     * This is the required test 4-2, which is testEvenTs with an Exception throws.
     * It tests that whether my testEvenTs' exception throws as expected.
     * @throws IllegalArgumentException as expected
     */
    @Test (expected = IllegalArgumentException.class)
    public void testEvenTsException() {
        emptyList.evenTs();
        numList.remove(2); numList.remove(1); numList.remove(0);
        numList.evenTs();
    }

    // Non-requirement part: only test for myself. Please ignore the following code.
    @Test
    public void testConstructorWithoutArgument() {
        assertNull(emptyList.head);
    }

    @Test
    public void testConstructorWithArgument() {
        assertEquals("1", numList.head.toString().trim());
        assertEquals("a", strList.head.toString().trim());
    }

    @Test
    public void testAdd() {
        assertTrue(numList.add(4));
        assertEquals("4",numList.get(3).toString());
    }

    @Test
    public void getter() {
        assertEquals("1", numList.get(0).toString());
        assertEquals("a", strList.get(0));

        assertEquals("3", numList.get(2).toString());
        assertEquals("c", strList.get(2));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void getterException() {
        numList.get(10);
        strList.get(100);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(emptyList.isEmpty());
        assertFalse(numList.isEmpty());
        assertFalse(strList.isEmpty());
    }

    @Test
    public void testRemove() {
        strList.remove(0);
        assertEquals("b c", strList.toString().trim());

        strList.remove(1);
        assertEquals("b", strList.toString().trim());

        numList.remove(0);
        assertEquals("2 3", numList.toString().trim());

        numList.remove(1);
        assertEquals("2", numList.toString().trim());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveException() {
        strList.remove(10);
        numList.remove(100);
    }

    @Test
    public void testSize() {
        assertEquals(3, numList.size());
        numList.add(4);
        assertEquals(4, numList.size());

        assertEquals(3, strList.size());
        strList.remove(0);
        assertEquals(2, strList.size());
    }

    @Test
    public void testToString() {
        assertEquals("1 2 3 ", numList.toString());
        assertEquals("a b c ", strList.toString());
    }

}
