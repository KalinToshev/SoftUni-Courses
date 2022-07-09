package InterfacesAndAbstractionExercise.BirthdayCelebrations;

public class Robot implements Identifiable {
    private final String id;
    private final String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
