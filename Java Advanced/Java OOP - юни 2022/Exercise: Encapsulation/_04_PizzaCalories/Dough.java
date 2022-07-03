package EncapsulationExercise.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Crispy")
                || bakingTechnique.equals("Chewy")
                || bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public String getFlourType() {
        return flourType;
    }

    public String getBakingTechnique() {
        return bakingTechnique;
    }

    public double getWeight() {
        return weight;
    }

    //Flour Type
    //•	White – 1.5;
    //•	Wholegrain – 1.0;
    //-------------------
    //Baking Technique
    //•	Crispy – 0.9;
    //•	Chewy – 1.1;
    //•	Homemade – 1.0;
    public double calculateCalories() {

        //Based on flour type and baking technique we have different
        //modifiers to calculate the calories of the dough
        double calories = 2 * this.getWeight();

        switch (this.getFlourType()) {
            case "White":
                calories *= 1.5;
                break;
            case "Wholegrain":
                calories *= 1.0;
                break;
        }

        switch (this.getBakingTechnique()) {
            case "Crispy":
                calories *= 0.9;
                break;
            case "Chewy":
                calories *= 1.1;
                break;
            case "Homemade":
                calories *= 1.0;
                break;
        }

        return calories;
    }
}
