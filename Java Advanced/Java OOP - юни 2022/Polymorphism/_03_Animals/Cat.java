package PolymorphismLab.Animals;

public class Cat extends Animal {
    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        StringBuilder sb = new StringBuilder();
        sb.append("I am ").append(super.getName()).append(" and my favourite food is ").append(super.getFavouriteFood()).append(System.lineSeparator()).append("MEEOW");
        return sb.toString();
    }
}
