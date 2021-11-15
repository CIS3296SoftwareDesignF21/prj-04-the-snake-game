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

    private Snake snake;
    private Point cherry;
    private Point extraLife;
    private int points = 0;
    private int[] best = new int[10]; // best score is last
    private int extraLives =0;
    private int newCherries =0;
    private GameStatus status;

    private static int DELAY = 50;

    public Game() {
        gameRender = new GameRender(this, new KeyListener());
        resetSnake();
        status = GameStatus.NOT_STARTED;
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
        resetSnake();
        setStatus(GameStatus.RUNNING);
    }
    private void resetSnake() {
        snake = new Snake(GameRender.WIDTH / 2, GameRender.HEIGHT / 2);
    }

    private void extraLife(){
        setStatus(GameStatus.EXTRA_LIFE);
        cherry = null;
        extraLife = null;
        resetSnake();
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
                || head.getX() >= GameRender.WIDTH + 10
                || head.getY() <= 40
                || head.getY() >= GameRender.HEIGHT + 30;

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
    public void spawnCherry() {
        cherry = new Point((new Random()).nextInt(GameRender.WIDTH - 60) + 20,
                (new Random()).nextInt(GameRender.HEIGHT - 60) + 40);
    }

    public void spawnExtraLife(){

        extraLife = new Point((new Random()).nextInt(GameRender.WIDTH - 60) + 20,
                (new Random()).nextInt(GameRender.HEIGHT - 60) + 40);

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

    private class GameLoop extends java.util.TimerTask {
        public void run() {
            update();
            gameRender.repaint();
        }
    }


    /*
        Getters for the fields of Game
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
}
