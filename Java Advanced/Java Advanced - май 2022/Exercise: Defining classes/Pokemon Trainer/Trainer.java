import java.util.ArrayList;
import java.util.List;

public class Trainer {
    //name, a number of badges, and a collection of pokemon
    private String name;
    private int badges = 0;
    private final List<Pokemon> pokemons = new ArrayList<>();

    public Trainer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    @Override
    public String toString() {
        return name + " " + badges + " " + pokemons.size();
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public boolean hasElement(String element){
        return this.pokemons.stream().anyMatch(pokemon -> pokemon.getElement().equals(element));
    }

    public void applyCommand(String element){
        if(hasElement(element)) {
            this.badges++;
        }
        else {
            this.pokemons.forEach(Pokemon::looseHealth);
            this.pokemons.removeIf(Pokemon::isDead);
        }
    }
}
