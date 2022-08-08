package aquarium.entities.aquariums;

public class SaltwaterAquarium extends BaseAquarium {
    public final static int SALT_WATER_AQUARIUM_CAPACITY = 25;

    public SaltwaterAquarium(String name) {
        super(name, SALT_WATER_AQUARIUM_CAPACITY);
    }
}
