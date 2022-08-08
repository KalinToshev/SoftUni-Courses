package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish {
    public final static int FRESH_WATER_FISH_SIZE = 3;
    //Can only live in FreshwaterAquarium!

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        setSize(FRESH_WATER_FISH_SIZE);
    }

    @Override
    public void eat() {
        setSize(getSize() + 3);
    }
}
