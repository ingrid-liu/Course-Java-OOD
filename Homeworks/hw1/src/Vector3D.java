// Name: Xiaoying Liu
// Email: liu.xiaoying@northeastern.edu

import java.lang.Math;

public class Vector3D {

    private double x;
    private double y;
    private double z;

    public Vector3D() {
    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String toString(){
        return (String.format("(%.2f, %.2f, %.2f)", this.x, this.y, this.z));
    }

    public double getMagnitude(){
        return Math.sqrt(this.x* this.x + this.y* this.y + this.z* this.z);
    }

    public Vector3D normalize(){
        if(this.getMagnitude()==0){
            throw new IllegalStateException("can't divide zero");
        }
        return new Vector3D(this.x / this.getMagnitude(),
                this.y / this.getMagnitude(),
                this.z / this.getMagnitude());
    }

    public Vector3D add(Vector3D other){
        return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector3D multiply(double constantNum){
        return new Vector3D(this.x*constantNum, this.y*constantNum, this.z*constantNum);
    }

    public Double dotProduct(Vector3D other){
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public double angleBetween(Vector3D other){
        if(this.getMagnitude()==0){
            throw new IllegalStateException("can't divide zero");
        }else if(other.getMagnitude()==0){
            throw new IllegalStateException("can't divide zero");
        }
        double cos = this.dotProduct(other) / (this.getMagnitude() * other.getMagnitude());
        double acos = Math.acos(cos);
        return Math.toDegrees(acos);
    }

    public static void main(String[] args){
        System.out.println("Test main function runs.");
        Vector3D original = new Vector3D(2.3, 3.5, 4.4);
        System.out.println(original.x);
        System.out.println(original.getX());

        Vector3D test = new Vector3D();
        System.out.println(test);
    }
}


