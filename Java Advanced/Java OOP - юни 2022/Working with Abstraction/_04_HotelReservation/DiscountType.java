package WorkingWithAbstractionLab.HotelReservation;

public enum DiscountType {
    None(0),
    SecondVisit(10),
    VIP(20);

    private final int discountPercentages;

    DiscountType(int value) {
        this.discountPercentages = value;
    }

    public int getDiscountPercentages() {
        return this.discountPercentages;
    }
}
