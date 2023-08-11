package ass6.baitap.lopPointVaMoveablepoint;

public class Moveablepoint extends Point{
    private float xSpeed = 0.0f ;
    private float ySpeed = 0.0f ;

    Moveablepoint(){}
    Moveablepoint(float xSpeed, float ySpeed){
        this.xSpeed =xSpeed;
        this.ySpeed =ySpeed;
    }
    Moveablepoint(float xSpeed, float ySpeed, float x, float y){
        super(x, y);
        this.xSpeed =xSpeed;
        this.ySpeed =ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed(){
        float[] speed = {xSpeed,ySpeed};
        return speed;
    }
    public String toString() {
        return "MovablePoint{" +
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }
}
