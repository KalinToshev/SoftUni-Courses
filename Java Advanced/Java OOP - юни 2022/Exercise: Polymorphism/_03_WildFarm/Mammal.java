package PolymorphismExercise.WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private final String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat( "##.##" );

        return String.format("%s[%s, %s, %s, %d]",
                getClass().getSimpleName(),
                getAnimalName(),
                decimalFormat.format(getAnimalWeight()),
                livingRegion,
                getFoodEaten());
    }

    public String getLivingRegion() {
        return livingRegion;
    }
}
