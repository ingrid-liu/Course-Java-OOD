import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ScientistTest {
    private Scientist scientist1;
    private Scientist scientist2;

    @Before
    public void myTestSetUp() throws Exception {
        scientist1 = new Scientist("Jobs", 40, "apapapa", "520520");
        scientist2 = new Scientist("Einstein", 66, "enenen", "12345",
                "Physics");
    }

    @Test
    public void testConstructorWithDefaultSpecialty() throws Exception {
        assertEquals("Jobs", scientist1.getName());
        assertEquals(40, scientist1.getAge());
        assertEquals("apapapa", scientist1.getSSN());
        assertEquals("520520", scientist1.getPassword());
        assertEquals("Computer Science", scientist1.getSpecialty());
    }

    @Test
    public void testConstructorWithPassingSpecialty() throws Exception {
        assertEquals("Einstein", scientist2.getName());
        assertEquals(66, scientist2.getAge());
        assertEquals("enenen", scientist2.getSSN());
        assertEquals("12345", scientist2.getPassword());
        assertEquals("Physics", scientist2.getSpecialty());
    }

    @Test   (expected = IllegalArgumentException.class)
    public void testConstructorWithPassingSpecialtyException() throws Exception {
        Scientist testScientist = new Scientist("Newton", 50, "nenene", "54321",
                "");
        assertEquals("Newton", scientist1.getName());
        assertEquals(50, scientist1.getAge());
        assertEquals("nenene", scientist1.getSSN());
        assertEquals("54321", scientist1.getPassword());
    }

    @Test
    public void testSetterGetter() throws Exception {
        scientist1.setSpecialty("Font Design");
        assertEquals("Font Design", scientist1.getSpecialty());
    }

    @Test   (expected = IllegalArgumentException.class)
    public void testSetSpecialtyException() throws Exception {
        scientist1.setSpecialty("");
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("This is a Scientist. Name: Einstein; Age: 66; Specialty: Physics",
                scientist2.toString());
    }
}
