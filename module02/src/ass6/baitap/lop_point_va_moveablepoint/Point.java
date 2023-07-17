package ass6.baitap.lop_point_va_moveablepoint;

public class Point {
    public float x ;
    public float y ;
    public Point(){};
    Point(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float getX(){
        return x;
    }
    public void setX(float x){
        this.x = x;
    }
    public float getY(){
        return y;
    }
    public void setY(float y){
        this.y = y;
    }
    public void setXY(float x , float y){
        this.x = x;
        this.y = y;
    }
    public float[] getXY(){
        float[] xy = {x,y};
        return xy;
    }
    public String toString() {
        return "Point{" +
                "X = " + x +
                "Y = " + y +
                "}";

    }
}
