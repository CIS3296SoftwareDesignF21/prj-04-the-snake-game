import javax.swing.*;
import java.awt.*;

public class minimalProject{

    public static void main(String args[]){
        JFrame frame = new JFrame("Hello World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        // everyone add a contribution
        frame.add(new JLabel("Hello World - Olivia"), BorderLayout.CENTER);

        frame.setVisible(true);

    }



}