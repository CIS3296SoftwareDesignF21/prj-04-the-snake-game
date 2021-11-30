### Class Diagram

![Picture1](https://github.com/CIS3296SoftwareDesignF21/prj-04-the-snake-game/blob/main/SnakeClassDiagram.jpg?raw=true)

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

reset(restarted: Boolean) reset the game, and restarts it from the base snake length and position, or if the player restarted, returns them to the menu.

setStatus() is a method that sets the status of the game. Remember the status of our current game is either NOT_STARTED, RUNNING, PAUSED, RESTARTED, or GAME_OVER. It switched the status between the five as the game starts, running, restarts, or ends.

TogglePause() is the pause method, that when called it pauses the game.

checkforGameOver() is a method that check for collisions. There are two different things that will kill the snake: if it hit a boundary, if it hit its own tail. It checks whether the snake has done either one of those collisions and will end the game into the status GAME_OVER.

spawnCherry() is the method that displays the "apples" at random.

setGameModeStatus(status:GameMode) sets the GameMode based on the choice of the player and then causes the game to run

The Keylistener class is "listening" to what key is pressed on the keyboard. Its basically listening to the direction that is being inputted from the player to help tell where the snake to move. It is also listening to the pause button and when to start the game.

GameLoop class is updated the game as it is running. The game is one big loop, until the snake dies. This class is called to have the game continually running in one big loop.

#### GameRender
A game object GameRender is responsible for changing the graphics on the screen when Game runs update() or at Game initialization. It reads image the image for the apple, and sets the background color.

Render() is the biggest method in this class. It is the primary graphics rendering function of the class. When Game updates the actual location of things to be displayed, Game render then shows that update on the GUI, Displaying the movement of the snake move, having the apples appear, and more.

PaintComponent() calls render to run the game and prints the graphics on the screen.

DrawCenteredString() just creates graphics text and centers the graphics on the board.

renderTitle(Graphics2D g2d) is a helper function used to draw the title screen

renderEndGame(Graphics2D g2d) is a helper function used to draw the Game Over text and highscores when the snake dies

renderPaused(Graphics2D g2d) is a helper function used to draw the Pause text when the player pauses

ReadHighscore() reads the saved highscores from a file into the game

UpdateHighscore() writes the highscores in the game to a file

#### Point
The point class is what the snake is made up of. It creates the parts of the snake and allows the snake to move.

#### CollisionThread
This is a thread class in which each thread intialized on it is resposnsible for detecing collisions of the snake. 

Run() runs the thread when called and does the colision detection for when the snake hits the boundrym itself, or an obstacle and reports when true.

