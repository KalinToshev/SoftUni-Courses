package heroRepository;

public class Hero {
    private String name; //име
    private int level; //ниво

    //конструктор -> име, ниво
    public Hero(String name, int level) {
        //енкапсулация
        this.setName(name);
        this.setLevel(level);
    }

    //гетъри и сетъри

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return this.level;
    }

    private void setLevel(int level) {
        this.level = level;
    }
}
