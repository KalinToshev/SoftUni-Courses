package InheritanceExercise.animals;

public class Dog extends Animal implements Sound {
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Woof!";
    }

    @Override
    public String toString() {
        return super.toString() + produceSound();
    }
}
