import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
public class PokerDrawing extends JPanel {
    private Deck d = new Deck();
    private Card[] houseHand;
    private Card[] playerHand;

    private String buttonState;
    private Image background = new ImageIcon("src/assets/buttons/background.png").getImage();
    private Image rankings = new ImageIcon("src/assets/buttons/rankings.png").getImage();
    private Image hold = new ImageIcon("src/assets/buttons/hold.png").getImage();
    private Image draw = new ImageIcon("src/assets/buttons/draw.png").getImage();


    private final int DELAY = 15; //delay in between frames
    public PokerDrawing() {
        final int[] card0Dir = {1};
        final int[] card1Dir = {1};
        final int[] card2Dir = {1};
        final int[] card3Dir = {1};
        final int[] card4Dir = {1};


        game();

        // Add mouse listener
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                System.out.println(x+" and "+y);

                //Raise the players cards if they want to draw
                if(x >=playerHand[0].getXpos() && x<=playerHand[0].getXpos()+32 && y>=playerHand[0].getYpos() && y<=playerHand[0].getYpos()+48) {
                    playerHand[0].setYpos(playerHand[0].getYpos()-(10* card0Dir[0]));
                    card0Dir[0] = card0Dir[0] * -1;
                    buttonState = "draw";

                }

                if(x >=playerHand[1].getXpos() && x<=playerHand[1].getXpos()+32 && y>=playerHand[1].getYpos() && y<=playerHand[1].getYpos()+48) {
                    playerHand[1].setYpos(playerHand[1].getYpos()-(10* card1Dir[0]));
                    card1Dir[0] = card1Dir[0] * -1;
                    buttonState = "draw";

                }

                if(x >=playerHand[2].getXpos() && x<=playerHand[2].getXpos()+32 && y>=playerHand[2].getYpos() && y<=playerHand[2].getYpos()+48) {
                    playerHand[2].setYpos(playerHand[2].getYpos()-(10* card2Dir[0]));
                    card2Dir[0] = card2Dir[0] * -1;
                    buttonState = "draw";

                }

                if(x >=playerHand[3].getXpos() && x<=playerHand[3].getXpos()+32 && y>=playerHand[3].getYpos() && y<=playerHand[3].getYpos()+48) {
                    playerHand[3].setYpos(playerHand[3].getYpos()-(10* card3Dir[0]));
                    card3Dir[0] = card3Dir[0] * -1;
                    buttonState = "draw";

                }

                if(x >=playerHand[4].getXpos() && x<=playerHand[4].getXpos()+32 && y>=playerHand[4].getYpos() && y<=playerHand[4].getYpos()+48) {
                    playerHand[4].setYpos(playerHand[4].getYpos()-(10* card4Dir[0]));
                    card4Dir[0] = card4Dir[0] * -1;
                    buttonState = "draw";

                }

                if(card1Dir[0]== 1 && card2Dir[0]== 1 && card3Dir[0]== 1 && card4Dir[0]==1 && card0Dir[0] ==1) {
                    buttonState = "hold";
                }



                if(buttonState!=null && x >=100 && x<=100+144 && y>=115 && y<=115+32)  {
                    System.out.println("button pressed");
                    checkHand(playerHand);
                }

                repaint(); // Redraw to show selection
            }
        });
    }

    private void checkHand(Card[] hand) {

        ArrayList<Card> matching = new ArrayList<Card>();

        for (int i = 0; i < hand.length - 1; i++) {
            for (int j = i + 1; j < hand.length; j++) {
                if (hand[i].equals((Card) hand[j])) {
                    System.out.println(hand[i].getSuit());
                    matching.add(hand[i]);
                }
                }
            }

        for (int i = 0; i < matching.size()-1; i++) {
            for (int j = i+1; j < matching.size(); j++) {
                if(matching.get(i).equals((Card)matching.get(j))) {
                    System.out.println(matching.get(i));
                }
            }
        }

        }

    private void game() {
        d.setDeck(shuffle(d.getDeck()));


        houseHand = d.deal(0);
        playerHand = d.deal(5);

        for (int i = 0; i < 5; i++) {
            houseHand[i].setXpos(50 + 50 * i);
            houseHand[i].setYpos(50);

            playerHand[i].setXpos(50 + 50 * i);
            playerHand[i].setYpos(165);
        }

        }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        //give the green background for the cards
        g2d.drawImage(background, 40,30, null);

        //show the card rankings
        g2d.drawImage(rankings, 10,90, null);

        if(buttonState!= null && buttonState.equals("hold")) {
            g2d.drawImage(hold, 100,115,null);
        } else if(buttonState!=null && buttonState.equals("draw")) {
            g2d.drawImage(draw, 100,115,null);
        } else {
            repaint();
        }


        for (int i = 0; i < 5; i++) {

            g2d.drawImage(houseHand[i].getIcon(true), houseHand[i].getXpos() , houseHand[i].getYpos(), null);
            g2d.drawImage(playerHand[i].getIcon(false), playerHand[i].getXpos(), playerHand[i].getYpos(), null);
        }

    }
    public ArrayList<Card> shuffle(ArrayList<Card> deck) {
        Random random = new Random(); // Create a Random object
        for (int i = deck.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // Get a random index from 0 to i (inclusive)
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
        return deck;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
    public void addNotify() {
        super.addNotify();
        //Thread animator = new Thread(this); //start a new thread
        //animator.start(); //start the run method
    }


    public void run() {
        long beforeTime, timeDiff, sleep;
        int dirX =1;
        int dirY = 1;
        beforeTime = System.currentTimeMillis();

        while(true) {
            repaint();



            //calculate how much time has passed since the last call
            //this allows smooth updates and our ball will move at a constant speed (as opposed to being dependent on processor availability)
            timeDiff = System.currentTimeMillis() - beforeTime;

            //calculate how much time to wait before the next call
            sleep = DELAY - timeDiff;

            //always wait at least 2 ms
            if (sleep < 0) {
                sleep = 2;
            }

            //try to actually wait
            try {
                Thread.sleep(sleep); //pause code for sleep amount of time
            } catch (InterruptedException e) {
                //threads can be interrupted from other threads
                JOptionPane.showMessageDialog(this, "Thread interrupted: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            beforeTime = System.currentTimeMillis();
        }
    }
}
