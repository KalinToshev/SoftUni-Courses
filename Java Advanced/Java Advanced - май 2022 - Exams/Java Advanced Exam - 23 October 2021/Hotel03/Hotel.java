package JavaAdvancedExam23October2021.Hotel03;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        Person personToRemove = this.roster.stream().filter(person -> person.getName().equals(name)).findFirst().orElse(null);
        if (personToRemove != null) {
            this.roster.remove(personToRemove);
            return true;
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        Person personToFind = this.roster.stream().filter(person -> person.getName().equals(name)).findFirst().orElse(null);
        if (personToFind != null) {
            if (personToFind.getHometown().equals(hometown)) {
                return personToFind;
            }
        }
        return null;
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The people in the hotel ").append(getName()).append(" are:").append(System.lineSeparator());
        for (Person person : this.roster) {
            sb.append(person);
        }
        return sb.toString();
    }

    public List<Person> getRoster() {
        return roster;
    }

    public void setRoster(List<Person> roster) {
        this.roster = roster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
