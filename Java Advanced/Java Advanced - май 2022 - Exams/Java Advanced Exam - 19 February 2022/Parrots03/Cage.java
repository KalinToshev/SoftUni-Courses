package JavaAdvancedExam19February2022.Parrots03;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (capacity > data.size()) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        if (data.contains(name)) {
            data.remove(name);
            return true;
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        Parrot p = null;
        boolean isFound = false;
        for (Parrot parrot : data) {
            if (isFound) {
                break;
            }
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                p = parrot;
                isFound = true;
            }
        }
        return p;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> p = new ArrayList<>();
        for (Parrot parrot : data) {
            if (parrot.getSpecies().equals(species)) {
                parrot.setAvailable(false);
                p.add(parrot);
            }
        }
        return p;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(name).append(":").append(System.lineSeparator());
        for (int i = 0; i < data.size(); i++) {
            Parrot parrot = data.get(i);
            if (parrot.isAvailable()) {
                sb.append(parrot.toString());
            }
            if (i < data.size() - 1) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
