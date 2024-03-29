package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import static glacialExpedition.common.ExceptionMessages.*;
import static glacialExpedition.common.ConstantMessages.*;

public abstract class BaseExplorer implements Explorer {
    private String name;
    private double energy;
    private Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.suitcase = new Carton();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public boolean canSearch() {
        return getEnergy() > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return suitcase;
    }

    @Override
    public void search() {
        setEnergy(getEnergy() - 15);
        if (getEnergy() < 0) {
            setEnergy(0);
        }
    }

    @Override
    public String toString(){
        return String.format(FINAL_EXPLORER_NAME, name) + System.lineSeparator() +
                String.format(FINAL_EXPLORER_ENERGY, energy) + System.lineSeparator() +
                String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        (suitcase.getExhibits().size() == 0 ?
                                "None" :
                                String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, suitcase.getExhibits())));
    }
}
