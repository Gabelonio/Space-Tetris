# Space Tetris
#### Gabriel Esteban Castillo Ramirez
### Introduction
Your ship is in an endless quest and suddenly a group of asteroids is approaching, evade them before they hit your ship. 

### Game instructions
* The ship is controlled with the keyboard's arrows of the game is to evade as much asteroids as you can, the more 
  time you stay, the more points you gain. 
* The obstacles are the asteroids in the space, they can go fast or slow, depending of the chosen difficulty,
  it has three different difficultie : easy, medium and hard. Although the hard mode is slower as the medium's, the 
  quantity of asteroids is the real challenge. If the ship gets touched by an asteroid, the game is over.
  
<img src="https://user-images.githubusercontent.com/43209755/77855529-9ff76a80-71b6-11ea-836d-6d43c2308cc9.png" width="160">
<img src="https://user-images.githubusercontent.com/43209755/77855545-b3a2d100-71b6-11ea-9eba-870a3231775f.png" width="560">

### Game Structure
The Game uses a single language for both visual and logical aspects, which is Java. 

#### Main Structure
The sources packages divide into two activities, showing the game and setting the logic of it:
1. The logical packages are "logicaAsteroide" and "logicaNave".
2. The graphic package is "grafica".

#### Visualization and its interaction 
In the package meant for the visualization we find:
1. The ship's model and the invocation of the asteroids.
2. A brief logical class ("Casilla") which determines the collision and the space meant for the ship or the asteroids.
3. The setting of the difficulty.
4. The main console where the game is executed.
5. Movement of the ship and the asteroids. 
6. The score's logic.

Almost all the classes are managed with threads, except for the "Casilla", "Consola" and "MainThread" classes.

#### Functionality
In the packages meant for the logic core of the game we find:
1. The shape and rotation for the asteroids. 
2. The creator of the asteroids.
3. The ship's movement logic.
4. The ship's coordinates. 

Beginning with the "logicaAsteroide" package, it has these specifications:
* The shape of every asteroid is managed with a matrix of booleans.
* The shape of each asteroid is given by individual classes. 
* The asteroids factory is managed with a Singleton pattern. 
* The shape and rotation of the asteroids generates randomly. 

Continuing with the "logicaNave" package, it has these specifications:
* The logic of the movements is managed with an Iterator pattern.
* The position of the ship is composed by two coordinates: X and Y.
* It focuses on two classes of movement, positive (right and down) and negative (left and up).


### Execution
By cloning this repository, the user will only has to double click the "SpaceTetris" executable .jar file and the game will automatically start. 


