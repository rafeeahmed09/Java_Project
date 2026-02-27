import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Buttons {


    public static void main(String[] args) {
    ImageIcon img = new ImageIcon("Rfee.jpg");

        // JButton = A Button that performs an action when clicked on.


        JButton Button = new JButton();
        Button.setText("I am button");
        Button.setBounds(200, 200, 150, 75);
        Button.setFocusable(false);
        Button.addActionListener(e->{
            System.out.println("button clicked");
        });

        Button.setIcon(img);


        JButton close = new JButton();
        close.setText("Close");
        close.setBounds(400, 400, 150, 75);
        close.setFocusable(false);
        close.addActionListener(e->{
            

            // System.out.println("button clicked");
        });




        JFrame frame = new JFrame();// creates a frame
        frame.setSize(500, 500);// Sets the x-dimension , and y-dimension of frame.
        frame.setTitle("Chekto");// set title of frame.
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // make frame visible.
        frame.add(Button);
        frame.add(close);
    }


}