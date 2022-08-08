package aquarium.entities.decorations;

public abstract class BaseDecoration implements Decoration {
    private final int comfort;
    private final double price; //цената на декорацията

    //конструктор
    public BaseDecoration(int comfort, double price) {
        this.comfort = comfort;
        this.price = price;
    }

    @Override
    public int getComfort() {
        return comfort;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
