package EncapsulationExercise.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public String getToppingType() {
        return toppingType;
    }

    public double getWeight() {
        return weight;
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat")
                || toppingType.equals("Veggies")
                || toppingType.equals("Cheese")
                || toppingType.equals("Sauce")) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1.0 && weight <= 50.0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
    }

    //•	Meat – 1.2;
    //•	Veggies – 0.8;
    //•	Cheese – 1.1;
    //•	Sauce – 0.9;
    public double calculateCalories() {

        //Based on topping type we have different
        //modifiers to calculate the calories of the topping
        double calories = 2 * this.getWeight();

        switch (this.getToppingType()) {
            case "Meat":
                calories *= 1.2;
                break;
            case "Veggies":
                calories *= 0.8;
                break;
            case "Cheese":
                calories *= 1.1;
                break;
            case "Sauce":
                calories *= 0.9;
                break;
        }

        return calories;
    }
}
