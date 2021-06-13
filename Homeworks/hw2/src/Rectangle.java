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

}
