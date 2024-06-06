/*
 @author Sullaimon Kargel
Card Class
Allows us to store and access attributes of a card

suit (luigi, mario, star, etc)
image of the cards back and front
xPos of card, and yPos of card
*/


import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Card {
    private String suit;

    //constant, back of card doesnt change
    private final Image cardBack = new ImageIcon("src/assets/card.png").getImage();
    private Image cardFace;
    private int rank;
    private Image icon;
    private int xPos;
    private int yPos;


    /**Primary Constructor
     * Construct a card with just a suit
     * @param suit
     */
    public Card(String suit) {
        this.suit = suit;
        //add the face card image using the suit
        this.cardFace = new ImageIcon("src/assets/card" + suit + ".png").getImage();

        if(suit.equals("Cloud")) {
            rank = 1;
        } else if(suit.equals("Mushroom")) {
            rank = 2;
        } else if(suit.equals("Fireflower")) {
            rank = 3;
        } else if(suit.equals("Luigi")) {
            rank = 4;
        } else if(suit.equals("Mario")) {
            rank = 5;
        } else if(suit.equals("Star")) {
            rank = 6;
        }

    }

    /**Secondary Constructor
     * Construct a card with a suit, and an xPos, yPos
     * @param suit
     * @param xPos
     * @param yPos
     */
    public Card(String suit, int xPos, int yPos) {
        this.suit = suit;

        //add face card image by adding suit
        cardFace = new ImageIcon("src/assets/card" + suit + ".png").getImage();
        this.xPos = xPos;
        this.yPos = yPos;
    }



    public Card(String suit, boolean isFlipped) {
        this.suit = suit;
    }

    public int getXpos() {
        return xPos;
    }

    public int getYpos() {
        return yPos;
    }

    public void setXpos(int x) {
        this.xPos = x;
    }
    public void setYpos(int y) {
        this.yPos = y;
    }


    /**Return card image based upon if its flipped or not
     *
     * @param isFlipped
     * @return image of card how it looks like currently
     */
    public Image getIcon(boolean isFlipped) {
        if(!isFlipped) {
            this.icon = cardFace;
        } else {
            this.icon = cardBack;
        }
        return icon;
    }

    public String getSuit() {
        return suit;
    }

    public boolean equals(Card c) {
       return suit.equals(c.getSuit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, cardBack, cardFace, icon, xPos, yPos);
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", cardBack=" + cardBack +
                ", cardFace=" + cardFace +
                ", icon=" + icon +
                ", xPos=" + xPos +
                ", yPos=" + yPos +
                '}';
    }
}
