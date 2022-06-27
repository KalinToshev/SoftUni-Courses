package WorkingWithAbstractionLab.HotelReservation;

public enum Season {
    Spring(2),
    Summer(4),
    Autumn(1),
    Winter(3);

    private final int multiplier;

    Season(int value) {
        this.multiplier = value;
    }

    public int getMultiplier() {
        return this.multiplier;
    }
}
