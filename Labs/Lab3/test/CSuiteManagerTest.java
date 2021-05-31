import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CSuiteManagerTest {
    private CSuiteManager csManager1;
    private CSuiteManager csManager2;

    @Before
    public void myTestSetUp() throws Exception {
        csManager1 = new CSuiteManager("Elon Musk", 42, "555000", "tststs",
                "CEO");
        csManager2 = new CSuiteManager("Ryan", 24, "9999999", "sfsfsfsf",
                1000,0.5, "SDE");
    }

    @Test
    public void testConstructorWithDefaultParaValue() throws Exception {
        assertEquals("Elon Musk", csManager1.getName());
        assertEquals(42, csManager1.getAge());
        assertEquals("555000", csManager1.getSSN());
        assertEquals("tststs", csManager1.getPassword());
        assertEquals("CEO", csManager1.getFancyTitle());
        assertEquals(0, csManager1.getStockOptions());
        assertEquals(1.0, csManager1.getStrikePrice(), .0000001);
    }

    @Test
    public void testConstructorWithPassingParaValue() throws Exception {
        assertEquals("Ryan", csManager2.getName());
        assertEquals(24, csManager2.getAge());
        assertEquals("9999999", csManager2.getSSN());
        assertEquals("sfsfsfsf", csManager2.getPassword());
        assertEquals("SDE", csManager2.getFancyTitle());
        assertEquals(1000, csManager2.getStockOptions());
        assertEquals(0.5, csManager2.getStrikePrice(), .0000001);
    }

    @Test
    public void testSetterGetter() throws Exception {
        csManager1.setStockOptions(100000000);
        csManager1.setStrikePrice(0.01);
        csManager1.setFancyTitle("XSpace Board Member");
        assertEquals(100000000, csManager1.getStockOptions());
        assertEquals(0.01, csManager1.getStrikePrice(), .0000001);
        assertEquals("XSpace Board Member", csManager1.getFancyTitle());
    }

    @Test
    public void testOnePersonMethod() throws Exception {
        csManager1.setPassword("666000");
        assertEquals("666000", csManager1.getPassword());
    }

    @Test
    public void testExerciseCost() throws Exception {
        assertEquals(500.0, csManager2.exerciseCost(), .000001);
    }

    @Test
    public void testIncreaseOption() throws Exception {
        csManager2.increaseOption(10000);
        assertEquals(11000, csManager2.getStockOptions());
    }

    @Test   (expected = IllegalArgumentException.class)
    public void testIncreaseOptionException() throws Exception {
        csManager2.increaseOption(-1);
    }

    @Test
    public void testCapitalGain() throws Exception {
        assertEquals(799500.0, csManager2.capitalGain(800), .000001);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("This is a CSuiteManager. Name: Elon Musk; Age: 42; Title: CEO",
                csManager1.toString());
    }

    @Test
    public void testPrintStockInfo() {
        assertEquals("Stock option: 0\n" +
                "Strike price: $1.0\n" +
                "Exercise cost: $0.0\n" +
                "Captical gain: $0.0", csManager1.printStockInfo());

        assertEquals("Stock option: 1000\n" +
                "Strike price: $0.5\n" +
                "Exercise cost: $500.0\n" +
                "Captical gain: $500.0", csManager2.printStockInfo());
    }
}
