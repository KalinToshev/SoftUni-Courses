package JavaAdvancedRetakeExam19August2020.VetClinic03;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        Pet petToRemove = this.data.stream().filter(pet -> pet.getName().equals(name)).findFirst().orElse(null);
        if (petToRemove != null) {
            this.data.remove(petToRemove);
            return true;
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet petToGet = this.data.stream().filter(pet -> pet.getName().equals(name)).findFirst().orElse(null);
        if (petToGet != null) {
            if (petToGet.getOwner().equals(owner)) {
                return petToGet;
            }
        }
        return petToGet;
    }

   public Pet getOldestPet() {
        Pet oldestPet = null;
        int oldest = Integer.MIN_VALUE;
        for (Pet pet : this.data) {
           if (pet.getAge() > oldest) {
               oldest = pet.getAge();
           }
       }
        int finalOldest = oldest;
        oldestPet = this.data.stream().filter(pet -> pet.getAge() == finalOldest).findFirst().orElse(null);
        return oldestPet;
   }

   public int getCount() {
        return this.data.size();
   }

   public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append(System.lineSeparator());
       for (Pet pet : this.data) {
           sb.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
       }
       return sb.toString();
   }
}
