package InterfacesAndAbstractionExercise.MilitaryElite.Soldier;

import InterfacesAndAbstractionExercise.MilitaryElite.Enum.Corps;
import InterfacesAndAbstractionExercise.MilitaryElite.Interfaces.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private final Corps corp;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corp) {
        super(id, firstName, lastName, salary);
        this.corp = corp;
    }

    @Override
    public Corps getCorps() {
        return corp;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Corps: " + getCorps();
    }

}
