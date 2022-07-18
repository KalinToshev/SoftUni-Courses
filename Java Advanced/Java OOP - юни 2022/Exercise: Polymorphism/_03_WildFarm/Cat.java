package PolymorphismExercise.WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private final String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");

        return String.format("%s[%s, %s, %s, %s, %d]",
                getClass().getSimpleName(),
                getAnimalName(),
                breed,
                decimalFormat.format(getAnimalWeight()),
                getLivingRegion(),
                getFoodEaten());
    }
}
