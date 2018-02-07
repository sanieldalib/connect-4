
import java.util.*;

//Represents the Board as a 2D array object
//Also includes the methods to make updates to the 2d array
//Determines who winner is if there is a winner.

public class Board{
	
	private int[][] board = new int[6][7];
	private boolean isWon;
	private int winner;
	private List<int[][]> moves;
	//Holds either 0, 1 or 2
	//0 represents empty space
	//1 represents player 1
	//2 represents player 2
	
	public Board(){
		moves = new LinkedList<int[][]> ();
		isWon = false;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				board[i][j] = 0;
				//0 represents empty space
				//1 represents player 1
				//2 represents player 2
			}
		}
		moves.add(boardCopy(board));
	}
	
	public boolean getIsWon(){
		return isWon;
	}
	
	public void setIsWon(boolean passedIsWon){
		isWon = passedIsWon;
	}
	
	public int[][] getBoard(){
		return board;
	}
	//Sets the board to a passedboard - used for undoing and setting board to board from
	// linkedlist.
	public void setBoard(int [][] passedBoard){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				board[i][j] = passedBoard[i][j];
			}
		}
	}
	
	public int getWinner(){
		return winner;
	}
	
	//Returns the first empty row in a given colum
	public int getNextRow(int col){
		for(int i = 5; i > -1; i--){
			if(board[i][col] == 0){
				return i;
			}
		}
		return -1;
	}
	
	//places the players number at the given location - means they have placed disc there
	public void placeDisc(int row, int col, int player){
		board[row][col] = player;
		moves.add(boardCopy(board));
	}
	
	//Creates a copy of the current board so that we can store in LinkedList
	//Trying to store the board directly does not allow storing all the changes made
	public int[][] boardCopy(int[][] board){
		int[][] copy = new int[6][7];
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				copy[i][j] = board[i][j];
			}
		}
		return copy;
	}
	
	public void undo(){
		((LinkedList<int[][]>) moves).removeLast();
		int [][] oldBoard = ((LinkedList<int[][]>) moves).getLast();
		setBoard(oldBoard);
		
	}
	public boolean isFull(){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				if(board[i][j] == 0){
					return false;
				}
			}
		}
		return true;
	}
	
	public void checkWinner(){
		
		//Checking Vertically for 4
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 6; j++){
				if(board[i][j] != 0 && board[i][j] == board[i + 1][j]
					&& board[i][j] == board[i + 2][j]
					&& board[i][j] == board[i + 3][j]){
						isWon = true;
						winner = board[i][j];
					}
			}
		}
		
		//Check Horizontal for 4
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 4; j++){
				if(board[i][j] != 0 && board[i][j] == board[i][j + 1]
					&& board[i][j] == board[i][j + 2]
					&& board[i][j] == board[i][j + 3]){
						isWon = true;
						winner = board[i][j];
				}
					
			}
		}
		
		//Check downward diag. for 4
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 4; j++){
				if(board[i][j] != 0 && board[i][j] == board[i + 1][j + 1]
					&& board[i][j] == board[i + 2][j + 2]
					&& board[i][j] == board[i + 3][j + 3]){
					isWon = true;
					winner = board[i][j];
				}
				
			}
		}
		
		//Check upward diag. for 4
		for(int i = 5; i > 2; i--){
			for(int j = 0; j < 4; j++){
				if(board[i][j] != 0 && board[i][j] == board[i - 1][j + 1]
					&& board[i][j] == board[i - 2][j + 2]
					&& board[i][j] == board[i - 3][j + 3]){
					isWon = true;
					winner = board[i][j];
					}
			}
		}
	}
	
	
}