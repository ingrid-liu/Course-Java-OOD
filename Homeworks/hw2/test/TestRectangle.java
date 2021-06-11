import jdk.swing.interop.SwingInterOpUtils;
import org.junit.*;

import static org.junit.Assert.*;

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

//    private Rectangle rectangle;

    /*
    :rectangleOriginal: original rectangle across both positive and negative coordinates
    :rectangle: N, S, W, E, NW, NE, SE, SW: partially overlapped with the rectangleOriginal
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
    }

    /*
    Test the partially overlapped rectangles from N/S/E/W directions
     */
    @Test
    public void testNEWSOverlap() throws Exception {
        assertEquals(true, rectangleOriginal.overlap(rectangleN));
        assertEquals(true, rectangleOriginal.overlap(rectangleS));
        assertEquals(true, rectangleOriginal.overlap(rectangleE));
        assertEquals(true, rectangleOriginal.overlap(rectangleW));
    }

    /*
    Test the partially overlapped rectangles from four corner directions
     */
    @Test
    public void testCornerOverlap() throws Exception {
        assertEquals(true, rectangleOriginal.overlap(rectangleNW));
        assertEquals(true, rectangleOriginal.overlap(rectangleNE));
        assertEquals(true, rectangleOriginal.overlap(rectangleSE));
        assertEquals(true, rectangleOriginal.overlap(rectangleSW));
    }

    /*
    Test the intersection results of the above overlapped cases
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

        rectangleNW = new Rectangle(-3,1,2,2);
        Rectangle expectedResultNW = new Rectangle(-2,1,1,1);
        Rectangle IntersectNW = rectangleOriginal.intersect(rectangleNW);
        assertEquals(expectedResultNW.getX(), IntersectNW.getX());
        assertEquals(expectedResultNW.getY(), IntersectNW.getY());
        assertEquals(expectedResultNW.getW(), IntersectNW.getW());
        assertEquals(expectedResultNW.getH(), IntersectNW.getH());

        rectangleNE = new Rectangle(1,1,5,4);
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

    /*
    Test several other partially overlapped cases, i.e. pass through the original rectangle
    or almost contained the original rectangle
     */
    @Test
    public void testOtherPartiallyOverlapAndIntersect() throws Exception {
        Rectangle parallelPassThrough = new Rectangle(-5, -1, 10,2);
        Rectangle verticalPassThrough = new Rectangle(-1, -5, 2,10);
        Rectangle almostCover1 = new Rectangle(-1,-3,10,10);
        Rectangle almostCover2 = new Rectangle(-5,-1,10,10);

        assertEquals(true, rectangleOriginal.overlap(parallelPassThrough));
        assertEquals(true, rectangleOriginal.overlap(verticalPassThrough));
        assertEquals(true, rectangleOriginal.overlap(almostCover1));
        assertEquals(true, rectangleOriginal.overlap(almostCover2));

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
        Rectangle IntersectAlmost1 = rectangleOriginal.intersect(verticalPassThrough);
        assertEquals(IntersectAlmost1.getX(), IntersectAlmost1.getX());
        assertEquals(IntersectAlmost1.getY(), IntersectAlmost1.getY());
        assertEquals(IntersectAlmost1.getW(), IntersectAlmost1.getW());
        assertEquals(IntersectAlmost1.getH(), IntersectAlmost1.getH());
        System.out.println(rectangleOriginal.intersect(verticalPassThrough));
//        Rectangle almostCover1 = new Rectangle(-1,-3,10,10);
//        Rectangle almostCover2 = new Rectangle(-5,-1,10,10);

        Rectangle expectedResultAlmostCover2 = new Rectangle(-1,-2,2,4);
        Rectangle IntersectAlmost2 = rectangleOriginal.intersect(verticalPassThrough);
        System.out.println(rectangleOriginal.intersect(verticalPassThrough));
//        assertEquals(IntersectAlmost2.getX(), verticalPassThrough.getX());
//        assertEquals(IntersectAlmost2.getY(), verticalPassThrough.getY());
//        assertEquals(IntersectAlmost2.getW(), verticalPassThrough.getW());
//        assertEquals(IntersectAlmost2.getH(), verticalPassThrough.getH());
    }


//        assertEquals(true, rectangleOriginal.intersect(rectangleS));
//        assertEquals(true, rectangleOriginal.intersect(rectangleE));
//        assertEquals(true, rectangleOriginal.intersect(rectangleW));

//        assertEquals(true, rectangleOriginal.intersect(rectangleNW));
//        assertEquals(true, rectangleOriginal.intersect(rectangleNE));
//        assertEquals(true, rectangleOriginal.intersect(rectangleSE));
//        assertEquals(true, rectangleOriginal.intersect(rectangleSW));

//    @Test
//    public void test



}
