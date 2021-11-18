import java.awt.EventQueue;
import javax.swing.JFrame;


//trying to see if this will fix my problem

public class Main {

    public Main() {
        initUI();
    }

    public static void main(String[] args) {
        /*
            EventQueue.invokeLater(Runnable runnable) is called as to update JSwing
            components on the Event Dispatching thread. Calculations that could take a while
            should be done on a different thread (like the main thread) as to keep the GUI
            from being blocked and so unresponsive.
        */
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();

            }
        });
    }

    /*
        Just a setup of the Jframe that the Game will be displayed in
     */
    private void initUI() {
        JFrame j = new JFrame();
        Game game = new Game();


        j.setTitle("Snake 1.1");
        j.setSize(800, 600);

        j.setLocationRelativeTo(null);
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
}
