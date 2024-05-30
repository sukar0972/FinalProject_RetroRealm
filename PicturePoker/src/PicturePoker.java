import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.EventQueue;


public class PicturePoker extends JFrame {

    public static void main(String[] args) {
        //makes sure that GUI updates nicely with the rest of the OS
        EventQueue.invokeLater(() -> {
            //create the JFrame
            PicturePoker frame = new PicturePoker();
        });
    }

    public PicturePoker() {
        initUI();
    }
    private void initUI() {
        //set title of the JFrame
        setTitle("Picture Poker");
        //add a custom JPanel to draw on
        add(new PokerDrawing());
        //set the size of the window
        setSize(720, 480);
        //make it visible
        setVisible(true);
        //tell the JFrame what to do when closed
        //this is important if our application has multiple windows
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}

