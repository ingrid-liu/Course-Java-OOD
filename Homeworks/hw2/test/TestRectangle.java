import jdk.swing.interop.SwingInterOpUtils;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * @author: 'Ingrid' Xiaoying Liu
 * Junit test for class Rectangle
 */
public class TestRectangle {
    private Rectangle rectangleOriginal;
    private Rectangle rectangleN;
    private Rectangle rectangleS;
    private Rectangle rectangleE;
    private Rectangle rectangleW;
    private Rectangle rectangleNE;
    private Rectangle rectangleNW;
    private Rectangle rectangleSE;
    private Rectangle rectangleSW;

    private Rectangle parallelPassThrough;
    private Rectangle verticalPassThrough;
    private Rectangle almostCover1;
    private Rectangle almostCover2;

    private Rectangle unOverlappedN;
    private Rectangle unOverlappedS;
    private Rectangle unOverlappedW;
    private Rectangle unOverlappedE;
    private Rectangle unOverlappedNW;
    private Rectangle unOverlappedNE;
    private Rectangle unOverlappedSW;
    private Rectangle unOverlappedSE;

    private Rectangle touch1edge;
    private Rectangle touch2edge;
    private Rectangle touch3edge;

    private Rectangle touchNodeNE;
    private Rectangle touchNodeNW;
    private Rectangle touchNodeSE;
    private Rectangle touchNodeSW;

    private Rectangle innerRectangle;
    private Rectangle outerRectangle;



    /**
     * myTestSetUp()
     * :rectangleOriginal: original rectangle across both positive and negative coordinates
     * :rectangle_ N, S, W, E, NW, NE, SE, SW: partially overlapped with the rectangleOriginal
     */
    @Before
    public void myTestSetUp() throws Exception {
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
//
        innerRectangle = new Rectangle(-1,-1,2,2);
        outerRectangle = new Rectangle(-4,-4,10,10);

    }

    /**
     * testNEWSOverlap: test overlapped rectangles with the rectangleOriginal from N, S, E, W directions
     */
    @Test
    public void testNEWSOverlap() throws Exception {
        assertTrue(rectangleOriginal.overlap(rectangleN));
        assertTrue(rectangleOriginal.overlap(rectangleS));
        assertTrue(rectangleOriginal.overlap(rectangleE));
        assertTrue(rectangleOriginal.overlap(rectangleW));
    }

    /**
     * test the partially overlapped rectangles from four corner directions
     */
    @Test
    public void testCornerOverlap() throws Exception {
        assertTrue(rectangleOriginal.overlap(rectangleNW));
        assertTrue(rectangleOriginal.overlap(rectangleNE));
        assertTrue(rectangleOriginal.overlap(rectangleSE));
        assertTrue(rectangleOriginal.overlap(rectangleSW));
    }

    /**
     * test the intersection results of the above overlapped cases (N/S/E/W + four corners)
     * test on getter/setter at the same time
     */
    @Test
    public void testPartiallyOverlappedIntersect() throws Exception {
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
     * test several other partially overlapped cases, i.e. pass through the original rectangle
    or almost contained the original rectangle
     */
    @Test
    public void testOtherPartiallyOverlapAndIntersect() throws Exception {
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
     * test rectangles from all directions without overlapping with the original rectangle
     */
    @Test
    public void testUnOverlapped() throws Exception {
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
     * test union result on above all cases
     * test on toString at the same time
     */
    @Test
    public void testUnion() throws Exception {
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
     * test rectangles touched 1/2/3 edge(s) of the original rectangle
     */
    @Test
    public void testTouched() throws Exception {
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

    @Test (expected = Exception.class)
    public void testTouchedException() throws Exception {
        rectangleOriginal.intersect(touch1edge);
    }

    /**
     * test completely duplicated rectangles
     */
    @Test
    public void testCompletelyOverlap() throws Exception {
        Rectangle sameWithOriginal = new Rectangle(-2,-2,4,4);
        Rectangle expectedResult = new Rectangle(-2, -2, 4, 4);

        assertTrue(rectangleOriginal.overlap(sameWithOriginal));

        assertEquals("x:-2, y:-2, w:4, h:4", rectangleOriginal.union(sameWithOriginal).toString());
        assertEquals(expectedResult.getX(), rectangleOriginal.getX());
        assertEquals(expectedResult.getY(), rectangleOriginal.getY());
        assertEquals(expectedResult.getW(), sameWithOriginal.getW());
        assertEquals(expectedResult.getH(), sameWithOriginal.getH());
    }

    /**
     * test rectangles touched 4 corner-edges of the original rectangle + throws Exception
     */
    @Test
    public void testTouchedCornerNode() throws Exception {
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
     * test rectangles contain and be contained by the original rectangle
     */
    @Test
    public void testInNOut() throws Exception {
        assertTrue(rectangleOriginal.overlap(innerRectangle));
        assertEquals(innerRectangle.toString(), rectangleOriginal.intersect(innerRectangle).toString());
        assertEquals(rectangleOriginal.toString(), rectangleOriginal.union(innerRectangle).toString());

        assertTrue(rectangleOriginal.overlap(outerRectangle));
        assertEquals(rectangleOriginal.toString(), rectangleOriginal.intersect(outerRectangle).toString());
        assertEquals(outerRectangle.toString(), rectangleOriginal.union(outerRectangle).toString());
    }


// Already tested Setter/Getter & toString in above tests for your information:)


}
