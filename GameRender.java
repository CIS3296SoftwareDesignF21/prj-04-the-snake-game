import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameRender extends JPanel {

    private Game game;
    private BufferedImage image;
    private BufferedImage extraLifeImage;

    private boolean didLoadCherryImage = true;
    private boolean didLoadExtraLife = true;

    private static Font FONT_M = new Font("ArcadeClassic", Font.PLAIN, 24);
    private static Font FONT_M_ITALIC = new Font("ArcadeClassic", Font.ITALIC, 24);
    private static Font FONT_L = new Font("ArcadeClassic", Font.PLAIN, 84);
    private static Font FONT_XL = new Font("ArcadeClassic", Font.PLAIN, 150);
    public static final int WIDTH = 760;
    public static final int HEIGHT = 520;


    public GameRender(Game game, KeyListener keyListener) {
        this.game = game;
        try {
            image = ImageIO.read(new File("cherry.png"));
        } catch (IOException e) {
            didLoadCherryImage = false;
        }
        try{
            extraLifeImage = ImageIO.read(new File(".png"));
        }catch(IOException e){
            didLoadExtraLife = false;
        }
        this.addKeyListener(keyListener);
        this.setFocusable(true);
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Snake snake = game.getSnake();
        Point cherry = game.getCherry();
        Point extraLife = game.getExtraLife();
        int points = game.getPoints();
        GameStatus status = game.getStatus();
        int extraLives = game.getExtraLives();
        int[] best = game.getBest();

        render(g,snake, cherry, extraLife, points, status, extraLives, best);

        Toolkit.getDefaultToolkit().sync();
    }

    private void render(Graphics g, Snake snake, Point cherry, Point extraLife, int points, GameStatus status, int extraLives, int[] best) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(53, 220, 8));
        g2d.setFont(FONT_M);

        if (status == GameStatus.NOT_STARTED) {
            drawCenteredString(g2d, "SNAKE", FONT_XL, 200);
            drawCenteredString(g2d, "GAME", FONT_XL, 300);
            drawCenteredString(g2d, "Press  any  key  to  begin ", FONT_M_ITALIC, 330);

            return;
        }

        Point p = snake.getHead();

        g2d.drawString("SCORE: " + String.format ("%04d", points), 20, 30);
        g2d.drawString("EXTRA LIVES: " + extraLives,320,30);
        g2d.drawString("BEST: " + String.format ("%04d", best[best.length-1]), 650, 30);

        if (cherry != null) {
            if (didLoadCherryImage) {
                g2d.drawImage(image, cherry.getX(), cherry.getY(), 60, 60, null);
            } else {
                g2d.setColor(Color.RED);
                g2d.fillOval(cherry.getX(), cherry.getY(), 10, 10);
                g2d.setColor(new Color(53, 220, 8));
            }
        }
        if(extraLife!=null){
            if(didLoadExtraLife){
                g2d.drawImage(extraLifeImage,extraLife.getX(),extraLife.getY(),60,60,null);
            }else {
                g2d.setColor(Color.GREEN);
                g2d.fillOval(extraLife.getX(),extraLife.getY(),10,10);
                g2d.setColor(new Color(53,220,8));
            }
        }


        if (status == GameStatus.GAME_OVER) {
            renderEndGame(g2d, best);
        }
        if (status == GameStatus.PAUSED) {
            renderPaused(g2d);
        }
        g2d.setColor(new Color(245, 3, 52));
        g2d.fillRect(p.getX(), p.getY(), 10, 10);
        g2d.setColor(new Color(74, 245, 14));
        g2d.fillRect(p.getX(), p.getY(), 10, 10);
        for(int i = 0, size = snake.getTail().size(); i < size; i++) {
            Point t = snake.getTail().get(i);
            g2d.setColor(new Color(71, 128, 0));
            g2d.fillRect(t.getX(), t.getY(), 10, 10);
        }
        g2d.setColor(new Color(71, 128, 0));
        g2d.setStroke(new BasicStroke(4));
        g2d.drawRect(20, 40, WIDTH, HEIGHT);
    }

    public void drawCenteredString(Graphics g, String text, Font font, int y) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = (WIDTH - metrics.stringWidth(text)) / 2;
        g.setFont(font);
        g.drawString(text, x, y);
    }

    public void renderEndGame(Graphics2D g2d, int[] best) {
        drawCenteredString(g2d, "Press  enter  to  start  again ", FONT_M_ITALIC, 140);
        drawCenteredString(g2d, "GAME OVER", FONT_L, 110);
        drawCenteredString(g2d, "Best Scores:", FONT_M, 170);
        for(int i = best.length-1; i >=0 ; i--) {
            String score = (best.length - i) + ". "  + best[i];
            drawCenteredString(g2d, score, FONT_M, 425 - i*25);
        }
    }

    public void renderPaused(Graphics2D g2d) {
        drawCenteredString(g2d, "Paused", FONT_L, 300);
        drawCenteredString(g2d, "Press R to restart", FONT_M_ITALIC, 330);
    }

}
