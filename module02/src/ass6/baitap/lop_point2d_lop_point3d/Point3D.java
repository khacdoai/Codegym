package ass6.baitap.lop_point2d_lop_point3d;

import ass6.baitap.lop_point2d_lop_point3d.Point2D;

public class Point3D extends Point2D {
    public float z;

    public Point3D(float x , float y , float z){
        super(x, y);
        this.z = z;
    }
    public float getZ(){
        return z;
    }
    public void setZ(float z){
        this.z = z;
    }
    public void setXYZ(float x, float y , float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public float[] getXYZ(){
        float xyz[] = {x, y, z};
        return xyz;
    }

    public String toString(){
        return "Point3D{" +
                "X = " + x +
                ", Y = " + y +
                ", Z = " + z +
                "}";
    }

}
