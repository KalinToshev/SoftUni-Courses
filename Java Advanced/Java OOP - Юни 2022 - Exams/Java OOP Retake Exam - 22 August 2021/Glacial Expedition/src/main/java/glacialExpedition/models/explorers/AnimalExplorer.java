package glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer {
    public final static double ENERGY = 100;

    public AnimalExplorer(String name) {
        super(name, ENERGY);
    }
}
