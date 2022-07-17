package PolymorphismExercise.Vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double kilometers) {
        double fuelNeeded = kilometers * fuelConsumption;

        if (fuelNeeded > getFuelQuantity()) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }

        setFuelQuantity(getFuelQuantity() - fuelNeeded);

        DecimalFormat decimalFormat = new DecimalFormat("##.##");

        return String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(kilometers));
    }

    public void refuel(double liters) {
        setFuelQuantity(getFuelQuantity() + liters);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
