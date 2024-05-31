import java.awt.*;

public class Card {
    private String suit;
    private Image card;
    private boolean isFlipped;

    public Card(String suit) {
        this.suit = suit;
    }

    public Card(String suit, boolean isFlipped) {
        this.suit = suit;
        this.isFlipped = isFlipped;
    }

    public String getSuit() {
        return suit;
    }

    public boolean getIsFlipped() {
        return isFlipped;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", isFlipped=" + isFlipped +
                '}';
    }
}
