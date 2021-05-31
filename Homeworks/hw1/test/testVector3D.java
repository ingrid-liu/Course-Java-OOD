import org.junit.*;
import static org.junit.Assert.*;

public class testVector3D {
    private Vector3D original;
    private Vector3D other;
    private Vector3D zeroVector;

    @Before
    public void myTestSetUp() throws Exception {
        original = new Vector3D(2.3, 3.5, 4.4);;
        other = new Vector3D(6.67, 3.45, 9.23);
        zeroVector = new Vector3D(0, 0, 0);
    }

    @Test
    public void testConstructorWithNonPara() throws Exception {
        Vector3D vector1 = new Vector3D();
        assertEquals(0.0, vector1.getX(),.000000001);
        assertEquals(0.0, vector1.getY(),.000000001);
        assertEquals(0.0, vector1.getZ(),.000000001);
    }

    @Test
    public void testConstructorWithPara() throws Exception {
        Vector3D vector2 = new Vector3D(2.3, 3.5, 4.4);
        assertEquals(2.3, vector2.getX(),.000000001);
        assertEquals(3.5, vector2.getY(),.000000001);
        assertEquals(4.4, vector2.getZ(),.000000001);
    }

    @Test
    public void testSetterGetter() throws Exception {
        Vector3D test = new Vector3D();
        test.setX(5.5);
        assertEquals(5.5, test.getX(),.000000001);
        test.setY(6.6);
        assertEquals(6.6, test.getY(),.000000001);
        test.setZ(7.7);
        assertEquals(7.7, test.getZ(),.000000001);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("(2.30, 3.50, 4.40)", original.toString());
    }

    @Test
    public void testGetMagnitude() throws Exception {
        assertEquals(6.074537019394977, original.getMagnitude(), .000000001);
    }

    @Test
    public void testNormalize() throws Exception {
        assertEquals(0.378629679, original.normalize().getX(), .000000001);
        assertEquals(0.576175598, original.normalize().getY(), .000000001);
        assertEquals(0.724335038, original.normalize().getZ(), .000000001);
    }

    @Test   (expected = IllegalStateException.class)
    public void testFailNormalize() throws Exception {
        zeroVector.normalize();
    }

    @Test
    public void testAddition() throws Exception {
        assertEquals(8.970000000,original.add(other).getX(),.000000001);
        assertEquals(6.95, original.add(other).getY(),.000000001);
        assertEquals(13.63, original.add(other).getZ(),.000000001);
    }

    @Test
    public void testMultiply() throws Exception {
        assertEquals(7.222000000, original.multiply(3.14).getX(),.000000001);
        assertEquals(10.99000000, original.multiply(3.14).getY(),.000000001);
        assertEquals(13.81600000, original.multiply(3.14).getZ(),.000000001);
    }

    @Test
    public void testDotProduct() throws Exception {
        assertEquals(68.028, original.dotProduct(other), .000000001);
    }

    @Test
    public void testAngleBetween() throws Exception {
        assertEquals(19.75142572761003, original.angleBetween(other), .000000001);
    }

    @Test   (expected = IllegalStateException.class)
    public void setOriginalFailAngle() throws Exception {
        zeroVector.angleBetween(other);
    }
}


