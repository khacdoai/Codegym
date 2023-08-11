package ass5.thuchanh.staticProperty;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car1 = new Car("Mazda 3", "Skyactiv 3");
        System.out.println(Car.numberOfCars);
        Car car2 = new Car("Mazda 6", "Skyactiv 6");
        System.out.println(Car.numberOfCars);
        Car car4 = new Car("Mazda 8", "Skyactiv 8");
        System.out.println(Car.numberOfCars);
    }
}
