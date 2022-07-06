package InheritanceExercise.animals;

public class Cat extends Animal implements Sound {
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Meow meow";
    }

    @Override
    public String toString() {
        return super.toString() + produceSound();
    }
}
