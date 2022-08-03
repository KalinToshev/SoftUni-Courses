package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private final Collection<HealthyFood> healthyFood;
    private final Collection<Beverages> beverages;
    private final int number;
    private int size;
    private int numberOfPeople;
    private final double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.number = number;
        setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.isReservedTable = false;
    }

    private void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if(numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    private void setAllPeople() {
        this.allPeople = allPeople();
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return numberOfPeople * pricePerPerson;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        setAllPeople();
        isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double healthyFoodBill = healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double beveragesBill = beverages.stream().mapToDouble(s -> s.getPrice()*s.getCounter()).sum();
        return healthyFoodBill + beveragesBill + allPeople();
    }

    @Override
    public void clear() {
        healthyFood.clear();
        beverages.clear();
        isReservedTable = false;
        numberOfPeople = 0;
        allPeople = 0;
    }

    @Override
    public String tableInformation() {
        return "Table - " + number + System.lineSeparator() +
                "Size - " + size + System.lineSeparator() +
                "Type - " + getClass().getSimpleName() + System.lineSeparator() +
                "All price - " + pricePerPerson;
    }
}
