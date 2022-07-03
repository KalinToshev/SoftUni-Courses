package EncapsulationExercise.ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (product.getCost() < money) {
            money -= product.getCost();
            products.add(product);
        } else {
            throw new IllegalArgumentException(name + " can't afford " + product.getName());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (products.isEmpty()) {
            return name + " - Nothing bought";
        }
        return name + " - " + products.stream().map(Product::getName).collect(Collectors.joining(", "));
    }
}
