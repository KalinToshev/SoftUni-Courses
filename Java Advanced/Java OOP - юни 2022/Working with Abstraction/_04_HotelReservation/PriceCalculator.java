package WorkingWithAbstractionLab.HotelReservation;

public class PriceCalculator {
    public static double calculateFinalPrice(double pricePerDay, int numberOfDays,
                                             Season season,
                                             DiscountType discountType) {
        double price = pricePerDay * numberOfDays * season.getMultiplier();
        double discountPrice = price * (discountType.getDiscountPercentages() / 100.0);
        return price - discountPrice;
    }
}
