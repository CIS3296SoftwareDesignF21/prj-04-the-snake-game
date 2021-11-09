# Snake Game
### Trello Board 

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

 ### Goal Of The Game: 
The goal of the game is to eat as many apples as the snake can before dying. Remember, the snake gradually gets longer the more apples it consumes, so you have to be careful not to hit its tail!

## Background

_BUILDING_

```
    - Need to make sure you have the most up to data JDK
    - This source code is also using a .jar file, so make sure you have the most up-to-date one 
                            https://github.com/renanpvaz/java-snake/releases

```

_RUNNING_

```
    - To run this, you need to clone the GitHub repository
    - Once cloned, you need to ensure you are in the folder where the .jar file is located. If not, it won't be able to run 
    - Once you change your directory and are in the correct folder, in the terminal, type this command 
                                    
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
“For people off all ages who need an easy but challenging game, The Snake Game is a 
Java-based game that engages users by having a point-based system which rewards them as they play
 and adds obstacles and speed to improve difficulty of the game. Unlike the retro/original version
 of the Snake Game, our Snake Game provides a simple interface with improved gameplay.”

```


## Personas

#### _Persona 1_ (Olivia Felmey)

```
Sean, College Student 

Sean, age 21, is a college student (Senior) at Temple University in Philadelphia, PA. He majors in 
Graphic Design at The Tyler School of Art where he uses his creativity to create and design interesting 
visual concepts using computer software. He was raised in a small town where him and his group of friends 
played a lot of video games together growing up to pass the time.

Sean’s experience throughout his education of graphic design means he is interested in looking into 
creative and fun technology/games. His passion and love of video games also keeps him interested in exploring 
new types of online games which are visually pleasing yet also challenging due to his large amount of knowledge 
of video games. He will use the snake game to challenge himself to harder gameplay with the new upgrades that
have been implemented to the classic game; As well as enjoy the visually pleasing aesthetics that have been added.
The new feature added of being able to collect extra lives allows him to play this challenging game for a longer amount
of time, which he enjoys compared to the video games he is usually used to.

```
#### _Persona 2_ 

```
Billy, A Young Highschool Student

Billy, age 15, is a highschool student in Philadelphia, PA. Billy spends most of his free time playing video 
games at home. He's super creative and loves to challenge himself with new games. He one of three kids, and loves 
to play games with his siblings. During his other time Billy tends to get bored easily and can't sit still for a
long period of time. He always likes to be doing something thats fun and visually pleasing. Most of the time when 
he's not playing video games, he outside playing with his friends and family. 

Billy is pretty decent at video games, but is not expert. He really likes games that are fun but challenging. The more 
he plays a game the better he gets. During school Billy just wants to play a game thats simple but also where he can still
listen to the teacher. Billy just doesn't want to be bored out of his mind. The Snake Game will help his accomplish this. 
The Snake Game can help Billy be attentive in class, but also have fun. The game will be able to challenge Billy's 
mind. This game is perfect for all ages and Billy will be able to play, and continue to get better. 

```
#### _Persona 3_ 

```
Betty, a mom with kids 

Betty is a woman, 40, with kids. She is somewhat experienced with technology but does not want to use a gaming 
console/controllers because she believes they are too complicated. She knows her kids enjoy playing video games but 
the ones they play are too overstimulating with their colorful interfaces and complicated gameplay. She feels that 
playing a new version of a game she liked previously will connect her with technology, as well as feel connected 
with her kids.

Betty is looking to play a retro game with a new feel. She remembers playing earlier versions of the Snake game but 
wants to explore a newer version. Older versions of the game had only one speed of the game with only 
two ways to die: either running into the wall or running into itself. This new version of the game will include an 
easy interface to interact with and added obstacles to make the game increasingly difficult. The controls 
for the game are only the arrow keys plus some keys to access the menu options so this will be perfect for her needs.

```
#### _Persona 4_ 

```
Agatha, A Retired Teacher

Agatha Jones, age 74, is a retiree from Denver, Colorado. She taught at Great Willow elementary for 45 years before
retiring to her coastal home that she shares with her husband in San Diego. She has had a full life so far, graduating 
from Regis University, raising 3 kids, and winning the Denver holiday baking competition from 2005 to 2018 (and would’ve 
won in 2019 if it wasn’t for her arthritis). Now she simply wants to sit back, relax, and maybe give a call to her 
oldest about when she's going to finally become a grandma.

Agatha’s doctor has given her the unique recommendation of playing video games to keep her hands dexterous in the later
years of her life. She knows how to work a computer due to her work as a teacher, but isn’t adept in playing games on it.
She has an interest in playing the Snake Game due to it’s simplistic nature as well as having a nice tutorial page that 
tells her how to play.

```
#### _Persona 5_ 

```

Jenni, age 7, is a young girl from Austin, Texas. She just started first grade, where she has proven herself to be rather 
intelligent and clever for her age. She spends most of her free time playing with legos by herself or with her mom, a 
civil engineer. Her Dad, a technical artist, has been bonding with her by sharing his love of video games with her. He has 
been introducing her to some simple retro games to try not overwhelm her with modern games that expect more experienced 
players that grasp common video game patterns. 

Jenni, however, quickly masters the basics of most games and just as quickly finds the games too easy. Jenni wants to try 
harder games but her dad doesn't want it to be to hard for her. So Her dad wants to have her play a game that has 
difficulty modes that let them set the difficulty so it's not to hard and she doesn't get bored. The snake game, an updated 
version of the retro classic, Snake, which lets Jenni choose how hard the game is, letting her learn the basics on easier 
modes and changing to hard modes as she gets better.

```

### Class Diagram

[![Picture1](https://raw.githubusercontent.com/CIS3296SoftwareDesignF21/prj-04-the-snake-game/UML/SnakeClassDiagram.jpg)
