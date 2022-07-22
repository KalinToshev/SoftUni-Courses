package InterfacesAndAbstractionExercise.MilitaryElite;

import InterfacesAndAbstractionExercise.MilitaryElite.Enum.States;

import java.util.Arrays;

public class Mission {

    private final String codeName;
    private States state;

    public Mission(String codeName, States state) {
        this.codeName = codeName;
        setState(state);
    }

    private void setState(States state) {
        boolean stateExists = Arrays.asList(States.values()).contains(state);
        if(!stateExists) {
            throw new IllegalArgumentException();
        }
        this.state = state;
    }

    public void completeMission() {
        state = States.finished;
    }

    public String getCodeName() {
        return codeName;
    }

    public States getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", codeName, state.name());
    }

}
