package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
    private final static double ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, ENERGY);
    }

    @Override
    public void search() {
        setEnergy(getEnergy() - 7);
        if (getEnergy() < 0) {
            setEnergy(0);
        }
    }
}
