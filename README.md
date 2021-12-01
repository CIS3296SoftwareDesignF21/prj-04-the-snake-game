

# The Snake Game

### Contributors: Olivia Felmey, Cole Fitzpatrick, Grant Gwiazdowski, Casey Maloney, Sophia Szczepanek

## Project Abstract

Snake is a game where the purpose is for the player to maneuver a line that grows in length.

### How Does The Game Work?

The snake will always start at the center of the board, moving to the right. The snake moves at a constant speed and can only move in four directions: Up, Down, Left, and Right. The arrow keys by the player control the movement of the snake. The snake grows by eating "cherries." These cherries appear at random times, lasting a random amount of time. This time interval is typically long enough for the snake to get to the cherry. There can only be one cherry that appears at a time. When the snake runs into the cherry or "eats" the cherry, it gets longer. The game continues until the snake dies. The snake dies in two ways: running into the edge of the board and running into its tail. The score at the end of the game is based on how many cherries have been eaten. The game continuously gets more challenging as the snake gets bigger.

<div align="center">  
  <img width="300" alt="Game Preview" src="Picture2.gif?raw=true">  
</div> 

<div align="center">  
  <img width="300" alt="Game Preview" src="Picture1.png?raw=true">  
</div> 


### Goal Of The Game: 

- The goal of the game is to eat as many cherries as the snake can before dying. Remember, the snake gradually gets longer the more apples it consumes, so you have to be careful not to hit its tail!

## Background

_BUILDING_

```  
 - Need to make sure you have the most up to data JDK - This source code is also using a .jar file, so make sure you have the most up-to-date one                            https://github.com/renanpvaz/java-snake/releases  
  
```  

_RUNNING_

```  
 - To run this, you need to clone the GitHub repository - Once cloned, you need to ensure you are in the folder where the .jar file is located. If not, it won't be able to run    - Once you change your directory and are in the correct folder, in the terminal, type this command   
                                      
                                    java -jar snake.jar   
                                      
- Once you hit enter, the snake game should come up, and you will be able to play.   
```  
<div align="center">  
  <img width="400" alt="Game Preview" src="preview.gif?raw=true">  
</div>  

<br>  

<div align="center">  
  Simple Snake game made for a college assignment using Java.  
</div>  

## Downloading and Running

1. In case you don't have it already, download and install the [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html).

2. Clone the repo into your IDE of choise

3. From there go into the Main Class and run from main(String() args) 


## New Ideas to the Game
1. Implement the game using threads: the direction of the snake and testing for collisions.
2. Crete a Test Model class for the game itself. Thinging about using Junit testing. This is to keep track of the high scores.
3. Add obstacles that pop up to kill the snake. Now the snake can die in three ways. Hitting a wall, hitting its own tail, or hitting this obstacle.
4. Adding a face to the snake. This will help see the snake better at what end its eatting the cherry.
5. Increasing the speed of the snake. As the snake eats more cherries the snake will increase the speed making the game harder as you go on.
6. Provide a scoreboard at the end of the game.
7. Change the menu screen when the game finishes to re-start the game.
8. Adding keys to pause, restart, or resume the game.
9. Adding tokens the snake can eat to give it extra lives. The total lives you can get is three. This allows you to keep playing the same game even when the         snake died.
10. Implements different modes to the game. The player can choose between beginner, intermediate, or expert.

## Vision Statement

<div align="center">  
  “For people off all ages who need an easy but challenging game, The Snake Game is a Java-based game that engages users by having a point-based system which rewards them as they play and adds obstacles and speed to improve difficulty of the game. Unlike the retro/original version of the Snake Game, our Snake Game provides a simple interface with improved gameplay that utilizes multi-threading processes for the collisions and direction of the snake.”  
</div>  


### Personas 

        https://github.com/CIS3296SoftwareDesignF21/prj-04-the-snake-game/blob/main/Personas.md


### UML Class Diagram 

        https://github.com/CIS3296SoftwareDesignF21/prj-04-the-snake-game/blob/main/ClassDiagram.md


### Sequence Diagrams 

        https://github.com/CIS3296SoftwareDesignF21/prj-04-the-snake-game/blob/main/SequenceDiagram.md
        
### Trello Board
        https://trello.com/b/ONII9TYC/snake-game-project
        
        
### Weekly Progress 

- WEEK1.md 

        https://github.com/CIS3296SoftwareDesignF21/prj-04-the-snake-game/blob/main/week1.md


- WEEK2.md 

        https://github.com/CIS3296SoftwareDesignF21/prj-04-the-snake-game/blob/main/week2.md


- WEEK3.md

        https://github.com/CIS3296SoftwareDesignF21/prj-04-the-snake-game/blob/main/week3.md


- WEEK4.md 

        https://github.com/CIS3296SoftwareDesignF21/prj-04-the-snake-game/blob/main/Week4.md
  


