import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;


public class PetRockTest {
    private PetRock rocky;

    // Timeout rule:
    @Rule
    public Timeout globalTimeout = Timeout.seconds(100); // 10 seconds ms

    @Before                 // @BeforeClass only do once!
    public void myTestSetUp() throws Exception {
        rocky = new PetRock("Rocky");
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Rocky", rocky.getName());
    }

    @Test
    public void testUnhappyToStart() throws Exception {
        assertFalse(rocky.isHappy());
    }

    @Test
    public void testHappyAfterPlay() throws Exception {
        rocky.playWithRock();
        assertTrue(rocky.isHappy());
    }

//    @Ignore("Exception throwing now yet defined")
    @Test   (expected = IllegalStateException.class)
    public void nameFail() throws Exception {
        rocky.getHappyMessage();
    }

    @Test
    public void name() throws Exception {
        rocky.playWithRock();
        String msg = rocky.getHappyMessage();
        assertEquals("I'm happy!", msg);
    }

    @Test
    public void testFavNum()throws Exception {
        assertEquals(42, rocky.getFavNumber());
    }

    @Test   (expected = IllegalArgumentException.class)
    public void emptyNameFail() {
        new PetRock("");
    }

    @Test   (timeout = 100)   // in ms
    public void waitForHappyTimeout() throws Exception {
        rocky.waitTillHappy();
    }

    //Q2 Add a test for IllegalStateException when unhappy
    @Test   (expected = IllegalStateException.class)
    public void testUnhappy() throws Exception {
        rocky.isUnhappy();
    }

    // Q2 Add 1 other test involving exceptions(make PetRock throw one)
    @Test   (expected = IllegalStateException.class)
    public void testVaccination() {
        rocky.checkVaccine();
    }

    // Q3 Add one example in PetRock, i.e.compare assertSame to assertEquals using doubles
    @Test
    public void testFavFood() {
        String favFood = rocky.getFavFood();
        assertEquals("Meat ball!", favFood);
    }

    // Q4 Add a toString method in PetRock and JUnit
    @Test
    public void testToString() {
        PetRock rocky = new PetRock("Piglet",true, true);
        String expected = "We pickup a new PetRock!!\n" +
                "Its name: Piglet\n" +
                "Its happy condition: true\n" +
                "Its vaccinated condition: true\n";
        assertEquals(expected, rocky.toString());
    }

}