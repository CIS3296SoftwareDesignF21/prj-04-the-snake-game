# Snake Game
###Week 3 Readme ### Trello Board
https://trello.com/b/ONII9TYC/snake-game-project

### Contributors:

Olivia Felmey

Cole Fitzpatrick

Grant Gwiazdowski

Casey Maloney

Sophia Szczepanek

## Project Abstract

Snake is a game where the purpose is for the player to maneuver a line that grows in length.

### How Does The Game Work?
The snake will always start at the center of the board, moving up. The snake moves at a constant speed and can only move in four directions: Up, Down, Left, and Right. The arrow keys by the player control the movement of the snake. The snake grows by eating "apples." These apples appear at random times, lasting a random amount of time. This time interval is typically long enough for the snake to get to the apple. There can only be one apple that appears at a time. When the snake runs into the apple or "eats" the apple, it gets longer. The game continues until the snake dies. The snake dies in two ways: running into the edge of the board and running into its tail. The score at the end of the game is based on how many apples have been eaten. The game continuously gets more challenging as the snake gets bigger.

[![Picture1](https://user-images.githubusercontent.com/77736692/135774237-a5ac5a09-7836-4851-b801-d22fedbdaf86.png)](https://user-images.githubusercontent.com/77736692/135774237-a5ac5a09-7836-4851-b801-d22fedbdaf86.png)

[![Picture1](https://user-images.githubusercontent.com/77736692/135774241-689632d8-8427-4d84-a0f9-f2489b1bed58.gif)](https://user-images.githubusercontent.com/77736692/135774241-689632d8-8427-4d84-a0f9-f2489b1bed58.gif)

### Goal Of The Game: The goal of the game is to eat as many apples as the snake can before dying. Remember, the snake gradually gets longer the more apples it consumes, so you have to be careful not to hit its tail!

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

2. Download the .jar file from the latest [release](https://github.com/renanpvaz/java-snake/releases).

3. Inside the folder where the downloaded .jar is run:

```  
java -jar snake.jar  
```  

## New Ideas to the Game
1. Implement the game using threads: the direction of the snake and testing for collisions.
2. Crete a Test Model class for the game itself. Thinging about using Junit testing. This is to keep track of the high scores.
3. Add obstacles that pop up to kill the snake. Now the snake can die in three ways. Hitting a wall, hitting its own tail, or hitting this obstacle.
4. Adding a face to the snake. This will help see the snake better at what end its eatting the apple.
5. Increasing the speed of the snake. As the snake eats more apples the snake will increase the speed making the game harder as you go on.
6. Provide a scoreboard at the end of the game.
7. Change the menu screen when the game finishes to re-start the game.
8. Adding keys to pause, restart, or resume the game.
9. Adding tokens the snake can eat to give it extra lives. The total lives you can get is three. This allows you to keep playing the same game even when the         snake died.
10. Implements different modes to the game. The player can choose between beginner, intermediate, or expert.
11. Implements different tokens in the game. One to slow down the snake for a period of time, one to go fast and nothing will kill it, etc.

## Vision Statement

```  
“For people off all ages who need an easy but challenging game, The Snake Game is a Java-based game that engages users by having a point-based system which rewards them as they play  
 and adds obstacles and speed to improve difficulty of the game. Unlike the retro/original version of the Snake Game, our Snake Game provides a simple interface with improved gameplay that utilizes multi-threading processes for the collisions and direction of the snake.”  
  
```  


## Personas

#### _Persona 1_ (Olivia Felmey)

```  
Sean, College Student   
Sean, age 21, is a college student (Senior) at Temple University in Philadelphia, PA. He majors in Graphic Design at The Tyler School of Art where he uses his creativity to create and design interesting visual concepts using computer software. He was raised in a small town where him and his group of friends played a lot of video games together growing up to pass the time.  
  
Sean’s experience throughout his education of graphic design means he is interested in looking into creative and fun technology/games. His passion and love of video games also keeps him interested in exploring new types of online games which are visually pleasing yet also challenging due to his large amount of knowledge of video games. He will use the snake game to challenge himself to harder gameplay with the new upgrades that  
have been implemented to the classic game; As well as enjoy the visually pleasing aesthetics that have been added.  
The new feature added of being able to collect extra lives allows him to play this challenging game for a longer amount  
of time, which he enjoys compared to the video games he is usually used to.  
  
```  
#### _Persona 2_ (Casey Maloney)
```  
Billy, A Young Highschool Student  
  
Billy, age 15, is a highschool student in Philadelphia, PA. Billy spends most of his free time playing video games at home. He's super creative and loves to challenge himself with new games. He one of three kids, and loves to play games with his siblings. During his other time Billy tends to get bored easily and can't sit still for a  
long period of time. He always likes to be doing something thats fun and visually pleasing. Most of the time when he's not playing video games, he outside playing with his friends and family.   
Billy is pretty decent at video games, but is not expert. He really likes games that are fun but challenging. The more he plays a game the better he gets. During school Billy just wants to play a game thats simple but also where he can still  
listen to the teacher. Billy just doesn't want to be bored out of his mind. The Snake Game will help his accomplish this. The Snake Game can help Billy be attentive in class, but also have fun. The game will be able to challenge Billy's mind. This game is perfect for all ages and Billy will be able to play, and continue to get better.   
```  
#### _Persona 3_
```  
Betty, a mom with kids   
Betty is a woman, 40, with kids. She is somewhat experienced with technology but does not want to use a gaming console/controllers because she believes they are too complicated. She knows her kids enjoy playing video games but the ones they play are too overstimulating with their colorful interfaces and complicated gameplay. She feels that playing a new version of a game she liked previously will connect her with technology, as well as feel connected with her kids.  
  
Betty is looking to play a retro game with a new feel. She remembers playing earlier versions of the Snake game but wants to explore a newer version. Older versions of the game had only one speed of the game with only two ways to die: either running into the wall or running into itself. This new version of the game will include an easy interface to interact with and added obstacles to make the game increasingly difficult. The controls for the game are only the arrow keys plus some keys to access the menu options so this will be perfect for her needs.  
  
```  
#### _Persona 4_ (Cole Fitzpatrick)
```  
Agatha, A Retired Teacher  
  
Agatha Jones, age 74, is a retiree from Denver, Colorado. She taught at Great Willow elementary for 45 years before  
retiring to her coastal home that she shares with her husband in San Diego. She has had a full life so far, graduating from Regis University, raising 3 kids, and winning the Denver holiday baking competition from 2005 to 2018 (and would’ve won in 2019 if it wasn’t for her arthritis). Now she simply wants to sit back, relax, and maybe give a call to her oldest about when she's going to finally become a grandma.  
  
Agatha’s doctor has given her the unique recommendation of playing video games to keep her hands dexterous in the later  
years of her life. She knows how to work a computer due to her work as a teacher, but isn’t adept in playing games on it.  
She has an interest in playing the Snake Game due to it’s simplistic nature as well as having a nice tutorial page that tells her how to play.  
  
```  
#### _Persona 5_ (Grant Gwiazdowski)

```  
  
Jenni, age 7, is a young girl from Austin, Texas. She just started first grade, where she has proven herself to be rather intelligent and clever for her age. She spends most of her free time playing with legos by herself or with her mom, a civil engineer. Her Dad, a technical artist, has been bonding with her by sharing his love of video games with her. He has been introducing her to some simple retro games to try not overwhelm her with modern games that expect more experienced players that grasp common video game patterns.   
Jenni, however, quickly masters the basics of most games and just as quickly finds the games too easy. Jenni wants to try harder games but her dad doesn't want it to be to hard for her. So Her dad wants to have her play a game that has difficulty modes that let them set the difficulty so it's not to hard and she doesn't get bored. The snake game, an updated version of the retro classic, Snake, which lets Jenni choose how hard the game is, letting her learn the basics on easier modes and changing to hard modes as she gets better.  
  
```  

### Class Diagram

[![Picture1](https://github.com/CIS3296SoftwareDesignF21/prj-04-the-snake-game/blob/main/SnakeClassDiagram.jpg?raw=true)

In our UMl we have 5 main classes: Point, Snake, Game, GameRender, and Main. We also have two enumerations in our diagram: Game status, direction. The enumeration classses are just a list of name constants.

#### GameStatus
GameStatus just tells us the different types of condition the game is currently at.   
We currently have four conditions for the game: Not_STARTED, RUNNING, PAUSED, GAME_OVER.

When the status is at NOT_STARTED the game hasn't started running yet. This is either the homescreen or when the game is over and the player can restart. RUNNING status just mean when the player is playing the game. PAUSE status is when the player stops the game momentarily, and same resume the game whenever they are ready. GAME_OVER tells is when the player has died in the game.

#### Direction
Direction class just tells us which way the snake will move on the board. Bascially the whole board is a graph with x and y axes. The snake can move in four different ways. Left, right, up, or down. This is controled by the arrow keys.

The methods isX() and isY() just helps us tell the direction of the snake on the axis. With isX() being the horizontal movements and isY() being the vertical movements.

#### Snake
Snake class had four different methods implemented in it. Snake, which takes in two ints as the paramerters, move, addtail, and turn, which takes in the direction of the snake as a parameter.

Addtail method just adds a "block" to the snakes body. This method is what makes the snake longer as the snake eats more apples.

Move method is just the tells the snake what direction to move in. It uses an array list to get the cordinates of the snake and change them in the direction it was given.

Turn will update the direction that the snake is turning.

Snake method is creating the snake for the beginning of the game. Its adding to the tail for the base length, and the snake is starting at the center of the board, moving right.

#### Main
Main class is our main method.   
Its created our visibility to the game true and calls another main method, to print the snake title, creates the size of the board, and starts the snake game.

#### Game
The Game class is our biggest one. It involved the basics of the game and how the game works. There are currently 10 different methods within this class. In the Game class there are also two seperate other classes. The KeyListener and GameLoop class within the Game class.

Game() makes a new snake, and a new GameRender object that is passed a keyListener.  It sets the status of the game to NOT_RUNNING.

Update() is updating the snake as the game proccedes. It acts as the main logical updater of the game, checking if it all conditions are met to be in the current Game status of the Game and its objects. It moves the snake, and checks whether or not the snake head has hit the apple. It will then call to add to the tail and also checks whether the snake head has hit a collison and died.

reset() reset the game, and restarts it from the base snake length and position.

setStatus() is a method that sets the status of the game. Remember the status of our current game is either NOT_STARTED, RUNNING, PAUSED, or GAME_OVER. It switched the status between the four as the game starts, running, or ends.

TogglePause() is the pause method, that when called it pauses the game.

checkforGameOver() is a method that check for collisions. There are two different things that will kill the snake: if it hit a boundary, if it hit its own tail. It checks whether the snake has done either one of those collisions and will end the game into the status GAME_OVER.

spawnCherry() is the method that displays the "apples" at random.

The Keylistener class is "listening" to what key is pressed on the keyboard. Its basically listening to the direction that is being inputted from the player to help tell where the snake to move. It is also listening to the pause button and when to start the game.

GameLoop class is updated the game as it is running. The game is one big loop, until the snake dies. This class is called to have the game continually running in one big loop.

#### GameRender
A game object GameRender is responsible for changing the graphics on the screen when Game runs update() or at Game initialization. It reads image the image for the apple, and sets the background color.

Render() is the biggest method in this class. It is the primary graphics rendering function of the class. When Game updates the actual location of things to be displayed, Game render then shows that update on the GUI, Displaying the movement of the snake move, having the apples appear, and more.

PaintComponent() calls render to run the game and prints the graphics on the screen.

DrawCenteredString() just creates graphics text and centers the graphics on the board.

#### Point
The point class is what the snake is made up of. It creates the parts of the snake and allows the snake to move.


### Sequence Diagram

<img width="878" alt="Screen Shot 2021-11-16 at 7 49 25 PM" src="https://user-images.githubusercontent.com/77749807/142089214-119aaaac-a0ae-4bf8-a4d7-9c776ec9c116.png">  

First the user will run Main. This will then call the class initUI() to start a new Game. Game will then addKeyListener() to start the KeyListener class. The KeyListener listens for the key strokes of the user to start the game after the user selects a game mode, to move the snake in different directions, and to pause the game. The KeyListener sets the Game Status to the RUNNING state. Game also creates a new Snake. PaintComponent allows the graphics to be made and calls render(), which draws all the graphics, sets colors and creates text for the Game

When the SetStatus is in the Running state, it will start a new GameLoop to update and repaint the Game as it runs. GameLoop calls update() which starts the Snake’s movement through move(). It also begins the updates of the game like when the snake eats a cherry, the snake gains a segment of its tail. It also updates when you gain an extra life, spawning cherries, lives and obstacles. Lastly, it’ll check to see if the game is over. CheckForGameOver checks if the snake hits itself, the boundary, or an obstacle. If it does, then it changes the SetStatus to Game_Over. KeyListener then waits for the user to press the enter key or the pause and reset keys to reset the game. Reset() resets points, lives, cherries, obstacles, then makes a new snake and setStatus to RUNNING. Finally, CheckForGameOver calls renderEndGame which displays the scoreboard.