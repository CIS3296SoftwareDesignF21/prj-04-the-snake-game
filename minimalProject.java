import javax.swing.*;
import java.awt.*;

public class minimalProject{

    public static void main(String args[]){
        JFrame frame = new JFrame("Hello World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        // everyone add a contribution

        frame.add(new JLabel("Hello World - Olivia, Casey "), BorderLayout.CENTER); //just added my name to the Jlabel
      
        frame.add(new JLabel("Hello World - Sophia"), BorderLayout.CENTER);

        frame.getContentPane().setBackground(Color.GREEN);//I made the background green - Cole

        // I centered the Jframe on the screen - Grant
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension size = toolkit.getScreenSize();
        frame.setLocation((size.width - frame.getWidth())/2, (size.height - frame.getHeight())/2);

        frame.setVisible(true);

    }



}
