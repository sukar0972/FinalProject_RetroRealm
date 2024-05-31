import javax.swing.*;
import java.awt.*;

public class Card {
    private String suit;
    private Image icon;
    private boolean isFlipped;

    public Card(String suit) {
        this.suit = suit;
        this.icon = new ImageIcon("src/assets/card"+suit+".png").getImage();

    }


    public Card(String suit, boolean isFlipped) {
        this.suit = suit;
        this.isFlipped = isFlipped;
    }

    public Image getIcon() {
        return icon;
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
