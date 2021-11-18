# The Snake Game
### Week 3 Readme

### Trello Board
        https://trello.com/b/ONII9TYC/snake-game-project

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

2. Download the .jar file from the latest [release](https://github.com/renanpvaz/java-snake/releases).

3. Inside the folder where the downloaded .jar is run:

```  
java -jar snake.jar  
```  

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

  

  
  <div align="center">  
 
 </div>  


## Personas

#### _Persona 1_ (Olivia Felmey)

<div align="center">  
 
 
Sean, College Student  
 
 
 
Sean, age 21, is a college student (Senior) at Temple University in Philadelphia, PA. He majors in Graphic Design at The Tyler School of Art where he uses his creativity to create and design interesting visual concepts using computer software. He was raised in a small town where him and his group of friends played a lot of video games together growing up to pass the time.  
  
Sean’s experience throughout his education of graphic design means he is interested in looking into creative and fun technology/games. His passion and love of video games also keeps him interested in exploring new types of online games which are visually pleasing yet also challenging due to his large amount of knowledge of video games. He will use the snake game to challenge himself to harder gameplay with the new upgrades that  
have been implemented to the classic game; As well as enjoy the visually pleasing aesthetics that have been added.  
The new feature added of being able to collect extra lives allows him to play this challenging game for a longer amount  
of time, which he enjoys compared to the video games he is usually used to.  
 
 </div>  


#### _Persona 2_ (Casey Maloney)

 
<div align="center">  
 
 
Billy, A Young Highschool Student  
 
 
  
Billy, age 15, is a highschool student in Philadelphia, PA. Billy spends most of his free time playing video games at home. He's super creative and loves to challenge himself with new games. He one of three kids, and loves to play games with his siblings. During his other time Billy tends to get bored easily and can't sit still for a  long period of time. He always likes to be doing something thats fun and visually pleasing. Most of the time when he's not playing video games, he outside playing with his friends and family.   
 
Billy is pretty decent at video games, but is not expert. He really likes games that are fun but challenging. The more he plays a game the better he gets. During school Billy just wants to play a game thats simple but also where he can still listen to the teacher. Billy just doesn't want to be bored out of his mind. The Snake Game will help his accomplish this. The Snake Game can help Billy be attentive in class, but also have fun. The game will be able to challenge Billy's mind. This game is perfect for all ages and Billy will be able to play, and continue to get better.  
 
 </div>  

#### _Persona 3_ (Sophia Szczepanek) 

<div align="center">  
 
 
Betty, a mom with kids   
 
 
 
Betty is a woman, 40, with kids. She is somewhat experienced with technology but does not want to use a gaming console/controllers because she believes they are too complicated. She knows her kids enjoy playing video games but the ones they play are too overstimulating with their colorful interfaces and complicated gameplay. She feels that playing a new version of a game she liked previously will connect her with technology, as well as feel connected with her kids.  
  
Betty is looking to play a retro game with a new feel. She remembers playing earlier versions of the Snake game but wants to explore a newer version. Older versions of the game had only one speed of the game with only two ways to die: either running into the wall or running into itself. This new version of the game will include an easy interface to interact with and added obstacles to make the game increasingly difficult. The controls for the game are only the arrow keys plus some keys to access the menu options so this will be perfect for her needs.  
  
 
 </div> 

#### _Persona 4_ (Cole Fitzpatrick)


  
  <div align="center">  
 
 
 Agatha, A Retired Teacher  
  
Agatha Jones, age 74, is a retiree from Denver, Colorado. She taught at Great Willow elementary for 45 years before  
retiring to her coastal home that she shares with her husband in San Diego. She has had a full life so far, graduating from Regis University, raising 3 kids, and winning the Denver holiday baking competition from 2005 to 2018 (and would’ve won in 2019 if it wasn’t for her arthritis). Now she simply wants to sit back, relax, and maybe give a call to her oldest about when she's going to finally become a grandma.  
  
Agatha’s doctor has given her the unique recommendation of playing video games to keep her hands dexterous in the later  
years of her life. She knows how to work a computer due to her work as a teacher, but isn’t adept in playing games on it.  
She has an interest in playing the Snake Game due to it’s simplistic nature as well as having a nice tutorial page that tells her how to play.  
 
 </div>  
 
#### _Persona 5_ (Grant Gwiazdowski)


  
  <div align="center">  
 
 Jenni, Grade School Student 
 
Jenni, age 7, is a young girl from Austin, Texas. She just started first grade, where she has proven herself to be rather intelligent and clever for her age. She spends most of her free time playing with legos by herself or with her mom, a civil engineer. Her Dad, a technical artist, has been bonding with her by sharing his love of video games with her. He has been introducing her to some simple retro games to try not overwhelm her with modern games that expect more experienced players that grasp common video game patterns.  
 
Jenni, however, quickly masters the basics of most games and just as quickly finds the games too easy. Jenni wants to try harder games but her dad doesn't want it to be to hard for her. So Her dad wants to have her play a game that has difficulty modes that let them set the difficulty so it's not to hard and she doesn't get bored. The snake game, an updated version of the retro classic, Snake, which lets Jenni choose how hard the game is, letting her learn the basics on easier modes and changing to hard modes as she gets better.  
 
 </div>  



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




### Easy Mode Use Case 

<div align="center">  
  <img width="700" alt="EASY MODE SEQUENCE DIAGRAM" src="easymode.png?raw=true">  
 
</div>  


During easy mode, the game is fundamental. It is the base case for the game, with no added elements. The player plays at a constant speed, with the cherries popping up at random times after the snake eats them. Since the player is on easy mode, obstacles and extra lives will not be included. So the sequence diagram is very basic and straightforward to understand. 

First, the user will run the main method. The main method then calls initUI() to start a new Game. The game will then call Gamerender(), which will display the Jpanel home page board. Gamerender() displays all the graphics and texts of the game for the users to see. Gamerender() then calls KeyListener, which listens for the keystrokes to allow the user to select a game mode. KeyListner also listens for keystrokes for the direction (arrow keys) for the player to pause the game and resume the game. Since the player will be playing on easy mode, the KeyListner will be listening for the keystroke E. Once the keystroke is called, it calls the method setGameStatus(), which takes in a parameter of newstatus from the GameStatus emunm, which sets the difficulty level, and calls setStatus that then updates the GameStatus to running. Once the GameStatus is called and sets the game to RUNNING, the player is now playing snake.

One the game is running, SetStatus calls GameLoop() that calls  update() and gamerender.repaint. The repaint allows the graphics to be displayed and calls render, which will draw all the graphics, including setting the colors and text for the game. Update() will update the game as it is being played. Update calls move(), which takes in parameter speed that updates the speed of the snake. The speed for easy mode is constant and does not change. In update(), the snake class method addtail() is called to update the size of the snake's tail as it continues to eat the cherries. Once the snake eats a cherry, the update method calls the Game class method spawnCherry() to have the cherries appear on the board randomly. Lastly, update calls a method checkForGameOver() to check to see if the game is over. The game will be over when the snake dies by either hitting its tail or hitting the walls of the board. When checkForGameOver calls the snake class getHead(), it checks to see if the snake's head hit one of these elements. If the snake's head hits one of the elements that kill the snake, the setStatus method is called to set the GameStatus to GAME_OVER. 

Once the status is set to GAME_OVER the player can now hit enter to restart the game. Once the KeyListener listens for the keystroke "enter," it then calls reset(). Reset then calls resetSnake() calls setStatus() to set the status to GameStatus.RUNNING. ResetSnake creates a new snake to start the game over. 


### Hard Mode Use Case

<img width="700" alt="Screen Shot 2021-11-18 at 12 44 35 PM" src="https://user-images.githubusercontent.com/77749807/142468605-d82f8370-32c6-4c43-b75e-4236ab932edf.png">


During hard mode, the game can get pretty challenging. It is the easy mode of the game with added elements. The player plays at a constant speed at first but 
with each cherry eaten by the snake, the speed increments. Obstacles and extra lives are included in this mode. There are 3 obstacles that will pop up that 
will kill the snake if it runs into them and there are up to 3 extra lives that can pop up during the game. If the snake dies, the extra life will reset 
the snake without the loss of any points. 

First, the user will run the main method. The main method then calls initUI() to start a new Game. The game will then call GameRender(), which will display 
the Jpanel home page board. GameRender() displays all the graphics and texts of the game for the users to see. GameRender() then calls KeyListener, which 
listens for the keystrokes to allow the user to select a game mode. KeyListner also listens for keystrokes for the direction (arrow keys) for the player to 
pause the game and resume the game. Since the player will be playing on hard mode, the KeyListner will be listening for the keystroke H. Once the keystroke 
is called, it calls the method setGameStatus(), which takes in a parameter of newstatus from the GameStatus emun, which sets the difficulty level, and 
calls setStatus that then updates the GameStatus to running. Once the GameStatus is called and sets the game to RUNNING, the player is now playing snake.

One the game is running, SetStatus calls GameLoop() that calls update() and gamerender.repaint. The repaint allows the graphics to be displayed and calls 
render, which will draw all the graphics, including setting the colors and text for the game. Update() will update the game as it is being played. Update 
calls move(), which takes in parameter speed that updates the speed of the snake. The speed for easy mode is constant and does not change. In update(), 
the snake class method addtail() is called to update the size of the snake's tail as it continues to eat the cherries. Once the snake eats a cherry, the 
update method calls the Game class method spawnCherry() to have the cherries appear on the board randomly. It also calls spawnExtraLife() randomly if the 
user has not collected 3 already and calls spawnObstacle() to place 3 obstacles randomly on the board. Lastly, update calls a method checkForGameOver() 
to check to see if the game is over. The game will be over when the snake dies by either hitting its tail or hitting the walls of the board. When 
checkForGameOver calls the snake class getHead(), it checks to see if the snake's head hit one of these elements. If the snake's head hits one of the 
elements that kill the snake, the setStatus method is called to set the GameStatus to GAME_OVER. 

Once the status is set to GAME_OVER the player can now hit enter to restart the game. Once the KeyListener listens for the keystroke "enter," it then 
calls reset(). Reset then calls resetSnake() calls setStatus() to set the status to GameStatus.RUNNING. ResetSnake creates a new snake to start the 
game over.
