public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1Kilometer;
    private double distanceTraveled;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostFor1Kilometer() {
        return fuelCostFor1Kilometer;
    }

    public void setFuelCostFor1Kilometer(double fuelCostFor1Kilometer) {
        this.fuelCostFor1Kilometer = fuelCostFor1Kilometer;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public Car(String model, double fuelAmount, double fuelCostFor1Kilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Kilometer = fuelCostFor1Kilometer;
        this.distanceTraveled = 0;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", getModel(), getFuelAmount(), getDistanceTraveled());
    }
}
