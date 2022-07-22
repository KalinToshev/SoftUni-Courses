package InterfacesAndAbstractionExercise.MilitaryElite.Soldier;

import InterfacesAndAbstractionExercise.MilitaryElite.Enum.Corps;
import InterfacesAndAbstractionExercise.MilitaryElite.Interfaces.Commando;
import InterfacesAndAbstractionExercise.MilitaryElite.Mission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private final Collection<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corp) {
        super(id, firstName, lastName, salary, corp);
        this.missions = new ArrayList<>();
    }

    public void addMission(Mission mission) {
        missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return missions;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Missions:" + (missions.isEmpty() ? "" : System.lineSeparator() +
                missions.stream().
                        map(m -> "  " + m).
                        collect(Collectors.joining(System.lineSeparator())));
    }

}
