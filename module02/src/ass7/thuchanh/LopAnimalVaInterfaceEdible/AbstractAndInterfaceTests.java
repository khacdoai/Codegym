package ass7.thuchanh.LopAnimalVaInterfaceEdible;

import ass7.thuchanh.fruit.Apple;
import ass7.thuchanh.fruit.Fruit;
import ass7.thuchanh.fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new chicken();
        Fruit[] fruit = new Fruit[2];
        fruit[0] = new Orange();
        fruit[1] = new Apple();
        for (Fruit fruits : fruit) {
            System.out.println(fruits.howToEat());
        }
        for (Animal animal :animals){
            System.out.println(animal.makeSound());

            if (animal instanceof chicken){
                edible edible = (chicken) animal;
                System.out.println(edible.howToEat());
            }
        }
    }
}
