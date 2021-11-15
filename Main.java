import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main {

    private JFrame window;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main main = new Main();
                main.initUI();
                main.window.setVisible(true);
            }
        });
    }

    private void initUI() {
        JFrame j = new JFrame();
        Game game = new Game();
        j.add(game);

        j.setTitle("Snake 1.1");
        j.setSize(800, 600);

        j.setLocationRelativeTo(null);
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window = j;
    }
}
