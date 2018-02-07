=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: 59572277
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an approprate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. 2D Arrays - I used 2D arrays to model the gameboard. I felt that this was the 
  	 most intuitive way to represent the grid system that makes up the connect - 4
  	 board. 0,1 and 2 were used to model if a space was empty, filled by player 1,
  	 or filled by player 2. Various methods were written to check for winning states
  	 or draws. 

  2. Collections - I used both a LinkedList and a TreeMap. The LinkedList was used
  	 to store the gameboard (2D array) after every move so that an undo button 
  	 could be added. Additionally, using a LinkedList for this makes sense as the
  	 order of the moves matters in this case.
  		 The TreeMap was used to store the high score values and the owners once they
  	 were parsed from the text file. I used a TreeMap over a different collection
  	 because I wanted to associate the owner with the score. A TreeMap also sorts
  	 high scores based on the keys (in this case the value of the score).

  3. I/O - I used both a reader and a writer to read and write high scores from 
  	 the highscores.txt file. A BufferedReader is used to read and parse the file
  	 where the highscores are stored into the TreeMap for highcores 
  	 at the start of each game. At the end, the number of moves is checked against
  	 the high scores and if it is a high score, the user is prompted for their name.
  	 This is then saved to the file using a BufferedWriter.

  4. JUnit Testing - I used JUnitTesting to test the various win possibilities for
  	 each player. I also used them to test for draws as well as the undo functionality.
  	 Finally, in each of the tests, I disabled high scores using the disableHighScores()
  	 method in order to avoid filling up the leaderboard with test cases.


=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
  
  Game.java - this class initializes the game and builds the layout and gui.
  
  GameBoard.java - this builds upon the Board object (described below) and paints
  appropriate pieces on the GUI according the the 2D Array Board Object. This class
  also handles most logic as well as high scores.
  
  Board.java - this class hold the 2D Array representation of the grid. It also
  cointains the methods which check for wins and draws. 


- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
  
  Yes, I originally tried to use the code provided, but eventually found that the games were
  fundamentally different and decided to write my own equivalent of GameCourt.java

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
  
  I believe that my game has a good amount of seperation built in. I believe the private
  state is well encapsulate. If I could refactor, I would probably avoid putting so much in
  each method, especially in the GameBoard.java class.



========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.
  
  The board image - https://studio.code.org/v3/assets/TLFZogscaPiUKUzLFfvzYQ/Connect4Board.png


