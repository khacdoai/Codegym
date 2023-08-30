package ss16.mvc.model;


public class Teacher extends Person {
    private double salary;
    private String position;

    public Teacher() {
    }

    public Teacher(int code, String name, String dateOfBirth, double salary, String position) {
        super(code, name, dateOfBirth);
        this.salary = salary;
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
