package ass6.baitap.point2dVaPoint3D;

public class Point3D extends Point2D {
    private float z = 0.0f;
    public Point3D(){

    }
    public Point3D(float x, float y, float z){
        super(x, y);
        this.z = z;

    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public float[] getXYZ (){
        float xyz[] = {x,y,z};
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
