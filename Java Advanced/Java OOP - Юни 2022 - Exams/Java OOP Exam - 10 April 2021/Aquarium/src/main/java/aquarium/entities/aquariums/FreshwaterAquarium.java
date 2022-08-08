package aquarium.entities.aquariums;

public class FreshwaterAquarium extends BaseAquarium {
    public final static int FRESH_WATER_AQUARIUM_CAPACITY = 50;

    public FreshwaterAquarium(String name) {
        super(name, FRESH_WATER_AQUARIUM_CAPACITY);
    }
}
