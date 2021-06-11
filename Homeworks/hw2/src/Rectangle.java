import java.util.NoSuchElementException;

public class Rectangle {
    //todo change the datatype into int
    private int x;       // horizontal
    private int y;       // vertical
    private int w;       // width
    private int h;       // height

    public Rectangle(int x, int y, int w, int h) {
        if (w < 0 || h < 0) {
            throw new IllegalArgumentException("The width or height can't be negative");
        }
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public Boolean overlap(Rectangle other) {
        boolean overlaps = true;
        if (this.x >= other.x && this.x >= (other.x+other.w)) {
            overlaps = false;
        }
        else if (this.x <= other.x && (this.x + this.w) <= other.x) {
            overlaps = false;
        }
        else if (this.y <= other.y && (this.y + this.h) <= other.y) {
            overlaps = false;
        }
        else if (this.y >= other.y && this.y >= (other.y + other.h)) {
            overlaps = false;
        }
        return overlaps;
    }

    public Rectangle intersect(Rectangle other) {
        Rectangle intersectRec = new Rectangle(0,0,0,0);
        boolean overlaps = this.overlap(other);
        if (!overlaps) {
            throw new NoSuchElementException("These two rectangles have no intersection.");
        } else {
            if (this.x > other.x){
                intersectRec.x = this.x;
                intersectRec.w = other.x + other.w - this.x;
                if (this.x + this.w <= other.x + other.w) {
                    intersectRec.w = this.w;
                }
            } else {
                intersectRec.x = other.x;
                intersectRec.w = this.x + this.w - other.x;
                if (this.x + this.w >= other.x + other.w) {
                    intersectRec.w = other.w;
                }
            }

            if (this.y > other.y) {
                intersectRec.y = this.y;
                intersectRec.h = other.y + other.h - this.y;
                if (this.y + this.h <= other.y + other.h) {
                    intersectRec.h = this.h;
                }
            } else {
                intersectRec.y = other.y;
                intersectRec.h = this.y + this.h - other.y;
                if (this.y + this.h >= other.y + other.h) {
                    intersectRec.h = other.h;
                }
            }
        }

        return intersectRec;
    }

    public Rectangle union(Rectangle other) {
        Rectangle unionRec = new Rectangle(0,0,0,0);
//        unionRec.x = this.x < other.x ? this.x : other.x;
//        unionRec.y = this.y < other.y ? this.y : other.y;
//        double unionRecEndX = this.x + this.w > other.x + other.w ? this.x + this.w :other.x + other.w;
//        double unionRecEndY = this.y + this.h > other.y + other.h ? this.y + this.h : other.y + other.h;

        unionRec.x = Math.min(this.x, other.x);
        unionRec.y = Math.min(this.y, other.y);
        int unionRecEndX = Math.max(this.x + this.w, other.x + other.w);
        int unionRecEndY = Math.max(this.y + this.h, other.y + other.h);

        unionRec.w = unionRecEndX - unionRec.x;
        unionRec.h = unionRecEndY - unionRec.y;
        return unionRec;
    }
    // todo check if I can set setter/getter as public method??
    public String toString() {
        return "x:" + this.x +
                ", y:" + this.y + ", w:" + this.w + ", h:" + this.h;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }






    public static void main(String[] args) {
//        double x1 = 3;  double y1 = 3;  double w1 = 3;  double h1 = 3;
//        double x2 = 2;  double y2 = 5;  double w2 = 2;  double h2 = 2;
//        double x3 = 5;  double y3 = 5;  double w3 = 2;  double h3 = 2;
//        double x4 = 5;  double y4 = 2;  double w4 = 2;  double h4 = 2;
//        double x5 = 2;  double y5 = 2;  double w5 = 2;  double h5 = 2;
//        double x6 = 2;  double y6 = 2;  double w6 = 5;  double h6 = 5;
//        double x7 = 4;  double y7 = 4;  double w7 = 1;  double h7 = 1;
//        double x8 = 6;  double y8 = 6;  double w8 = 3;  double h8 = 3;
//
//        double x9 = 2;  double y9 = 4;  double w9 = 2;  double h9 = 1;
//        double x0 = 2;  double y0 = 2;  double w0 = 2;  double h0 = 5;
//        double xi = 2;  double yi = 3;  double wi = 1;  double hi = 3;

        // test negative
//        double xii = -1;  double yii = -2;  double wii = 7;  double hii = 6;
//        double xiii = 0;  double yiii = 0;  double wiii = 3;  double hiii = 2;
//        double xiv = -2; double yiv = -2; double wiv = 2; double hiv = 3;



//        Rectangle r1 = new Rectangle(x1, y1, w1, h1);       // ← this       ↓ other
//        Rectangle r2 = new Rectangle(x2, y2, w2, h2);       // overlap1 other: upper-left
//        Rectangle r3 = new Rectangle(x3, y3, w3, h3);       // overlap1 other: upper-right
//        Rectangle r4 = new Rectangle(x4, y4, w4, h4);       // overlap1 other: lower-right
//        Rectangle r5 = new Rectangle(x5, y5, w5, h5);       // overlap1 other: lower-left
//        Rectangle r6 = new Rectangle(x6, y6, w6, h6);       // fully contains       expected:(3,3,3,3)
//        Rectangle r7 = new Rectangle(x7, y7, w7, h7);       // fully contained      expected:(4,4,1,1)
//        Rectangle r8 = new Rectangle(x8, y8, w8, h8);       // no overlap or intersection
//
//        // three more corner cases
//        Rectangle r9 = new Rectangle(x9, y9, w9, h9);        // partially contains  expected:(3,4,1,1)
//        Rectangle r0 = new Rectangle(x0, y0, w0, h0);        // partially contains  expected:(3,3,1,3)
//        Rectangle ri = new Rectangle(xi, yi, wi, hi);        // partially contains  expected: No overlap

        // test negative coordinates
//        Rectangle rii = new Rectangle(xii, yii, wii, hii);
//        Rectangle riii = new Rectangle(xiii, yiii, wiii, hiii);
//        Rectangle riv = new Rectangle(xiv, yiv, wiv, hiv);

//        System.out.println("-------------------Test toString:");
//        System.out.println("Rectangle1:\n" + r1);
//        System.out.println("Rectangle2:\n" + r2);
//        System.out.println("Rectangle3:\n" + r3);
//        System.out.println("Rectangle4:\n" + r4);
//        System.out.println("Rectangle5:\n" + r5);

//        System.out.println("Rectangle8\n" + r8);
        System.out.println("\n-------------------Test overlapped:");
        Rectangle rectangle1 = new Rectangle(-2,-2,4,4);
        Rectangle rectangleNW = new Rectangle(-3,1,2,2);
        System.out.println(rectangle1.overlap(rectangleNW));
//        System.out.println(r1.overlap(r2));
//        System.out.println(r1.overlap(r3));
//        System.out.println(r1.overlap(r4));
//        System.out.println(r1.overlap(r5));
//        System.out.println(r1.overlap(r6));
//        System.out.println(r1.overlap(r7));
//        System.out.println(r1.overlap(r8));
//        System.out.println(r1.overlap(r9));
//        System.out.println(r1.overlap(r0));
//        System.out.println(r1.overlap(ri));
//        System.out.println(rii.overlap(riii));

        System.out.println("\n-------------------Test intersect:");
//        System.out.println(r1.intersect(r2));
//        System.out.println(r1.intersect(r3));
//        System.out.println(r1.intersect(r4));
//        System.out.println(r1.intersect(r5));
//        System.out.println(r1.intersect(r6) + "  --- expected:(3,3,3,3)");
//        System.out.println(r1.intersect(r7) + "  --- expected:(4,4,1,1)");
//        // System.out.println(r1.intersect(r8));
//
//        System.out.println(r1.intersect(r9) + "  --- expected:(3,4,1,1)");
//        System.out.println(r1.intersect(r0) + "  --- expected:(3,3,1,3)");
//        //System.out.println(r1.intersect(ri));
//        System.out.println(rii.intersect(riii) + "  --- expected:(0,0,3,2)");
//        System.out.println(rii.intersect(riv) + "  --- expected:(-1,-2,1,3)");

        System.out.println("\n-------------------Test union:");
//        System.out.println(r1.union(r2)+ "  --- expected:(2,3,4,4)");
//        System.out.println(r1.union(r3)+ "  --- expected:(3,3,4,4)");
//        System.out.println(r1.union(r4)+ "  --- expected:(3,2,4,4)");
//        System.out.println(r1.union(r5)+ "  --- expected:(2,2,4,4)");
//        System.out.println(r1.union(r6)+ "  --- expected:(2,2,5,5)");
//        System.out.println(r1.union(r7)+ "  --- expected:(3,3,3,3)");
//        System.out.println(rii.union(riii)+ "  --- expected:(-1,-2,7,6)");
//        System.out.println(rii.union(riv)+ "  --- expected:(-2,-2,8,6)");
    }

}
