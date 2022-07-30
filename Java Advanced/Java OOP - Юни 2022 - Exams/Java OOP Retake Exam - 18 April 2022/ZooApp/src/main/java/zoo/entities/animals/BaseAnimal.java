package zoo.entities.animals;

import zoo.common.ExceptionMessages;

public abstract class BaseAnimal implements Animal {
    private String name;
    private String kind;
    private double kg;
    private double price;

    public BaseAnimal(String name, String kind, double price) {
        this.setName(name);
        this.setKind(kind);
        this.setPrice(price);
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.ANIMAL_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        this.price = price;
    }

    private void setKind(String kind) {
        if (ifNullOrEmptyString(kind)) {
            throw new NullPointerException(ExceptionMessages.ANIMAL_KIND_NULL_OR_EMPTY);
        }
        this.kind = kind;
    }

    @Override
    public void setName(String name) {
        if (ifNullOrEmptyString(name)) {
            throw new NullPointerException(ExceptionMessages.ANIMAL_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private boolean ifNullOrEmptyString(String name) {
        return name == null || name.trim().isEmpty();
    }

    protected void setKg(double kg) {
        this.kg = kg;
    }

    @Override
    public void eat() {
        kg += 5;
    }

    @Override
    public double getKg() {
        return kg;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
