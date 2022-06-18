package JavaAdvancedRetakeExam15December2021.WaterAdventure03;

public class Fish {
    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getFins() {
        return fins;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fish: ").append(getName()).append(System.lineSeparator());
        sb.append("Color: ").append(getColor()).append(System.lineSeparator());
        sb.append("Number of fins: ").append(getFins()).append(System.lineSeparator());
        return sb.toString();
    }
}
