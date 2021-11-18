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
    private Point obstacle1;
    private Point obstacle2;
    private Point obstacle3;
    private int points = 0;
    private int[] best = new int[10]; // best score is last
    private int extraLives =0;
    private int newCherries =0;
    private GameStatus status;
    private int key;
    private int speed = 7;
    private boolean extracherry= false;
    private GameMode mode;










    private static int DELAY = 50;


    public Game() {
        gameRender = new GameRender(this, new KeyListener());
        resetSnake();
        status = GameStatus.NOT_STARTED;
    }


    //change the update method to have move take in a parameter to increase
    private void update() {

        snake.move(speed);


        if (cherry != null && snake.getHead().intersects(cherry, 20)) {
            snake.addTail();
            cherry = null;
            points++;
            extracherry= true;




            //this increases the speed as the snake eats more apples- but for some reason when I implement
            //anything i try it doesnt change the speed when you implement the mode




        }

       if (mode == GameMode.MEDIUM || mode == GameMode.HARD) {
        if(extraLife !=null && snake.getHead().intersects(extraLife,20)){
            if(extraLives < 3){
                extraLives +=1;
            }
            extraLife = null;
        }

        if(extraLife ==null && extraLives < 3 && newCherries % 15==0 && newCherries !=0){
            spawnExtraLife();
            newCherries+=1;
        }


        }


        if (cherry == null) {
            newCherries +=1;
            spawnCherry();
        }

        if(obstacle1 ==null){
            spawnObstacle();
        }
        if (extracherry) {
            if (mode == GameMode.HARD) {
                speed++;
                extracherry= false;
            }

        }


        checkForGameOver();
    }



    private void reset() {
        points = 0;
        cherry = null;
        extraLife = null;
        obstacle1=obstacle2=obstacle3 = null;
        resetSnake();
        //i dont want reset to re-start the game and set the status to running
        //i want to call render or main to print the home screen to set the difficulty level
        //render();
        setStatus(GameStatus.RUNNING);
        speed = 7;




    }
    private void resetSnake() {
        snake = new Snake(GameRender.WIDTH / 2, GameRender.HEIGHT / 2);
    }

    private void extraLife(){
        setStatus(GameStatus.EXTRA_LIFE);
        cherry = null;
        extraLife = null;
        obstacle1 = obstacle2 = obstacle3=null;
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

    private void setGameMode(GameMode newStatus) {

        switch(newStatus) {
            case EASY:
                setStatus(GameStatus.RUNNING);
                break;
            case MEDIUM:
                setStatus(GameStatus.RUNNING);
                break;
            case HARD:
                setStatus(GameStatus.RUNNING);
                break;



        }

        mode = newStatus;
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
        boolean hitObstacle = false;

        for(Point t : snake.getTail()) {
            ateItself = ateItself || head.equals(t);
        }

        if(obstacle1!=null && snake.getHead().intersects(obstacle1,20) || obstacle2!=null && snake.getHead().intersects(obstacle2,20) || obstacle3!=null && snake.getHead().intersects(obstacle3,20)){
            obstacle1 = obstacle2 =obstacle3=null;
            hitObstacle = true;
        }

        if (hitBoundary || ateItself || hitObstacle) {
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
        //so cherry does not spawn directly under obstacle
        if(cherry == obstacle1 ||cherry == obstacle2 || cherry == obstacle3){
            spawnCherry();
        }

    }

    public void spawnExtraLife() {


        extraLife = new Point((new Random()).nextInt(GameRender.WIDTH - 60) + 20,
                (new Random()).nextInt(GameRender.HEIGHT - 60) + 40);
            if (extraLife == obstacle1 || extraLife == obstacle2 || extraLife == obstacle3) {
                spawnExtraLife();
            }



    }



    public void spawnObstacle(){
        //hard mode gets obstacles
        if(mode== GameMode.MEDIUM || mode == GameMode.HARD) {

            obstacle1 = new Point((new Random()).nextInt(GameRender.WIDTH - 60) + 20,
                    (new Random()).nextInt(GameRender.HEIGHT - 60) + 40);
            obstacle2 = new Point((new Random()).nextInt(GameRender.WIDTH - 60) + 20,
                    (new Random()).nextInt(GameRender.HEIGHT - 60) + 40);
            obstacle3 = new Point((new Random()).nextInt(GameRender.WIDTH - 60) + 20,
                    (new Random()).nextInt(GameRender.HEIGHT - 60) + 40);
        }


    }

    private class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            key = e.getKeyCode();

            if (status == GameStatus.RUNNING) {
                switch(key) {
                    case KeyEvent.VK_LEFT: snake.turn(Direction.LEFT); break;
                    case KeyEvent.VK_RIGHT: snake.turn(Direction.RIGHT); break;
                    case KeyEvent.VK_UP: snake.turn(Direction.UP); break;
                    case KeyEvent.VK_DOWN: snake.turn(Direction.DOWN); break;
                }
            }

            //not sure what this does exactly
            //if (status == GameStatus.NOT_STARTED) {
             //   setStatus(GameStatus.RUNNING);
          //  }
            // easy mode
            //this mode is the basic game- the original code with no extra lives or obstacles or speed increase
            if (status == GameStatus.NOT_STARTED && key == KeyEvent.VK_E) {
                    //
                   setGameMode(GameMode.EASY);

            }

            //medium mode
            //this mode has the obstacles and extra lives
            if (status == GameStatus.NOT_STARTED && key == KeyEvent.VK_M) {
            //
                setGameMode(GameMode.MEDIUM);

            }

            //hard mode
            //hard mode is the speed increase, with obstacles, and extra lives
            if (status == GameStatus.NOT_STARTED && key == KeyEvent.VK_H) {
            //
                setGameMode(GameMode.HARD);

            }



            if (status == GameStatus.GAME_OVER && key == KeyEvent.VK_ENTER) {

                //I want to change this where they dont have to hit enter to restart the game
                //i need it to go back to the home page

                reset();

            }

          //Reset
            if(key == KeyEvent.VK_R && status == GameStatus.PAUSED) {
            	 reset();
             	 
            }

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
     public Point getObstacle1() {
        return obstacle1;
    }
    public Point getObstacle2() {
        return obstacle2;
    }
    public Point getObstacle3() {
        return obstacle3;
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
    public void setBest(int[] newbest) {
		this.best = newbest;
    	
    }

}
