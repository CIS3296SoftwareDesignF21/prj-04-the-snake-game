### Class Diagram

![Picture1](https://github.com/CIS3296SoftwareDesignF21/prj-04-the-snake-game/blob/main/SnakeClassDiagram.jpg?raw=true)


In our UML we have eight main classes: Point, Snake, Game, GameRender, CollsionThread, KeyListener, GameLoop, Main. We also have three enumerations in our diagram: Gamestatus, GameMode, Direction. The enumeration classes are just a list of named constants.

## GameStatus

**GameStatus**

Game Status Enumeration tells us the different types of conditions the game is currently in.   
We currently have five conditions for the game: Not_STARTED, RUNNING, PAUSED, GAME_OVER, RESTARTED.

When the status is at NOT_STARTED, the game hasn't started running yet. This is either the home screen or when the game is over, and the player can restart. RUNNING status means when the player is playing the game. PAUSE status is when the player stops the game momentarily, and the player can resume whenever they are ready. GAME_OVER tells the game when the player has died in the game. The RESTARTED status will bring the player back to the home screen to pick a new difficult and play the game again. 

## Direction

**Direction** 

Direction enumeration tells us which way the snake will move on the board. The whole panel is a graph with x and y axes. The snake can move in four different ways, left, right, up, or down, and the arrow keys control this.

**isX and isY**
The methods isX() and isY() help us tell the snake's direction on the axis. With isX() being the horizontal movements and isY() being the vertical movements.

## GameMode

The GameMode enumeration sets the game mode to the difficulty level the player selects. 

## Snake

**Snake Method** 

Snake class had four different methods implemented in it. Snake, move, addtail, and turn. Snake method takes in two ints as the parameters). Turn method takes in the direction of the snake as a parameter.

**Addtail** 

Addtail method adds a "block" to the snake's body. This method is what makes the snake longer as the snake eats more apples.

**Move** 

The move method is just the tells the snake what direction to move in. It uses a thread-safe array list to get the coordinates of the snake and change them in the direction the player gave it.

**Turn** 

Turn method will update the direction that the snake is turning.

**Snake Method**
The snake method is creating the snake for the beginning of the game. It adds to the tail for the base length. The newly created snake will start at the center of the board and move right. 

## Main

**Main**

The Main class haas four total methods within it: main(String[] args), Main(), run(), and initUI(). 
It all works together to create the Jpannel and JFrame, and the New Game can start. 

**main** 
main(String[] args) call EventQueue.invokeLater to update JSwing components on the event dispatching threads. Main(String[] args) will then call run in the same method. 

**run** 
Run creates a new Main object to run the game. 

**Main** 

The Main method calls initUI. 

**InitUI** 

InitUI will make a new JFrame for the game and a new Game object. It then sets the visibility to true so that the game can display and start. 

## Game

The Game class is our biggest one, and it involves the basics of the game and how the game works. There are currently ten different methods within this class: Game(), update(), reset(), setStatus(), togglePause(), checkForGameOver(), extraLife(), spawnCherry(), spawnExtraLife(), spawnObstacle(), setGameMode(). In the Game class, there are also two seperate other classes. The KeyListener and GameLoop class within the Game class.

**Game Method** 

Game() makes a new snake and a new GameRender object that passes a new keyListener.  It sets the status of the game to NOT_RUNNING.

**Update**

Update() is updating the snake as the game proceeds. It acts as the main logical updater of the game, checking if the game meets all of the conditions to be in the game's current status and its objects. It moves the snake and checks whether or not the snake's head has hit the apple. It will then call to add to the tail and check whether the snakehead has hit a collision and died.

**Reset**

Reset(restarted: Boolean) reset the game and restart it from the base snake length and position, or if the player restarted, return them to the menu.

**Resetsnake** 

ResetSnake() creates a new snake object and prints it at the center of the board. 

**extralife**

ExtraLife() sets the game status to EXTRA_LIFE. If the snake has hit died, the snake is then reset to the center of the board. The GameStatus is now being set to RUNNING. 

**setStatus** 

SetStatus(newStatus: GameStatus) is a method that sets the status of the game. Remember, the status of our current game is either NOT_STARTED, RUNNING, PAUSED, RESTARTED, EXTRALIFE,  or GAME_OVER. If the status is either EXTRA_LIFE, PAUSED, or GAME_OVER, we call timer.cancel(). If it is RUNNING, the game continues as is. 

**setGameMode** 

setGameMode(newStatus: GameMode) will do a switch case based on the status of the GameMode. Depending on the mode, the game will then set the GameStatus to running. 

**TogglePause** 

TogglePause() is the pause method that when called it pauses the game.

**CheckforGameOver** 

CheckforGameOver() is a method that check for collisions. Three different things will kill the snake: if it hits a boundary, it will hit its tail, hitting an obstacle. It checks whether the snake has done either one of those collisions and will end the game into the status GAME_OVER.


**SpawnCherry** 

spawnCherry() is the method that displays the "apples" at random.

**SpawnExtraLife** 

SpawnExtraLife() will create a new point and display the extra life icon at random. 

**SpawnObstacle** 

SpawnObsacle() will create three new points to display three different obstacles at random on the board. 

**KeyListener Class** 

The Keylistener class is "listening" to what key is pressed on the keyboard. It's listening to the direct input from the player to help tell where the snake is to move. It is also listening to the pause button and when to start the game.

**GameLoop** 

GameLoop class has updated the game as it is running. 

**run** 

Run() is in the GameLoop class. It calls update(), and repaint from GameRender, to continue playing the game. This class is called to have the game continually running in one big loop. 


## GameRender

A game object GameRender is responsible for changing the graphics on the screen when the game runs update() or at Game initialization. It reads image the image for the apple and sets the background color.

**Render** 

Render() is the most significant method in this class. It is the primary graphics rendering function of the class. When the game updates the actual location of things to be displayed, the game renders then shows that update on the GUI, Displaying the movement of the snake, having the apples appear, and more.

**PaintCOmponent** 

PaintComponent() calls render to run the game and prints the graphics on the screen.

**DrawCenteredString** 

DrawCenteredString() creates graphics text and centers the graphics on the board.

**RenderTitle** 

renderTitle(Graphics2D g2d) is a helper function used to draw the title screen

**RenderEndGame** 

RenderEndGame(Graphics2D g2d) is a helper function used to draw the game Over text and high scores when the snake dies

**RenderPaused**

renderPaused(Graphics2D g2d) is a helper function used to draw the Pause text when the player pauses

**RenderHighScore** 

ReadHighscore() reads the saved high scores from a file into the game.

**UpdateHighScore** 

UpdateHighscore() writes the high scores in the game to a file.

## Point

Point class is setting the x and y coordinates to move the snake.  

**Point** 

Point() gets the x and y coordinates and sets in x and y. 

**Move** 

Move(d; Direction, value: int) is switching between up, down, right, and left. Right and left will be the x coordinates. Up and down will be for the y coordinates. 

**getX** 

GetX() returns the x coordinate 

**getY** 

GetY() returns the y coordinates. 

**SetX** 

SetX(p: Point) sets the x value when the snake moves. 

**SetY** 

SetY(p: Point) sets the y value when the snake moves. 

**toString** 

toString() gets the coordinates and makes them into a string 

**intersects**

Intersects() checks for coordinates of the collision and if the sanke will die 


## CollisionThread

This is a thread class in which each thread initialized on it is responsible for detecting collisions of the snake. 

**Run**

Run() runs the thread when called and does the collision detection for when the snake hits the boundary itself or an obstacle and reports when true.
