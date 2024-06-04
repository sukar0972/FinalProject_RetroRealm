import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
public class PokerDrawing extends JPanel {
    private Deck d = new Deck();
    private Card[] houseHand;
    private Card[] playerHand;
    private Image background = new ImageIcon("src/assets/buttons/background.png").getImage();
    private final int DELAY = 15; //delay in between frames
    public PokerDrawing() {
        // Add mouse listener
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                System.out.println(x+" "+y);

                System.out.println(playerHand[0].getXpos()+" and "+playerHand[0].getYpos());

                if(x >=playerHand[0].getXpos() && x<=playerHand[0].getXpos()+32 && y>=playerHand[0].getYpos() && y<=playerHand[0].getYpos()+48) {
                    System.out.println("d");
                }

                repaint(); // Redraw to show selection
            }
        });
        //d.setDeck(shuffle(d.getDeck()));




    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        //give the green background for the cards
        g2d.drawImage(background, 40,30, null);

        for (int i = 0; i < 5; i++) {
            houseHand[i].setXpos(50 + 50 * i);
            houseHand[i].setYpos(50);

            playerHand[i].setXpos(50+50*i);
            playerHand[i].setYpos(165);

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
