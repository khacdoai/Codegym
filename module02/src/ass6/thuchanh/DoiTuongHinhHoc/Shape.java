package ass6.thuchanh.DoiTuongHinhHoc;

public class Shape {
    private String colorer = "Green";
    private  boolean filled = true;

    public Shape(){

    }

    public Shape(String color, boolean filled){
        this.colorer = color;
        this.filled = filled;

    }
    public String getColor(){
        return colorer;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setColor(String color) {
        this.colorer = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public String toString(){
        return "A shape with color of  "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled" );

    }
}
