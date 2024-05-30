import java.awt.*;
import javax.swing.*;
public class PokerDrawing extends JPanel implements Runnable {
    private final int DELAY = 15; //delay in between frames
    private int x; //x position of ball
    private int y; //y position of ball
    private Image card;

    public PokerDrawing() {
        loadImage();
    }
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED); //set ball color

        g2d.drawImage(card, 50, 50, null);



    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }



    public void addNotify() {
        super.addNotify();

        Thread animator = new Thread(this); //start a new thread
        animator.start(); //start the run method
    }

    private void loadImage() {
        card = new ImageIcon("src/assets/cloudCard.png").getImage();
    }

    public void run() {
        long beforeTime, timeDiff, sleep;
        int dirX =1;
        int dirY = 1;
        beforeTime = System.currentTimeMillis();

        while(true) {

            //move ball in respective locations


            //repaint screen so the ball actually moves
            repaint();

            //x position within screen, if starts to hit the edge start moving in opposite direction

            if(x >= 450) {
                dirX = -1;
            }
            if(x<=0) {
                dirX = 1;
            }
            //y position within screen, if starts to hit the edge start moving in opposite direction
            if(y >= 450) {
                dirY = -1;
            }
            if(y <=0) {
                dirY = 1;
            }

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
