import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons = new ArrayList<>();
    private List<Parent> parents = new ArrayList<>();
    private List<Children> childrens = new ArrayList<>();
    private Car car;

    public Person(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPokemons(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void setParents(Parent parent) {
        this.parents.add(parent);
    }

    public void setChildrens(Children children) {
        this.childrens.add(children);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return  name + System.lineSeparator() +
                "Company:" + System.lineSeparator() +
                (company == null ? "" : company + System.lineSeparator()) +
                "Car:" + System.lineSeparator() +
                (car == null ? "" : car + System.lineSeparator()) +
                "Pokemon:" + System.lineSeparator() +
                ((pokemons.isEmpty()) ? "" : pokemons.stream().map(Pokemon::toString).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator()) +
                "Parents:" + System.lineSeparator() +
                ((parents.isEmpty()) ? "" : parents.stream().map(Parent::toString).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator()) +
                "Children:" + System.lineSeparator() +
                ((childrens.isEmpty()) ? "" : childrens.stream().map(Children::toString).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator());
    }
}
