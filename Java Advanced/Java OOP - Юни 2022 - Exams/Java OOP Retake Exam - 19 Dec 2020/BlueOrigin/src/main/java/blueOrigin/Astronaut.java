package blueOrigin;

public class Astronaut {
    private final String name; //име
    private final double oxygenInPercentage; //кислород в проценти

    //конструктор
    public Astronaut(String name, double oxygenInPercentage) {
        this.name = name;
        this.oxygenInPercentage = oxygenInPercentage;
    }

    //гетъри

    public String getName() {
        return this.name;
    }

    public double getOxygenInPercentage() {
        return this.oxygenInPercentage;
    }
}
