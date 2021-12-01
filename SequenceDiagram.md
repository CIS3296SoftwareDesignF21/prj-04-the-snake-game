### Sequence Diagram




### Easy Mode Use Case 

<img width="1049" alt="Screen Shot 2021-12-01 at 1 54 32 PM" src="https://user-images.githubusercontent.com/77749807/144296063-91bdea77-d492-44a6-ba13-20b374eb2214.png">



During easy mode, the game is fundamental. It is the base case for the game, with no added elements. The player plays at a constant speed, with the cherries popping up at random times after the snake eats them. Since the player is on easy mode, obstacles and extra lives will not be included. So the sequence diagram is very basic and straightforward to understand. 

First, the user will run the main method. The main method then calls initUI() to start a new Game. The game will then call Gamerender(), which will display the Jpanel home page board. Gamerender() displays all the graphics and texts of the game for the users to see. Gamerender() then calls KeyListener, which listens for the keystrokes to allow the user to select a game mode. KeyListner also listens for keystrokes for the direction (arrow keys) for the player to pause the game and resume the game. Since the player will be playing on easy mode, the KeyListner will be listening for the keystroke E. Once the keystroke is called, it calls the method setGameStatus(), which takes in a parameter of newstatus from the GameStatus emunm, which sets the difficulty level, and calls setStatus that then updates the GameStatus to running. Once the GameStatus is called and sets the game to RUNNING, the player is now playing snake.

One the game is running, SetStatus calls GameLoop() that calls  update() and gamerender.repaint. The repaint allows the graphics to be displayed and calls render, which will draw all the graphics, including setting the colors and text for the game. Update() will update the game as it is being played. Update calls move(), which takes in parameter speed that updates the speed of the snake. The speed for easy mode is constant and does not change. In update(), the snake class method addtail() is called to update the size of the snake's tail as it continues to eat the cherries. Once the snake eats a cherry, the update method calls the Game class method spawnCherry() to have the cherries appear on the board randomly. Lastly, update calls a method checkForGameOver() to check to see if the game is over. The game will be over when the snake dies by either hitting its tail or hitting the walls of the board. When checkForGameOver calls the snake class getHead(), it checks to see if the snake's head hit one of these elements. If the snake's head hits one of the elements that kill the snake, the setStatus method is called to set the GameStatus to GAME_OVER. 

Once the status is set to GAME_OVER the player can now hit enter to restart the game. Once the KeyListener listens for the keystroke "enter," it then calls reset(). Reset then calls resetSnake() calls setStatus() to set the status to GameStatus.RUNNING. ResetSnake creates a new snake to start the game over. 


### Hard Mode Use Case

<div align="center">  
<img width="1049" alt="Screen Shot 2021-12-01 at 1 50 15 PM" src="https://user-images.githubusercontent.com/77749807/144295461-8cc657df-ac50-4fa8-8e7d-29ca25813990.png">
 
</div> 




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
