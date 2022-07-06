package InheritanceExercise.animals;

public class Frog extends Animal implements Sound {
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Ribbit";
    }

    @Override
    public String toString() {
        return super.toString() + produceSound();
    }
}
