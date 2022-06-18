package JavaAdvancedRetakeExam15December2021.WaterAdventure03;

import java.util.HashMap;
import java.util.Map;

public class Aquarium {
    private Map<String, Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        fishInPool = new HashMap<>();
        this.name = name;
        this.capacity = capacity;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        if (this.fishInPool.size() < this.capacity) {
            this.fishInPool.putIfAbsent(fish.getName(), fish);
        }
    }

    public boolean remove(String name) {
        if (fishInPool.containsKey(name)) {
            fishInPool.remove(name);
            return true;
        }
        return false;
    }

    public Fish findFish(String name) {
        if (fishInPool.containsKey(name)) {
            return fishInPool.get(name);
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aquarium: ").append(getName()).append(" ^ ").append("Size: ").append(getSize()).append(System.lineSeparator());
        for (var stringFishEntry : fishInPool.entrySet()) {
            sb.append(stringFishEntry.getValue());
        }
        return sb.toString();
    }
}

