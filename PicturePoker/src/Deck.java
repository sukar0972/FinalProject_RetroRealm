/*
 @author S. Kargel

Deck Class
Allows user to have a deck of card where they can deal a hand, access a specific card in the deck, or modify aforementioned attributes
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Deck {
    public ArrayList<Card> deck;

    /**Primary Constructor
     *Construct a deck using the 6 cards 5 times
     */
    public Deck() {
        deck = new ArrayList<Card>();

        //Add all 6 suits to the deck 5 times
        for (int i = 0; i < 5; i++) {
            Card[] cards = {new Card("Cloud"), new Card("Mushroom"), new Card("Fireflower"), new Card("Luigi"), new Card("Mario"), new Card("Star")};
            deck.addAll(Arrays.asList(cards));
        }

    }

    public ArrayList<Card> getDeck() {
        return deck;
    }


    /**Currently in progress
     * Deal 5 cards, and move 5 cards to the end of the array
     * @param start where to start dealing from
     * @return array of cards (hand)
     */
    public Card[] deal(int start) {
        Card[] s =  {deck.get(start), deck.get(start+1),deck.get(start+2),deck.get(start+3),deck.get(start+4)};
//        deck.add(deck.get(start));
//        deck.add(deck.get(start+1));
//        deck.add(deck.get(start+2));
//        deck.add(deck.get(start+3));
//        deck.add(deck.get(start+4));

        deck.remove(start);
        deck.remove(start+1);
        deck.remove(start+2);
        deck.remove(start+3);
        deck.remove(start+4);
        return s;
    }

    public void setDeck(ArrayList<Card> d) {
        this.deck = d;
    }

    public Card getCard(int c) {
        return deck.get(c);
    }

}