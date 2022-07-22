package InterfacesAndAbstractionExercise.MilitaryElite.Soldier;

import InterfacesAndAbstractionExercise.MilitaryElite.Interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {

    private final String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d",
                getFirstName(), getLastName(),
                getId()) +
                System.lineSeparator() +
                String.format("Code Number: %s", codeNumber);
    }

}
