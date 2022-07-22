package InterfacesAndAbstractionExercise.MilitaryElite.Soldier;

import InterfacesAndAbstractionExercise.MilitaryElite.Interfaces.LieutenantGeneral;
import InterfacesAndAbstractionExercise.MilitaryElite.Interfaces.Private;
import InterfacesAndAbstractionExercise.MilitaryElite.Interfaces.Soldier;

import java.util.*;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private final List<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    public void addPrivate(Private priv){
        privates.add(priv);
    }

    @Override
    public List<Private> getPrivates() {
        return privates;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Privates:" + (this.privates.isEmpty() ? "" : System.lineSeparator() +
                privates.stream().
                        sorted(Comparator.comparing(Soldier::getId).reversed()).
                        map(p -> "  " + p).
                        collect(Collectors.joining(System.lineSeparator())));
    }

}
