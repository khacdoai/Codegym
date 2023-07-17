package ass6.baitap.lop_point_va_moveablepoint;

public class MoveablePoint  extends Point {
    public float xSpeed ;
    public float ySpeed;

    public MoveablePoint(){};
    public MoveablePoint(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MoveablePoint(float x, float y, float xSpeed, float ySpeed){
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float getXSpeed(){
        return xSpeed;
    }
    public void setXSpeed(float xSpeed){
        this.xSpeed = xSpeed;
    }
    public float getYSpeed(){
        return ySpeed;
    }
    public void setYSpeed(float ySpeed){
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed(){
        float[] speed = {xSpeed, ySpeed};
        return speed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

}

