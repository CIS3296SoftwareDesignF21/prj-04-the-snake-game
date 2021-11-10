import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
import javax.imageio.*;
import javax.swing.*;

public class Game extends JPanel {
    private Timer timer;
    private Snake snake;
    private Point cherry;
    private Point extraLife;
    private int points = 0;
    private int[] best = new int[10]; // best score is last
    private int extraLives =0;
    private int newCherries =0;
    private BufferedImage image;
    private BufferedImage extraLifeImage;
    private GameStatus status;
    private boolean didLoadCherryImage = true;
    private boolean didLoadExtraLife = true;


    private static Font FONT_M = new Font("ArcadeClassic", Font.PLAIN, 24);
    private static Font FONT_M_ITALIC = new Font("ArcadeClassic", Font.ITALIC, 24);
    private static Font FONT_L = new Font("ArcadeClassic", Font.PLAIN, 84);
    private static Font FONT_XL = new Font("ArcadeClassic", Font.PLAIN, 150);
    private static int WIDTH = 760;
    private static int HEIGHT = 520;
    private static int DELAY = 50;

    public Game() {
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
        addKeyListener(new KeyListener());
        setFocusable(true);
        setBackground(Color.black);
        setDoubleBuffered(true);

        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        status = GameStatus.NOT_STARTED;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        render(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void update() {
        snake.move();

        if (cherry != null && snake.getHead().intersects(cherry, 20)) {
            snake.addTail();
            cherry = null;
            points++;
        }

        if(extraLife !=null && snake.getHead().intersects(extraLife,20)){
            if(extraLives < 3){
                extraLives +=1;
            }
            extraLife = null;
        }

        if(extraLife ==null && extraLives < 3 && newCherries %15 ==0 && newCherries !=0){
            spawnExtraLife();
            newCherries+=1;
        }
        if (cherry == null) {
            newCherries +=1;
            spawnCherry();
        }

        checkForGameOver();
    }

    private void reset() {
        points = 0;
        cherry = null;
        extraLife = null;
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        setStatus(GameStatus.RUNNING);
    }

    private void extraLife(){
        setStatus(GameStatus.EXTRA_LIFE);
        cherry = null;
        extraLife = null;
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        //do we want the snake to have the long tail still once extra live starts??
        //  for(int i =0;i<theSize;i++){
        //    snake.addTail();
        //}
        setStatus(GameStatus.RUNNING);
    }

    private void setStatus(GameStatus newStatus) {
        switch(newStatus) {
            case EXTRA_LIFE:
                timer.cancel();
                break;
            case RUNNING:
                timer = new Timer();
                timer.schedule(new GameLoop(), 0, DELAY);
                break;
            case PAUSED:
                timer.cancel();
                break;
            case GAME_OVER:
                timer.cancel();
                for(int i = best.length-1; i >=0 ; i--) {
                    if(points == best[i])
                        break;
                    if(points > best[i]) {
                        best[0] = points;
                        Arrays.sort(best);
                        break;
                    }
                }

                break;
        }

        status = newStatus;
    }

    private void togglePause() {
        setStatus(status == GameStatus.PAUSED ? GameStatus.RUNNING : GameStatus.PAUSED);
    }

    private void checkForGameOver() {

        Point head = snake.getHead();
        boolean hitBoundary = head.getX() <= 20
                || head.getX() >= WIDTH + 10
                || head.getY() <= 40
                || head.getY() >= HEIGHT + 30;

        boolean ateItself = false;

        for(Point t : snake.getTail()) {
            ateItself = ateItself || head.equals(t);
        }


        if (hitBoundary || ateItself) {
            if(extraLives >0){
                extraLives -=1;
                extraLife();
            }else {
                setStatus(GameStatus.GAME_OVER);
            }
        }

    }

    public void drawCenteredString(Graphics g, String text, Font font, int y) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = (WIDTH - metrics.stringWidth(text)) / 2;

        g.setFont(font);
        g.drawString(text, x, y);
    }

    private void render(Graphics g) {
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
        g2d.drawString("BEST: " + String.format ("%04d", best[best.length-1]), 660, 30);

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
            renderEndGame(g2d);

        }

        if (status == GameStatus.PAUSED) {
        	drawCenteredString(g2d, "Paused", FONT_L, 300);
        	drawCenteredString(g2d, "Press R to restart", FONT_M_ITALIC, 330);
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
    public void renderEndGame(Graphics2D g2d) {
        drawCenteredString(g2d, "Press  enter  to  start  again ", FONT_M_ITALIC, 140);
        drawCenteredString(g2d, "GAME OVER", FONT_L, 110);
        drawCenteredString(g2d, "Best Scores:", FONT_M, 170);
        System.out.println(best[0]);
        for(int i = best.length-1; i >=0 ; i--) {
            String score = (best.length - i) + ". "  + best[i];
            System.out.println(score);
            drawCenteredString(g2d, score, FONT_M, 425 - i*25);
        }
    }

    public void spawnCherry() {
        cherry = new Point((new Random()).nextInt(WIDTH - 60) + 20,
                (new Random()).nextInt(HEIGHT - 60) + 40);
    }

    public void spawnExtraLife(){

        extraLife = new Point((new Random()).nextInt(WIDTH - 60) + 20,
                (new Random()).nextInt(HEIGHT - 60) + 40);

    }

    private class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (status == GameStatus.RUNNING) {
                switch(key) {
                    case KeyEvent.VK_LEFT: snake.turn(Direction.LEFT); break;
                    case KeyEvent.VK_RIGHT: snake.turn(Direction.RIGHT); break;
                    case KeyEvent.VK_UP: snake.turn(Direction.UP); break;
                    case KeyEvent.VK_DOWN: snake.turn(Direction.DOWN); break;
                }
            }

            if (status == GameStatus.NOT_STARTED) {
                setStatus(GameStatus.RUNNING);
            }

            if (status == GameStatus.GAME_OVER && key == KeyEvent.VK_ENTER) {
                reset();
            }

          //Reset
            if(key == KeyEvent.VK_R && status == GameStatus.PAUSED) {
            	 reset();
             	 
            }

            if (key == KeyEvent.VK_P) {
                togglePause();
                repaint();
            }
        }
    }

    private class GameLoop extends java.util.TimerTask {
        public void run() {
            update();
            repaint();
        }
    }


}
