import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {


    private Card[] cards = {new Card("Cloud"), new Card("Mushroom"), new Card("Fireflower"), new Card("Luigi"), new Card("Mario"), new Card("Star")};

    public ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();

        for (int i = 0; i < 5; i++) {
            deck.addAll(Arrays.asList(cards));
        }

    }

    public ArrayList<Card> getDeck() {
        return deck;
    }



    public void setDeck(ArrayList<Card> d) {
        this.deck = d;
    }

    public Card getCard(int c) {
        return deck.get(c);
    }

}