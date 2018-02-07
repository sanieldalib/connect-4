/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * GameBoard
 * 
 * This class holds the primary game logic for how different objects interact with one another. Take
 * time to understand how the timer interacts with the different methods and how it repaints the GUI
 * on every tick().
 */
@SuppressWarnings("serial")
public class GameBoard extends JLayeredPane {

	
    // the state of the game logic
    private JLabel status; // Current status text, i.e. "Running..."    
    private Board gameBoard = new Board(); //Creates a new Board Object
    private BufferedReader br; //reader to read high scores from txt file
    
    private int player = 1;
    private JLabel discLabel;
    private int player1undos = 1;
    private int player2undos = 1;
    private int player1moves = 0;
    private int player2moves = 0;
    private boolean highScoresOn = true;
    private Map<Integer, String> highScores;

    // Game constants
    public static final int COURT_WIDTH = 640;
    public static final int COURT_HEIGHT = 480;

    //Disc Images
    BufferedImage black_chip;
    BufferedImage red_chip;
    BufferedImage board_img;
    

    public GameBoard(JLabel status) {
        // creates border around the court area, JComponent method
    	setPreferredSize(new Dimension(COURT_WIDTH, COURT_HEIGHT));
        this.status = status;
    	  try{
    	    	black_chip = ImageIO.read(new File("files/black.png"));
    	    	red_chip = ImageIO.read(new File("files/red.png"));
    	    	board_img = ImageIO.read(new File("files/Connect4Board.png"));
    	    } catch(IOException e){
    	        System.out.println("Internal Error:" + e.getMessage());
    	    }
    	  try{
    		  br = new BufferedReader(new FileReader("files/highscores.txt"));
    	  }catch(FileNotFoundException e){
    		  System.out.println("Cannot fine highscores.txt");
    	  }
        final JLabel backBoard = new JLabel();
        backBoard.setIcon(new ImageIcon(board_img));
        backBoard.setBounds(0, 0, 640, 480);
        add(backBoard, 1);
        highScores = new TreeMap<Integer, String> ();
        	try {
        		readHighScores();
        	} catch (IOException e) {
        		System.out.println("Error occured reading high scores.");
        	}
        }
    
    public void addDisc(int col){
    	if(gameBoard.getIsWon() == false){
    	int row = gameBoard.getNextRow(col);
    	if (row == -1){
    		status.setText("That column is full. Try a different one.");
    	}
    	else{
        	int xShift = 15 + (col) * 90;
        	int yShift = 406 - (5 - row) * 80;
        	ImageIcon blackChip = new ImageIcon(black_chip);
        	ImageIcon redChip = new ImageIcon(red_chip);
        	discLabel = new JLabel();
        	if(player == 1){
        		discLabel.setIcon(redChip);
        		player1moves++;
        		status.setText("It's your turn, Player 2! (Black)");
        	}
        	else{
        		discLabel.setIcon(blackChip);
        		player2moves++;
        		status.setText("It's your turn, Player 1! (Red)");
        	}
        	
        	discLabel.setBounds(xShift, yShift, blackChip.getIconWidth(),blackChip.getIconHeight());
        	add(discLabel, new Integer(0), 0);
        	gameBoard.placeDisc(row, col, player);
        	gameBoard.checkWinner();
        	//If someone wins
        	if(gameBoard.getIsWon()){
        			status.setText("Player "+ gameBoard.getWinner() + " wins!");
        			if(gameBoard.getWinner() == 1){
        				try {
							writeHighScore(player1moves);
						} catch (IOException e) {
							System.out.println("An error occured while writing"
									+ " player 1's high score.");
						}
        			}
        			else{
        				try {
							writeHighScore(player2moves);
						} catch (IOException e) {
							System.out.println("An error occured while writing"
									+ " player 2's high score.");
						}
        			}
        		}

        	//Takes Care of Draws
        	else{
        		if(gameBoard.isFull()){
        			status.setText("It's a draw!");
            		}
        		}
        	switchPlayers();
    	}
    	}
    }
    
    public void undoHelper(){
    	if(!gameBoard.getIsWon() || !gameBoard.isFull()){
    		remove(discLabel);
    		gameBoard.undo();
    		switchPlayers();
    	}
    	else{
    		status.setText("Can't undo the L you took.");
    	}
    }
    
    public void undo(){
    	if(player == 1 && player2undos > 0){
    		undoHelper();
    		disableHighScores();
    		player2undos--;
    		player2moves--;
    		status.setText("You are using your undo, Player 2!");
    	}else{
    		if(player == 2 && player1undos > 0){
    			undoHelper();
        		disableHighScores();
    			player1undos--;
    			player1moves--;
        		status.setText("You are using your undo, Player 1!");

    		}
    		else{
    			status.setText("You are out of undos.");
    		}
    	
    	}
    	
    	
    }
    public int getWinner(){
    	return gameBoard.getWinner();
    }
    
    public boolean isFull(){
    	return gameBoard.isFull();
    }
    
    public void disableHighScores(){
    	highScoresOn = false;
    }
    
    public String getHighScores() throws IOException{
    	String highScoresString = "";
    	readHighScores();
    	for(Map.Entry<Integer, String> entry : highScores.entrySet()) {
			  String name = entry.getValue();
			  int value = entry.getKey();
			  highScoresString+= "Moves: " + value + " - " + name + "\n";
    	}
    	return highScoresString;
    }
        
    public void readHighScores() throws IOException{
    	String parse = "";
    	int i = 0;
    	parse = br.readLine();
    	while(parse != null && i < 6){
            int comma = parse.indexOf(44);
    		String name = parse.substring(0, comma);
    		int value = Integer.parseInt(parse.substring(comma + 1));
    		highScores.put(value, name);
    		i++;
    		parse = br.readLine();
    	}
    }
    
    private void writeHighScore(int numberOfMoves) throws IOException{
    	if(highScores.size() > 4 && highScoresOn){
    	BufferedWriter wr = new BufferedWriter(new FileWriter("files/highscores.txt"));
    	int highest = ((TreeMap<Integer, String>) highScores).lastKey();
    		if(numberOfMoves < highest){
    			String newname = (String)JOptionPane.showInputDialog(null, "Congrats! You set a high score!\n"
                        + "Input your name");
    			highScores.remove(highest);
    			highScores.put(numberOfMoves, newname);
    			
    			for(Map.Entry<Integer, String> entry : highScores.entrySet()) {
    				  String name = entry.getValue();
    				  int value = entry.getKey();
    				  wr.write(name + "," + value + "\n");
    		}
    			wr.close();
    	}
    		}else if(highScoresOn){
    		BufferedWriter wr = new BufferedWriter(new FileWriter("files/highscores.txt"));
    		String newname = (String)JOptionPane.showInputDialog(null, 
    				"Congrats! You set a high score!\nInput your name");
			highScores.put(numberOfMoves, newname);
			
			for(Map.Entry<Integer, String> entry : highScores.entrySet()) {
				  String name = entry.getValue();
				  int value = entry.getKey();
				  wr.write(name + "," + value + "\n");
		}
			wr.close();
    	}
    	else{
    		status.setText("Player " + player + "wins, but no high score.");
    	}
    	
    	}
    
    public void switchPlayers(){
     	if(player == 1){
    		player = 2;
    	}
    	else{
    		player = 1;
    	}
    }
    
    public void newGame(){
    	new Game().run();
    }
    
    public void quit(){
    	System.exit(0);
    }
      

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}