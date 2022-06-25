package JavaAdvancedExam25June2022.Workout03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        Exercise exerciseToRemove = this.exercises.stream().filter(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)).findFirst().orElse(null);
        if (exerciseToRemove != null) {
                exercises.remove(exerciseToRemove);
                return true;
        } else {
            return false;
        }
    }

    public Exercise getExercise(String name, String muscle) {
        return this.exercises.stream().filter(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)).findFirst().orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return this.exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).orElse(null);
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        return "Workout type: " + this.type + System.lineSeparator() +
                this.exercises.stream().map(Exercise::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExerciseCount(int exerciseCount) {
        this.exerciseCount = exerciseCount;
    }
}
