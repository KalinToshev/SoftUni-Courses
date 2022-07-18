package PolymorphismExercise.WildFarm;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Meat){
            throw new IllegalArgumentException(String.format("%s are not eating that type of food!", getAnimalType() + "s"));
        }
        super.eat(food);
    }
}
