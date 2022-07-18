package PolymorphismExercise.VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
    }

    public String drive(String command, double kilometers) {
        double fuelNeeded = kilometers * fuelConsumption;

        if (command.equals("Drive") && (this instanceof Bus)) {
            fuelNeeded = kilometers * (fuelConsumption + 1.4);
        }

        if (fuelNeeded > getFuelQuantity()) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }

        setFuelQuantity(getFuelQuantity() - fuelNeeded);

        DecimalFormat decimalFormat = new DecimalFormat("##.##");

        return String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(kilometers));
    }

    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            if (getFuelQuantity() + liters > getTankCapacity()) {
                System.out.println("Cannot fit fuel in tank");
            } else {
                setFuelQuantity(getFuelQuantity() + liters);
            }
        }
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

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
