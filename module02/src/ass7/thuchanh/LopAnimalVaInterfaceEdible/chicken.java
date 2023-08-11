package ass7.thuchanh.LopAnimalVaInterfaceEdible;

public class chicken extends Animal implements edible{
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
