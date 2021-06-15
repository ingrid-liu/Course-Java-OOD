import jdk.swing.interop.SwingInterOpUtils;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/*
 * Junit test for class Rectangle.
 * @author  'Ingrid' Xiaoying Liu
 * @version 1.0
 * @since   2021-06-01
 */

/**
 * Test Rectangle Class
 */
public class TestRectangle {
    /**
     * Create a Rectangle object named rectangleOriginal
     */
    private Rectangle rectangleOriginal;
    /**
     * Create a Rectangle object named rectangleN
     */
    private Rectangle rectangleN;
    /**
     * Create a Rectangle object named rectangleS
     */
    private Rectangle rectangleS;
    /**
     * Create a Rectangle object named rectangleE
     */
    private Rectangle rectangleE;
    /**
     * Create a Rectangle object named rectangleW
     */
    private Rectangle rectangleW;
    /**
     * Create a Rectangle object named rectangleNE
     */
    private Rectangle rectangleNE;
    /**
     * Create a Rectangle object named rectangleNW
     */
    private Rectangle rectangleNW;
    /**
     * Create a Rectangle object named rectangleSE
     */
    private Rectangle rectangleSE;
    /**
     * Create a Rectangle object named rectangleSW
     */
    private Rectangle rectangleSW;

    /**
     * Create a Rectangle object named parallelPassThrough
     */
    private Rectangle parallelPassThrough;
    /**
     * Create a Rectangle object named verticalPassThrough
     */
    private Rectangle verticalPassThrough;
    /**
     * Create a Rectangle object named almostCover1
     */
    private Rectangle almostCover1;
    /**
     * Create a Rectangle object named almostCover2
     */
    private Rectangle almostCover2;

    /**
     * Create a Rectangle object named unOverlappedN
     */
    private Rectangle unOverlappedN;
    /**
     * Create a Rectangle object named unOverlappedS
     */
    private Rectangle unOverlappedS;
    /**
     * Create a Rectangle object named unOverlappedW
     */
    private Rectangle unOverlappedW;
    /**
     * Create a Rectangle object named unOverlappedE
     */
    private Rectangle unOverlappedE;
    /**
     * Create a Rectangle object named unOverlappedNW
     */
    private Rectangle unOverlappedNW;
    /**
     * Create a Rectangle object named unOverlappedNE
     */
    private Rectangle unOverlappedNE;
    /**
     * Create a Rectangle object named unOverlappedSW
     */
    private Rectangle unOverlappedSW;
    /**
     * Create a Rectangle object named unOverlappedSE
     */
    private Rectangle unOverlappedSE;


    /**
     * Create a Rectangle object named touch1edge
     */
    private Rectangle touch1edge;
    /**
     * Create a Rectangle object named touch2edge
     */
    private Rectangle touch2edge;
    /**
     * Create a Rectangle object named touch3edge
     */
    private Rectangle touch3edge;

    /**
     * Create a Rectangle object named touchNodeNE
     */
    private Rectangle touchNodeNE;
    /**
     * Create a Rectangle object named touchNodeNW
     */
    private Rectangle touchNodeNW;
    /**
     * Create a Rectangle object named touchNodeSE
     */
    private Rectangle touchNodeSE;
    /**
     * Create a Rectangle object named touchNodeSW
     */
    private Rectangle touchNodeSW;

    /**
     * Create a Rectangle object named outerRectangle
     */
    private Rectangle innerRectangle;
    /**
     * Create a Rectangle object named outerRectangle
     */
    private Rectangle outerRectangle;

    /**
     * The myTestSetUp() is setting up the value of the rectangles I create.
     * :rectangleOriginal: original rectangle across both positive and negative coordinates
     * :rectangle_ N, S, W, E, NW, NE, SE, SW: partially overlapped with the rectangleOriginal
     */
    @Before
    public void myTestSetUp() {
        rectangleOriginal = new Rectangle(-2,-2,4,4);
        rectangleN = new Rectangle(0,1,1,2);
        rectangleS = new Rectangle(-1,-3,1,2);
        rectangleW = new Rectangle(-6,1,5,1);
        rectangleE = new Rectangle(1,-1,7,2);
        rectangleNW = new Rectangle(-3,1,2,2);
        rectangleNE = new Rectangle(1,1,5,4);
        rectangleSE = new Rectangle(1,-3, 2,2);
        rectangleSW = new Rectangle(-4,-5,3,4);

        parallelPassThrough = new Rectangle(-5, -1, 10,2);
        verticalPassThrough = new Rectangle(-1, -5, 2,10);
        almostCover1 = new Rectangle(-1,-3,10,10);
        almostCover2 = new Rectangle(-5,-1,10,10);

        unOverlappedN = new Rectangle(-2, -4, 1,1);
        unOverlappedS = new Rectangle(0, 4, 2,1);
        unOverlappedW = new Rectangle(-4, -1, 1,4);
        unOverlappedE = new Rectangle(3, -2, 2,10);
        unOverlappedNW = new Rectangle(-8, -8, 2,2);
        unOverlappedNE = new Rectangle(8, 8, 2,2);
        unOverlappedSW = new Rectangle(-8, -8, 2,2);
        unOverlappedSE = new Rectangle(8, -8, 2,2);

        touch1edge = new Rectangle(-4,-2,2,4);
        touch2edge = new Rectangle(-4,-5,6,8);
        touch3edge = new Rectangle(-2,-2,6,6);


        touchNodeNE = new Rectangle(2,2,2,2);
        touchNodeNW = new Rectangle(-4,2,2,2);

        touchNodeSE = new Rectangle(2,-4,2,2);
        touchNodeSW = new Rectangle(-4,-4,2,2);

        innerRectangle = new Rectangle(-1,-1,2,2);
        outerRectangle = new Rectangle(-4,-4,10,10);
    }

    /**
     * The ExpectedException allows to verify the code throws a
     * specific exception.
     */
    @Rule
    public ExpectedException thrown= ExpectedException.none();

    /**
     * The testNEWSOverlap is testing the overlapped rectangles
     * with the rectangleOriginal from N, S, E, W directions.
     */
    @Test
    public void testNEWSOverlap() {
        assertTrue(rectangleOriginal.overlap(rectangleN));
        assertTrue(rectangleOriginal.overlap(rectangleS));
        assertTrue(rectangleOriginal.overlap(rectangleE));
        assertTrue(rectangleOriginal.overlap(rectangleW));
    }

    /**
     * The testCornerOverlap is testing the partially overlapped
     * rectangles from four corner directions.
     */
    @Test
    public void testCornerOverlap() {
        assertTrue(rectangleOriginal.overlap(rectangleNW));
        assertTrue(rectangleOriginal.overlap(rectangleNE));
        assertTrue(rectangleOriginal.overlap(rectangleSE));
        assertTrue(rectangleOriginal.overlap(rectangleSW));
    }

    /**
     * The testPartiallyOverlappedIntersect is testing the intersection
     * results of the above overlapped cases (N/S/E/W + four corners).
     * also tested on getter/setter at the same time
     */
    @Test
    public void testPartiallyOverlappedIntersect() {
        Rectangle expectedResultN = new Rectangle(0,1,1,1);
        Rectangle IntersectN = rectangleOriginal.intersect(rectangleN);
        assertEquals(expectedResultN.getX(), IntersectN.getX());
        assertEquals(expectedResultN.getY(), IntersectN.getY());
        assertEquals(expectedResultN.getW(), IntersectN.getW());
        assertEquals(expectedResultN.getH(), IntersectN.getH());

        Rectangle expectedResultS = new Rectangle(-1,-2,1,1);
        Rectangle IntersectS = rectangleOriginal.intersect(rectangleS);
        assertEquals(expectedResultS.getX(), IntersectS.getX());
        assertEquals(expectedResultS.getY(), IntersectS.getY());
        assertEquals(expectedResultS.getW(), IntersectS.getW());
        assertEquals(expectedResultS.getH(), IntersectS.getH());

        Rectangle expectedResultW = new Rectangle(-2,1,1,1);
        Rectangle IntersectW = rectangleOriginal.intersect(rectangleW);
        assertEquals(expectedResultW.getX(), IntersectW.getX());
        assertEquals(expectedResultW.getY(), IntersectW.getY());
        assertEquals(expectedResultW.getW(), IntersectW.getW());
        assertEquals(expectedResultW.getH(), IntersectW.getH());
        System.out.println();

        Rectangle expectedResultE = new Rectangle(1,-1,1,2);
        Rectangle IntersectE = rectangleOriginal.intersect(rectangleE);
        assertEquals(expectedResultE.getX(), IntersectE.getX());
        assertEquals(expectedResultE.getY(), IntersectE.getY());
        assertEquals(expectedResultE.getW(), IntersectE.getW());
        assertEquals(expectedResultE.getH(), IntersectE.getH());

        Rectangle expectedResultNW = new Rectangle(-2,1,1,1);
        Rectangle IntersectNW = rectangleOriginal.intersect(rectangleNW);
        assertEquals(expectedResultNW.getX(), IntersectNW.getX());
        assertEquals(expectedResultNW.getY(), IntersectNW.getY());
        assertEquals(expectedResultNW.getW(), IntersectNW.getW());
        assertEquals(expectedResultNW.getH(), IntersectNW.getH());

        Rectangle expectedResultNE = new Rectangle(1,1,1,1);
        Rectangle IntersectNE = rectangleOriginal.intersect(rectangleNE);
        assertEquals(expectedResultNE.getX(), IntersectNE.getX());
        assertEquals(expectedResultNE.getY(), IntersectNE.getY());
        assertEquals(expectedResultNE.getW(), IntersectNE.getW());
        assertEquals(expectedResultNE.getH(), IntersectNE.getH());

        Rectangle expectedResultSE = new Rectangle(1,-2,1,1);
        Rectangle IntersectSE = rectangleOriginal.intersect(rectangleSE);
        assertEquals(expectedResultSE.getX(), IntersectSE.getX());
        assertEquals(expectedResultSE.getY(), IntersectSE.getY());
        assertEquals(expectedResultSE.getW(), IntersectSE.getW());
        assertEquals(expectedResultSE.getH(), IntersectSE.getH());

        Rectangle expectedResultSW = new Rectangle(-2,-2,1,1);
        Rectangle IntersectSW = rectangleOriginal.intersect(rectangleSW);
        assertEquals(expectedResultSW.getX(), IntersectSW.getX());
        assertEquals(expectedResultSW.getY(), IntersectSW.getY());
        assertEquals(expectedResultSW.getW(), IntersectSW.getW());
        assertEquals(expectedResultSW.getH(), IntersectSW.getH());
    }

    /**
     * The testOtherPartiallyOverlapAndIntersect is testing several other
     * partially overlapped cases, i.e. pass through the original rectangle
     * or almost contained the original rectangle.
     */
    @Test
    public void testOtherPartiallyOverlapAndIntersect() {
        assertTrue(rectangleOriginal.overlap(parallelPassThrough));
        assertTrue(rectangleOriginal.overlap(verticalPassThrough));
        assertTrue(rectangleOriginal.overlap(almostCover1));
        assertTrue(rectangleOriginal.overlap(almostCover2));

        Rectangle expectedResultParallel = new Rectangle(-2,-1,4,2);
        Rectangle IntersectParallel = rectangleOriginal.intersect(parallelPassThrough);
        assertEquals(expectedResultParallel.getX(), IntersectParallel.getX());
        assertEquals(expectedResultParallel.getY(), IntersectParallel.getY());
        assertEquals(expectedResultParallel.getW(), IntersectParallel.getW());
        assertEquals(expectedResultParallel.getH(), IntersectParallel.getH());

        Rectangle expectedResultVertical = new Rectangle(-1,-2,2,4);
        Rectangle IntersectVertical = rectangleOriginal.intersect(verticalPassThrough);
        assertEquals(expectedResultVertical.getX(), IntersectVertical.getX());
        assertEquals(expectedResultVertical.getY(), IntersectVertical.getY());
        assertEquals(expectedResultVertical.getW(), IntersectVertical.getW());
        assertEquals(expectedResultVertical.getH(), IntersectVertical.getH());

        Rectangle expectedResultAlmostCover1 = new Rectangle(-1,-2,3,4);
        Rectangle IntersectAlmost1 = rectangleOriginal.intersect(almostCover1);
        assertEquals(expectedResultAlmostCover1.getX(), IntersectAlmost1.getX());
        assertEquals(expectedResultAlmostCover1.getY(), IntersectAlmost1.getY());
        assertEquals(expectedResultAlmostCover1.getW(), IntersectAlmost1.getW());
        assertEquals(expectedResultAlmostCover1.getH(), IntersectAlmost1.getH());

        Rectangle expectedResultAlmostCover2 = new Rectangle(-2,-1,4,3);
        Rectangle IntersectAlmost2 = rectangleOriginal.intersect(almostCover2);
        assertEquals(expectedResultAlmostCover2.getX(), IntersectAlmost2.getX());
        assertEquals(expectedResultAlmostCover2.getY(), IntersectAlmost2.getY());
        assertEquals(expectedResultAlmostCover2.getW(), IntersectAlmost2.getW());
        assertEquals(expectedResultAlmostCover2.getH(), IntersectAlmost2.getH());
    }

    /**
     * The testUnOverlapped is testing rectangles from all directions
     * without overlapping with the original rectangle.
     */
    @Test
    public void testUnOverlapped() {
        assertFalse(rectangleOriginal.overlap(unOverlappedN));
        assertFalse(rectangleOriginal.overlap(unOverlappedS));
        assertFalse(rectangleOriginal.overlap(unOverlappedW));
        assertFalse(rectangleOriginal.overlap(unOverlappedE));
        assertFalse(rectangleOriginal.overlap(unOverlappedNW));
        assertFalse(rectangleOriginal.overlap(unOverlappedNE));
        assertFalse(rectangleOriginal.overlap(unOverlappedSW));
        assertFalse(rectangleOriginal.overlap(unOverlappedSE));
    }

    /**
     * The testUnion is testing union result on above all cases.
     * test on toString at the same time
     */
    @Test
    public void testUnion() {
        Rectangle expectedResultN = new Rectangle(-2,-2,4,5);
        Rectangle expectedResultS = new Rectangle(-2,-3,4,5);
        Rectangle expectedResultE = new Rectangle(-2,-2,10,4);
        Rectangle expectedResultW = new Rectangle(-6,-2,8,4);

        assertEquals(expectedResultN.toString(), rectangleOriginal.union(rectangleN).toString());
        assertEquals(expectedResultS.toString(), rectangleOriginal.union(rectangleS).toString());
        assertEquals(expectedResultE.toString(), rectangleOriginal.union(rectangleE).toString());
        assertEquals(expectedResultW.toString(), rectangleOriginal.union(rectangleW).toString());

        assertEquals("x:-2, y:-2, w:8, h:7", rectangleOriginal.union(rectangleNE).toString());
        assertEquals("x:-3, y:-2, w:5, h:5", rectangleOriginal.union(rectangleNW).toString());
        assertEquals("x:-2, y:-3, w:5, h:5", rectangleOriginal.union(rectangleSE).toString());
        assertEquals("x:-4, y:-5, w:6, h:7", rectangleOriginal.union(rectangleSW).toString());

        assertEquals("x:-5, y:-2, w:10, h:4", rectangleOriginal.union(parallelPassThrough).toString());
        assertEquals("x:-2, y:-5, w:4, h:10", rectangleOriginal.union(verticalPassThrough).toString());
        assertEquals("x:-2, y:-3, w:11, h:10", rectangleOriginal.union(almostCover1).toString());
        assertEquals("x:-5, y:-2, w:10, h:11", rectangleOriginal.union(almostCover2).toString());

        assertEquals("x:-2, y:-4, w:4, h:6", rectangleOriginal.union(unOverlappedN).toString());
        assertEquals("x:-2, y:-2, w:4, h:7", rectangleOriginal.union(unOverlappedS).toString());
        assertEquals("x:-2, y:-2, w:7, h:10", rectangleOriginal.union(unOverlappedE).toString());
        assertEquals("x:-4, y:-2, w:6, h:5", rectangleOriginal.union(unOverlappedW).toString());

        assertEquals("x:-2, y:-2, w:12, h:12", rectangleOriginal.union(unOverlappedNE).toString());
        assertEquals("x:-8, y:-8, w:10, h:10", rectangleOriginal.union(unOverlappedNW).toString());
        assertEquals("x:-2, y:-8, w:12, h:10", rectangleOriginal.union(unOverlappedSE).toString());
        assertEquals("x:-8, y:-8, w:10, h:10", rectangleOriginal.union(unOverlappedSW).toString());

    }

    /**
     * The testTouched is testing rectangles touched 1/2/3 edge(s)
     * of the original rectangle.
     */
    @Test
    public void testTouched() {
        // 1 touched edge
        assertFalse(rectangleOriginal.overlap(touch1edge));
        assertEquals("x:-4, y:-2, w:6, h:4", rectangleOriginal.union(touch1edge).toString());

        // 2 touched edges
        assertTrue(rectangleOriginal.overlap(touch2edge));
        assertEquals("x:-2, y:-2, w:4, h:4", rectangleOriginal.intersect(touch2edge).toString());
        assertEquals("x:-4, y:-5, w:6, h:8", rectangleOriginal.union(touch2edge).toString());

        // 3 touched edges
        assertTrue(rectangleOriginal.overlap(touch3edge));
        assertEquals("x:-2, y:-2, w:4, h:4", rectangleOriginal.intersect(touch3edge).toString());
        assertEquals("x:-2, y:-2, w:6, h:6", rectangleOriginal.union(touch3edge).toString());
    }

    /**
     * The testTouchedException is testing on throwing an expected
     * exception by the intersect method.
     * @throws Exception NoSuchElementException
     */
    @Test (expected = Exception.class)
    public void testTouchedException() throws Exception {
        rectangleOriginal.intersect(touch1edge);
    }

    /**
     * The testCompletelyOverlap is testing on completely duplicated rectangles.
     */
    @Test
    public void testCompletelyOverlap() throws Exception {
        Rectangle sameWithOriginal = new Rectangle(-2,-2,4,4);
        Rectangle expectedResult = new Rectangle(-2, -2, 4, 4);

        assertTrue(rectangleOriginal.overlap(sameWithOriginal));

        assertEquals("x:-2, y:-2, w:4, h:4",
                rectangleOriginal.union(sameWithOriginal).toString());
        assertEquals(expectedResult.getX(), rectangleOriginal.getX());
        assertEquals(expectedResult.getY(), rectangleOriginal.getY());
        assertEquals(expectedResult.getW(), sameWithOriginal.getW());
        assertEquals(expectedResult.getH(), sameWithOriginal.getH());
    }

    /**
     * The testTouchedCornerNode is testing rectangles touched 4 corner-edges
     * of the original rectangle + throws Exception.
     */
    @Test
    public void testTouchedCornerNode() {
        assertFalse(rectangleOriginal.overlap(touchNodeNE));
        assertEquals("x:-2, y:-2, w:6, h:6", rectangleOriginal.union(touchNodeNE).toString());

        assertFalse(rectangleOriginal.overlap(touchNodeNW));
        assertEquals("x:-4, y:-2, w:6, h:6", rectangleOriginal.union(touchNodeNW).toString());

        assertFalse(rectangleOriginal.overlap(touchNodeSE));
        assertEquals("x:-2, y:-4, w:6, h:6", rectangleOriginal.union(touchNodeSE).toString());

        assertFalse(rectangleOriginal.overlap(touchNodeSW));
        assertEquals("x:-4, y:-4, w:6, h:6", rectangleOriginal.union(touchNodeSW).toString());
    }

    @Test (expected = Exception.class)
    public void testTouchedCornerNodeException() throws Exception {
        rectangleOriginal.intersect(touchNodeNE);
        rectangleOriginal.intersect(touchNodeNW);
        rectangleOriginal.intersect(touchNodeSE);
        rectangleOriginal.intersect(touchNodeSW);
    }

    /**
     * The testInNOut is testing on rectangles contain
     * and be contained by the original rectangle.
     */
    @Test
    public void testInNOut() {
        assertTrue(rectangleOriginal.overlap(innerRectangle));
        assertEquals(innerRectangle.toString(), rectangleOriginal.intersect(innerRectangle).toString());
        assertEquals(rectangleOriginal.toString(), rectangleOriginal.union(innerRectangle).toString());

        assertTrue(rectangleOriginal.overlap(outerRectangle));
        assertEquals(rectangleOriginal.toString(), rectangleOriginal.intersect(outerRectangle).toString());
        assertEquals(outerRectangle.toString(), rectangleOriginal.union(outerRectangle).toString());
    }


/*
 Already tested Setter/Getter & toString in above tests
 for your information:)
 */


}
