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

public class Game {
    private Timer timer;
    private GameRender gameRender;
    //renderable game objects
    private Snake snake;
    private Point cherry;
    private Point extraLife;
    private int points = 0;
    private int[] best = new int[10]; // best score is last
    private int extraLives =0;
    private int newCherries =0;


    private GameStatus status;





    private static Font FONT_M = new Font("ArcadeClassic", Font.PLAIN, 24);
    private static Font FONT_M_ITALIC = new Font("ArcadeClassic", Font.ITALIC, 24);
    private static Font FONT_L = new Font("ArcadeClassic", Font.PLAIN, 84);
    private static Font FONT_XL = new Font("ArcadeClassic", Font.PLAIN, 150);
    private static int WIDTH = 760;
    private static int HEIGHT = 520;
    private static int DELAY = 50;
    //private static Game _instance = null;

    public Game() {
        gameRender = new GameRender(this, new KeyListener());
        //TODO game objects
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        status = GameStatus.NOT_STARTED;
    }
/*
    public static Game getInstance() {
        if(_instance == null) {
            _instance = new Game();
        }
        return _instance;
    }

 */

    public GameRender getGameRender() {
        return gameRender;
    }

    public Snake getSnake() {
        return snake;
    }

    public Point getCherry() {
        return cherry;
    }

    public Point getExtraLife() {
        return extraLife;
    }
    public int getPoints() {
        return points;
    }
    public int getExtraLives() {
        return  extraLives;
    }

    public GameStatus getStatus() {
        return status;
    }

    public int[] getBest() {
        return best;
    }

    //TODO Game logic
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

    //TODO Game logic
    private void reset() {
        points = 0;
        cherry = null;
        extraLife = null;
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        setStatus(GameStatus.RUNNING);
    }
    //TODO Game logic
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
    //TODO Game logic
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

    //TODO Game logic
    private void togglePause() {
        setStatus(status == GameStatus.PAUSED ? GameStatus.RUNNING : GameStatus.PAUSED);
    }
    //TODO Game logic
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
    //TODO game logic
    public void spawnCherry() {
        cherry = new Point((new Random()).nextInt(WIDTH - 60) + 20,
                (new Random()).nextInt(HEIGHT - 60) + 40);
    }

    //TODO game logic
    public void spawnExtraLife(){

        extraLife = new Point((new Random()).nextInt(WIDTH - 60) + 20,
                (new Random()).nextInt(HEIGHT - 60) + 40);

    }
    //TODO game mixed with Rendering but correctly (asks for render)
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
            if (status == GameStatus.NOT_STARTED)
                setStatus(GameStatus.RUNNING);
            if (status == GameStatus.GAME_OVER && key == KeyEvent.VK_ENTER)
                reset();
            if(key == KeyEvent.VK_R && status == GameStatus.PAUSED)
                reset();
            if (key == KeyEvent.VK_P) {
                togglePause();
                gameRender.repaint();
            }
        }
    }
    //TODO game mixed with Rendering but correctly (asks for render)
    private class GameLoop extends java.util.TimerTask {
        public void run() {
            update();
            gameRender.repaint();
        }
    }
}
