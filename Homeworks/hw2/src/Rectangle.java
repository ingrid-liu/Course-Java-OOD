import java.util.NoSuchElementException;

/*
  The Rectangle program creates a class called Rectangle, which
  returns a Rectangle object that defined by its coordinates(x,y) and
  width & height (w,h). *
  @author  'Ingrid' Xiaoying Liu
 * @version 1.0
 * @since   2021-06-01
 */

/**
 * Class of Rectangle.
 */
public class Rectangle {
    /**
     * Int x is the coordinate x value of the left-lower node
     * of the rectangle object.
     */
    private int x;
    /**
     * Int y is the coordinate y value of the left-lower node
     * of the rectangle object.
     */
    private int y;
    /**
     * Int w is the width of the rectangle object.
     */
    private int w;
    /**
     * Int w is the height of the rectangle object.
     */
    private int h;

    /**
     * Constructor of the rectangle.
     * @param x vertical coordinate
     * @param y vertical coordinate
     * @param w width of the rectangle
     * @param h height of the rectangle
     */
    public Rectangle(int x, int y, int w, int h) {
        if (w < 0 || h < 0) {
            throw new IllegalArgumentException(
                    "The width or height can't be negative");
        }
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    /**
     * Overlap check if two rectangles are overlapped with each other.
     * @param other Rectangle
     * @return true if overlapped, false otherwise
     */
    public Boolean overlap(Rectangle other) {
        boolean overlaps = true;
        if (this.x >= other.x && this.x >= (other.x + other.w)) {
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

    /**
     * intersect: calculate the intersect of two rectangles.
     * @param other Rectangle
     * @return the overlapped part as a new Rectangle
     */
    public Rectangle intersect(Rectangle other) {
        Rectangle intersectRec = new Rectangle(0, 0, 0, 0);
        boolean overlaps = this.overlap(other);
        if (!overlaps) {
            throw new NoSuchElementException(
                    "These two rectangles have no intersection.");
        } else {
            if (this.x > other.x) {
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

    /**
     * Union returns the smallest rectangle that contains both rectangles.
     * @param other Rectangle
     * @return a Rectangle: the union of this rectangle and other rectangle
     */
    public Rectangle union(Rectangle other) {
        Rectangle unionRec = new Rectangle(0, 0, 0, 0);
        unionRec.x = Math.min(this.x, other.x);
        unionRec.y = Math.min(this.y, other.y);
        int unionRecEndX = Math.max(this.x + this.w, other.x + other.w);
        int unionRecEndY = Math.max(this.y + this.h, other.y + other.h);

        unionRec.w = unionRecEndX - unionRec.x;
        unionRec.h = unionRecEndY - unionRec.y;
        return unionRec;
    }
    /**
     * The toString method of the class.
     * @return string (expression of the Rectangle object)
     */
    public String toString() {
        return "x:" + this.x + ", y:"
                + this.y + ", w:" + this.w + ", h:" + this.h;
    }
    /**
     * The getter for argument x.
     * @return x
     */
    public int getX() {
        return x;
    }
    /**
     * The setter for argument x.
     * @param x the coordinate value of x
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * The getter for argument y.
     * @return y
     */
    public int getY() {
        return y;
    }
    /**
     * The setter for argument y.
     * @param y the coordinate value of y
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * The getter for argument w.
     * @return w
     */
    public int getW() {
        return w;
    }

    /**
     * The setter for argument w.
     * @param w the width of the rectangle
     */
    public void setW(int w) {
        this.w = w;
    }
    /**
     * The getter for argument h.
     * @return h
     */
    public int getH() {
        return h;
    }
    /**
     * The setter for argument h.
     * @param h the height of the rectangle
     */
    public void setH(int h) {
        this.h = h;
    }

}
