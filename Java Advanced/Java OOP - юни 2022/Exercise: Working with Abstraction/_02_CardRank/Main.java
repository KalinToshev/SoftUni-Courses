package WorkingWithAbstractionExercise.CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        CardRanks[] cardRanks = CardRanks.values();
        for (CardRanks cardRank : cardRanks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardRank.ordinal(), cardRank);
        }
    }
}
