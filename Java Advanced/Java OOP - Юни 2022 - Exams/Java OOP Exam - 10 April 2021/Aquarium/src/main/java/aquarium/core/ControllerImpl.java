package aquarium.core;

import static aquarium.common.ExceptionMessages.*;

import static aquarium.common.ConstantMessages.*;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium = null;

        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;

            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;

            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        aquariums.add(aquarium);

        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration = null;

        switch (type){
            case "Ornament":
                decoration = new Ornament();
                break;

            case "Plant":
                decoration = new Plant();
                break;

            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }

        decorations.add(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = decorations.findByType(decorationType);

        if(decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }

        Aquarium aquarium = getAquarium(aquariumName);

        aquarium.addDecoration(decoration);
        decorations.remove(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish = null;

        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;

            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;

            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        Aquarium aquarium = getAquarium(aquariumName);

        if(!aquarium.getClass().getSimpleName().substring(0, 5).equals(fishType.substring(0, 5))) {
            return WATER_NOT_SUITABLE;
        }

        aquarium.addFish(fish);

        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = getAquarium(aquariumName);
        aquarium.feed();

        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = getAquarium(aquariumName);
        double allFishPrice = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double allDecorationPrice = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();

        return String.format(VALUE_AQUARIUM, aquariumName, allDecorationPrice + allFishPrice);
    }

    @Override
    public String report() {
        return aquariums.stream().map(Aquarium::getInfo).collect(Collectors.joining(System.lineSeparator()));
    }

    private Aquarium getAquarium(String aquariumName) {
        return aquariums.stream()
                .filter(aquarium1 -> aquarium1.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);
    }
}
