package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish {
    public final static int SALT_WATER_FISH_SIZE = 5;
    //Can only live in SaltwaterAquarium!

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        setSize(SALT_WATER_FISH_SIZE);
    }

    @Override
    public void eat() {
        setSize(getSize() + 2);
    }
}
