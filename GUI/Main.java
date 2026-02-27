import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
    public static void main(String[] arge) {




        // JPanel = A GUI component that Functions as a container to hold other components.

        ImageIcon image2 = new ImageIcon("Rfee.jpg");
        ImageIcon image3 = new ImageIcon("Rfee.jpg");
        // JLabel = a GUI display area for a string of text, an image, or both.
        JLabel krish_label = new JLabel(); // create a label.
        krish_label.setText("Krish is here ");

        JLabel Rafee_label = new JLabel();
        Rafee_label.setText("Bro, do you even code :"); // set text of label

        Rafee_label.setIcon(image2);
        krish_label.setIcon(image3);

        Rafee_label.setHorizontalTextPosition(JLabel.RIGHT); // set text left , center , right of imageicon.
        krish_label.setHorizontalTextPosition(JLabel.LEFT);

        krish_label.setForeground(Color.blue);
        Rafee_label.setForeground(Color.green);

        Rafee_label.setVerticalAlignment(JLabel.TOP);
        krish_label.setVerticalAlignment(JLabel.BOTTOM);

        // JFrame = a GUI to add components to
        JFrame frame = new JFrame();// creates a frame
        frame.setSize(500, 500);// Sets the x-dimension , and y-dimension of frame.
        frame.setTitle("Chekto");// set title of frame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // make frame visible.

        ImageIcon image = new ImageIcon("Rfee.jpg"); // create an ImageIcon.
        frame.setIconImage(image.getImage()); // change icon of frame.
        frame.getContentPane().setBackground(Color.BLACK);// Change color of background.
        
        frame.add(krish_label);
        frame.add(Rafee_label);

    }
}