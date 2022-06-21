package JavaAdvancedExam26June2021.GroomingSalon03;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        Pet petToRemove = data.stream().filter(pet -> pet.getName().equals(name)).findFirst().orElse(null);
        if (petToRemove != null) {
            this.data.remove(petToRemove);
            return true;
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet petToGet = data.stream().filter(pet -> pet.getName().equals(name)).findFirst().orElse(null);
        if (petToGet != null) {
            if (petToGet.getOwner().equals(owner)) {
                return petToGet;
            }
        }
        return petToGet;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet : data) {
            sb.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}

