package heroRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class HeroRepository {
    private Collection<Hero> data; //колекция от герои

    //констурктор -> ()
    public HeroRepository() {
        //Инициализираме колекцията от герои като ArrayList
        this.data = new ArrayList<>();
    }

    //връща броя на героите в колекцията
    public int getCount() {
        return this.data.size();
    }

    //метод за добавяне на герой към колекцията -> hero
    public String create(Hero hero) {
        //проверка, ако подадения герои за параметър е null
        if (hero == null) {
            throw new NullPointerException("Hero is null");
        }
        //проверка, ако подадения герои за параметр вече съществува в колекцията
        if (this.data.stream().anyMatch(h -> h.getName().equals(hero.getName()))) {
            throw new IllegalArgumentException("Hero with name %s already exists");
        }
        //след проверките -> добавяне на героя към колекцията
        this.data.add(hero);
        return String.format("Successfully added hero %s with level %d", hero.getName(), hero.getLevel());
    }

    //метод за премахване на герой от колекцията -> name
    public boolean remove(String name) {
        //проверка, ако подаденото име на героя като параметър е null или само интервали
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Name cannot be null");
        }
        //премахване на героя с подаденото име и връщане на булева стойност, ако:
        //1. героя с подаденото име съществува в колекцията
        //2. героя с подаденото име не съществува в колекцията
        boolean isRemoved = this.data.removeIf(h -> h.getName().equals(name));
        return isRemoved;
    }

    //метод, който не приема никакви параметри и връща героя с най-високо ниво от колекцията
    //ако няма такъв герой, метода връща null
    public Hero getHeroWithHighestLevel() {
        Hero hero = this.data
                .stream()
                .max(Comparator.comparingInt(Hero::getLevel))
                .orElse(null);

        return hero;
    }

    //метод за взимане на герой от колекцията по подаден параметър - име
    //ако няма такъв герой с такова име в колекцията, метода връща null
    public Hero getHero(String name) {
        Hero hero = this.data
                .stream()
                .filter(h -> h.getName().equals(name))
                .findFirst()
                .orElse(null);

        return hero;
    }

    //гетър, който връща колекцията от герои като unmodifiableCollection
    public Collection<Hero> getHeroes() {
        return Collections.unmodifiableCollection(this.data);
    }
}
