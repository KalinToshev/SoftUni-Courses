package WorkingWithAbstractionExercise.CardsWithPower;

public class Card {
    private Suit cardSuit;
    private Ranks cardRank;
    private int cardPower;

    public Card(Ranks cardRank, Suit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public Suit getCardSuit() {
        return cardSuit;
    }

    public Ranks getCardRank() {
        return cardRank;
    }

    public int getCardPower() {
        return this.cardRank.getRankPower() + this.cardSuit.getSuitPower();
    }
}
