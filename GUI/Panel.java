import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel {
    public static void main(String[] args) {

        // JPanel = A GUI component that Functions as a container to hold other
        // components.
        JPanel krish_1 = new JPanel();
        krish_1.setBackground(Color.BLUE);
        krish_1.setBounds(0, 0, 100, 100);

        JPanel krish_2 = new JPanel();
        krish_2.setBackground(Color.CYAN);
        krish_2.setBounds(300, 0, 100, 50);

        JPanel rafee_1 = new JPanel();
        rafee_1.setBackground(Color.RED);
        rafee_1.setBounds(100, 0, 100, 100);

        JPanel rafee_2 = new JPanel();
        rafee_2.setBackground(Color.pink);
        rafee_2.setBounds(200, 0, 100, 300);

        JFrame frame = new JFrame();// creates a frame
        frame.setSize(500, 500);// Sets the x-dimension , and y-dimension of frame.
        frame.setTitle("Chekto");// set title of frame.
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // make frame visible.

        ImageIcon image = new ImageIcon("Rfee.jpg"); // create an ImageIcon.
        frame.setIconImage(image.getImage()); // change icon of frame.
        frame.getContentPane().setBackground(Color.BLACK);// Change color of background.
        frame.add(rafee_1);
        frame.add(rafee_2);
        frame.add(krish_1);
        frame.add(krish_2);
    }
} 