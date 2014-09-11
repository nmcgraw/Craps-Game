Craps-Game
==========

This is the repository for all three versions of the craps game I programmed (Java, Java GUI, and C++). The following files and folders are in this repository:

  - Craps.java (This is the Java program for the console game.)
  - Craps GUI Classes (This folder contains the Java files for the classes of the Java program for the GUI game.):
    - Game.java (This is the main class.)
    - Dice.java (This is the class that displays the result of each dice roll.)
  - Craps.cpp (This is the C++ program for the game.)

The Craps.java and Craps.cpp files each run their respective programs on their own. However, the GUI program requires both the Game.java and Dice.java files to be in the same project folder because Game.java calls instances of Dice.java in its methods.
