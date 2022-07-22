package InterfacesAndAbstractionExercise.MilitaryElite;

import InterfacesAndAbstractionExercise.MilitaryElite.Enum.Corps;
import InterfacesAndAbstractionExercise.MilitaryElite.Enum.States;
import InterfacesAndAbstractionExercise.MilitaryElite.Interfaces.Private;
import InterfacesAndAbstractionExercise.MilitaryElite.Interfaces.Soldier;
import InterfacesAndAbstractionExercise.MilitaryElite.Soldier.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<Integer, Soldier> soldiers = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;

        while (!"End".equals(input = scanner.nextLine())) {

            String[] attributes = input.split("\\s+");

            String soldierType = attributes[0];
            int id = Integer.parseInt(attributes[1]);
            String firstName = attributes[2];
            String lastName = attributes[3];

            switch (soldierType) {
                case "Private":
                    createPrivate(attributes, id, firstName, lastName);
                    break;

                case "LieutenantGeneral":
                    createLieutenantGeneral(attributes, id, firstName, lastName);
                    break;

                case "Engineer":
                    createEngineer(attributes, id, firstName, lastName);
                    break;

                case "Commando":
                    createCommando(attributes, id, firstName, lastName);
                    break;

                case "Spy":
                    createSpy(attributes, id, firstName, lastName);
                    break;
            }
        }

        soldiers.values().forEach(System.out::println);

    }

    private static void createSpy(String[] attributes, int id, String firstName, String lastName) {
        String codeNumber = attributes[4];

        SpyImpl spy = new SpyImpl(id, firstName, lastName, codeNumber);
        soldiers.put(id, spy);
    }

    private static void createCommando(String[] attributes, int id, String firstName, String lastName) {
        double salary = Double.parseDouble(attributes[4]);
        try {
            Corps corps = Corps.valueOf(attributes[5]);

            CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, corps);

            for (int i = 6; i < attributes.length; i += 2) {
                String codeName = attributes[i];
                try {
                    States state = States.valueOf(attributes[i + 1]);
                    commando.addMission(new Mission(codeName, state));
                } catch (IllegalArgumentException ignored) {
                }
            }

            soldiers.put(id, commando);
        } catch (IllegalArgumentException ignored) {
        }
    }

    private static void createEngineer(String[] attributes, int id, String firstName, String lastName) {
        double salary = Double.parseDouble(attributes[4]);
        try {
            Corps corps = Corps.valueOf(attributes[5]);

            EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corps);

            for (int i = 6; i < attributes.length; i += 2) {
                String partName = attributes[i];
                int hoursWorked = Integer.parseInt(attributes[i + 1]);

                engineer.addRepair(new Repair(partName, hoursWorked));
            }

            soldiers.put(id, engineer);
        } catch (IllegalArgumentException ignored) {
        }
    }

    private static void createLieutenantGeneral(String[] attributes, int id, String firstName, String lastName) {
        double salary = Double.parseDouble(attributes[4]);

        LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);

        for (int i = 5; i < attributes.length; i++) {
            lieutenantGeneral.addPrivate((Private) soldiers.get(Integer.parseInt(attributes[i])));
        }

        soldiers.put(id, lieutenantGeneral);
    }

    private static void createPrivate(String[] attributes, int id, String firstName, String lastName) {
        double salary = Double.parseDouble(attributes[4]);

        PrivateImpl newPrivate = new PrivateImpl(id, firstName, lastName, salary);
        soldiers.put(id, newPrivate);
    }

}
