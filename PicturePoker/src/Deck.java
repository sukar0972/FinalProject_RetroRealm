import java.util.ArrayList;
import java.util.Arrays;

public class Deck {


    private Card[] cards = {new Card("Cloud"), new Card("Mushroom"), new Card("Fireflower"), new Card("Luigi"), new Card("Mario"), new Card("Star")};

    public ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();

        for (int i = 0; i < 5; i++) {
            deck.addAll(Arrays.asList(cards));
        }
        deck = shuffle(deck);
        System.out.println(deck.toString());


    }

    public Card getCard(int c) {
        return deck.get(c);
    }
    public ArrayList<Card> shuffle(ArrayList<Card> d) {
        for (var i = d.size() - 1; i > 0; i--) {
            var j = (int)(Math.random() * 10) + 1;
            var temp = d.get(i);
            d.set(i,d.get(j));
            d.set(j, temp);
        }
        return d;
    }
}