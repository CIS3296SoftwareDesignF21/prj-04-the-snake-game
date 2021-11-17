import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GameRender extends JPanel {

    private Game game;
    private BufferedImage image;
    private BufferedImage extraLifeImage;
    private BufferedImage obs;

    private boolean didLoadObstacle = true;
    private boolean didLoadCherryImage = true;
    private boolean didLoadExtraLife = true;

    private static Font FONT_M = new Font("ArcadeClassic", Font.PLAIN, 24);
    private static Font FONT_M_ITALIC = new Font("ArcadeClassic", Font.ITALIC, 24);
    private static Font FONT_L = new Font("ArcadeClassic", Font.PLAIN, 84);
    private static Font FONT_XL = new Font("ArcadeClassic", Font.PLAIN, 150);
    public static final int WIDTH = 760;
    public static final int HEIGHT = 520;
	public int[] best = new int[10];


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
        try{
            obs = ImageIO.read(new File("obstacle.png"));
        }catch(IOException e){
            didLoadObstacle = false;
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

        render(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        GameStatus status = game.getStatus();
        Snake snake = game.getSnake();
        Point cherry = game.getCherry();
        Point extraLife = game.getExtraLife();
        Point obstacle1 = game.getObstacle1();
        Point obstacle2 = game.getObstacle2();
        Point obstacle3 = game.getObstacle3();
        int extraLives = game.getExtraLives();
        int points = game.getPoints();

        g2d.setColor(new Color(53, 220, 8));
        g2d.setFont(FONT_M);

        if (status == GameStatus.NOT_STARTED) {
            drawCenteredString(g2d, "SNAKE", FONT_XL, 200);
            drawCenteredString(g2d, "GAME", FONT_XL, 300);
            drawCenteredString(g2d, "Please press your key for your difficulty level", FONT_M_ITALIC, 330);
            drawCenteredString(g2d, "E: Easy M: Medium H: Hard", FONT_M_ITALIC, 360);
            ReadHighscore();
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

        if(obstacle1!=null) {
            if (didLoadObstacle) {
                g.drawImage(obs, obstacle1.getX(), obstacle1.getY(), 40, 40, null);
            } else {
                g.setColor(Color.YELLOW);
                g.fillOval(obstacle1.getX(), obstacle1.getY(), 10, 10);
            }
        }
        if(obstacle2!=null) {
            if (didLoadObstacle) {
                g.drawImage(obs, obstacle2.getX(), obstacle2.getY(), 40, 40, null);
            } else {
                g.setColor(Color.YELLOW);
                g.fillOval(obstacle2.getX(), obstacle2.getY(), 10, 10);
            }
        }
        if(obstacle3!=null) {
            if (didLoadObstacle) {
                g.drawImage(obs, obstacle3.getX(), obstacle3.getY(), 40, 40, null);
            } else {
                g.setColor(Color.YELLOW);
                g.fillOval(obstacle3.getX(), obstacle3.getY(), 10, 10);
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
        for(int i = 0, size = game.getSnake().getTail().size(); i < size; i++) {
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
    	g2d.setColor(new Color(53, 220, 8));
    	drawCenteredString(g2d, "Press  enter  to  start  again ", FONT_M_ITALIC, 140);
        drawCenteredString(g2d, "GAME OVER", FONT_L, 110);
        drawCenteredString(g2d, "Best Scores:", FONT_M, 170);
        for(int i = best.length-1; i >=0 ; i--) {
            String score = (best.length - i) + ". "  + best[i];
            drawCenteredString(g2d, score, FONT_M, 425 - i*25);
        }
        UpdateHighscore();
    }

    public void renderPaused(Graphics2D g2d) {
        drawCenteredString(g2d, "Paused", FONT_L, 300);
        drawCenteredString(g2d, "Press R to restart", FONT_M_ITALIC, 330);
    }
    private void ReadHighscore(){
		Scanner scanman;
		try {
			scanman = new Scanner(new File("highscore.txt"));
			int i = 0;
			while(scanman.hasNextInt()){
			   best[i++] = scanman.nextInt();
			}
			i--;
			int[] rev = new int[10];
			for(int j = 0; j < best.length; j++) {
				rev[j] = best[i];
				i--;
			}
			game.setBest(best);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    private void UpdateHighscore() {
    	FileWriter writer;

		try {
			writer = new FileWriter("highscore.txt");
			int len = best.length;
			for(int j = 0; j < len; j++) {
				writer.write(best[j] + "\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    }


}
