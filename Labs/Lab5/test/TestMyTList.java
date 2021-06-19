import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMyTList {
    TNode<Integer> num1;
    TNode<Integer> num2;
    TNode<Integer> num3;

    TNode<String> word1;
    TNode<String> word2;
    TNode<String> word3;

    private TListImpl<Integer> numList;
    private TListImpl<String> strList;

    private TListImpl<Double> emptyList;

    @Before
    public void myTestSetUp() throws Exception {
        num3 = new TNode<Integer>(3);
        num2 = new TNode<Integer>(2, num3);
        num1 = new TNode<Integer>(1, num2);

        word3 = new TNode<String>("c");
        word2 = new TNode<String>("b", word3);
        word1 = new TNode<String>("a", word2);

        numList = new TListImpl<>();
        numList.head = num1;

        strList = new TListImpl<>();
        strList.head = word1;

        emptyList = new TListImpl<>();
    }

    // REQUIREMENT TESTS
    @Test
    public void testOddTs() {
        numList.add(4); numList.add(5); numList.add(6); numList.add(7); numList.add(8);
        assertEquals("2 4 6 8 ", numList.oddTs().toString());

        strList.add("d"); strList.add("e"); strList.add("f"); strList.add("g"); strList.add("h");
        assertEquals("b d f h ", strList.oddTs().toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testOddTsException() {
        emptyList.oddTs();
        strList.remove(2); strList.remove(1); strList.remove(0);
        strList.oddTs();
    }

    @Test
    public void testEvenTs() {
        numList.add(4); numList.add(5); numList.add(6); numList.add(7); numList.add(8);
        assertEquals("1 3 5 7 ", numList.evenTs().toString());

        strList.add("d"); strList.add("e"); strList.add("f"); strList.add("g"); strList.add("h");
        assertEquals("a c e g ", strList.evenTs().toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEvenTsException() {
        emptyList.evenTs();
        numList.remove(2); numList.remove(1); numList.remove(0);
        numList.evenTs();
    }

    // OTHER TESTS
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
    public void getter() throws Exception {
        //assertEquals(1, numList.get(0));
        assertEquals("1", numList.get(0).toString());
        assertEquals("a", strList.get(0).toString());

        assertEquals("3", numList.get(2).toString());
        assertEquals("c", strList.get(2).toString());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void getterException() throws Exception {
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
