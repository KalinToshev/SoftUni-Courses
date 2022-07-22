package InterfacesAndAbstractionExercise.MilitaryElite.Soldier;

import InterfacesAndAbstractionExercise.MilitaryElite.Enum.Corps;
import InterfacesAndAbstractionExercise.MilitaryElite.Interfaces.Engineer;
import InterfacesAndAbstractionExercise.MilitaryElite.Repair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private final Collection<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corp) {
        super(id, firstName, lastName, salary, corp);
        this.repairs = new ArrayList<>();
    }

    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return repairs;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Repairs:" + (repairs.isEmpty() ? "" : System.lineSeparator() +
                repairs.stream()
                        .map(rep -> "  " + rep)
                        .collect(Collectors.joining(System.lineSeparator())));
    }

}
