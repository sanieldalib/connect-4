import static org.junit.Assert.*;

import org.junit.*;

import javax.swing.JLabel;

public class GameTest {
	
	@Test
	public void testVerticalWinPlayer1(){
		JLabel testLabel = new JLabel();
		GameBoard gBoard = new GameBoard(testLabel);
		gBoard.disableHighScores();
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		assertEquals(gBoard.getWinner(), 1);
		/* [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [1, 0, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0] 
		 */
	}
	
	@Test
	public void testVerticalWinPlayer2(){
		JLabel testLabel = new JLabel();
		GameBoard gBoard = new GameBoard(testLabel);
		gBoard.disableHighScores();
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(3); //adds red in column 4
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		assertEquals(gBoard.getWinner(), 2);
		/* [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [0, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 1, 0, 0, 0] 
		 */
	}
	
	@Test
	public void testNoWinner(){
		JLabel testLabel = new JLabel();
		GameBoard gBoard = new GameBoard(testLabel);
		gBoard.disableHighScores();
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		//Only 3 in each column so no one wins yet
		assertEquals(gBoard.getWinner(), 0);
		/* [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0] 
		 */
	}
	@Test
	public void testHorizontalWinPlayer1(){
		JLabel testLabel = new JLabel();
		GameBoard gBoard = new GameBoard(testLabel);
		gBoard.disableHighScores();
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(0); //adds black in column 1
		gBoard.addDisc(1); //adds red in column 2
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(2); //adds red in column 3
		gBoard.addDisc(2); //adds black in column 3
		gBoard.addDisc(3); //adds red in column 4
		//Only 3 in each column so no one wins yet
		assertEquals(gBoard.getWinner(), 1);
		/* [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [2, 2, 2, 0, 0, 0, 0]
		 * [1, 1, 1, 1, 0, 0, 0] 
		 */
	}
	
	@Test
	public void testHorizontalWinPlayer2(){
		JLabel testLabel = new JLabel();
		GameBoard gBoard = new GameBoard(testLabel);
		gBoard.disableHighScores();
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 1
		gBoard.addDisc(0); //adds red in column 2
		gBoard.addDisc(2); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 3
		gBoard.addDisc(3); //adds black in column 3
		gBoard.addDisc(1); //adds red in column 2
		gBoard.addDisc(4); //adds black to column 5
		//Only 3 in each column so no one wins yet
		assertEquals(gBoard.getWinner(), 2);
		/* [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [1, 0, 0, 0, 0, 0, 0]
		 * [1, 1, 0, 0, 0, 0, 0]
		 * [1, 2, 2, 2, 2, 0, 0] 
		 */
	}
	
	@Test
	public void testUpDiagPlayer1(){
		JLabel testLabel = new JLabel();
		GameBoard gBoard = new GameBoard(testLabel);
		gBoard.disableHighScores();
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(1); //adds red in column 2
		gBoard.addDisc(2); //adds black in column 3
		gBoard.addDisc(3); //adds red in column 4
		gBoard.addDisc(2); //adds black in column 3
		gBoard.addDisc(2); //adds red in column 3
		gBoard.addDisc(3); //adds black to column 4
		gBoard.addDisc(3); //adds red in column 4
		gBoard.addDisc(4); //adds black to column 5
		gBoard.addDisc(3); //adds red in column 4
		//Only 3 in each column so no one wins yet
		assertEquals(gBoard.getWinner(), 1);
		/* [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 1, 0, 0, 0]
		 * [0, 0, 1, 1, 0, 0, 0]
		 * [0, 1, 2, 2, 0, 0, 0]
		 * [1, 2, 2, 1, 2, 0, 0] 
		 */
	}
	
	@Test
	public void testUpDiagPlayer2(){
		JLabel testLabel = new JLabel();
		GameBoard gBoard = new GameBoard(testLabel);
		gBoard.disableHighScores();
		gBoard.addDisc(1); //adds red in column 2
		gBoard.addDisc(0); //adds black in column 1
		gBoard.addDisc(2); //adds red in column 3
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(2); //adds red in column 3
		gBoard.addDisc(2); //adds black in column 3
		gBoard.addDisc(3); //adds red in column 4
		gBoard.addDisc(3); //adds black to column 4
		gBoard.addDisc(3); //adds red in column 4
		gBoard.addDisc(3); //adds black to column 4
		assertEquals(gBoard.getWinner(), 2);
		/* [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 2, 0, 0, 0]
		 * [0, 0, 2, 1, 0, 0, 0]
		 * [0, 2, 1, 2, 0, 0, 0]
		 * [2, 1, 1, 1, 0, 0, 0] 
		 */
	}
	
	@Test
	public void testDownDiagPlayer1(){
		JLabel testLabel = new JLabel();
		GameBoard gBoard = new GameBoard(testLabel);
		gBoard.disableHighScores();
		gBoard.addDisc(3); //adds red in column 4
		gBoard.addDisc(2); //adds black in column 3
		gBoard.addDisc(2); //adds red in column 3
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(1); //adds red in column 2
		gBoard.addDisc(0); //adds black to column 4
		gBoard.addDisc(0); //adds red in column 4
		gBoard.addDisc(3); //adds black to column 4
		gBoard.addDisc(0); //adds red to column 1
		assertEquals(gBoard.getWinner(), 1);
		/* [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [1, 0, 0, 0, 0, 0, 0]
		 * [1, 1, 0, 0, 0, 0, 0]
		 * [2, 2, 1, 2, 0, 0, 0]
		 * [1, 2, 2, 1, 0, 0, 0] 
		 */
	}
	
	@Test
	public void testDownDiagPlayer2(){
		JLabel testLabel = new JLabel();
		GameBoard gBoard = new GameBoard(testLabel);
		gBoard.disableHighScores();
		gBoard.addDisc(2); //adds red in column 3
		gBoard.addDisc(3); //adds black in column 4
		gBoard.addDisc(1); //adds red in column 2
		gBoard.addDisc(2); //adds black in column 3
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black to column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(0); //adds black to column 1
		assertEquals(gBoard.getWinner(), 2);
		/* [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [2, 0, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 2, 0, 0, 0, 0]
		 * [1, 1, 1, 2, 0, 0, 0] 
		 */
	}
	
	@Test
	public void testDraw(){
		JLabel testLabel = new JLabel();
		GameBoard gBoard = new GameBoard(testLabel);
		gBoard.disableHighScores();
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(1); //adds red in column 2
		gBoard.addDisc(0); //adds black to column 1
		gBoard.addDisc(1); //adds red in column 2
		gBoard.addDisc(0); //adds black to column 1 
		gBoard.addDisc(1); //adds red in column 2
		gBoard.addDisc(0); //adds black in column 1

		gBoard.addDisc(2); //adds red in column 3
		gBoard.addDisc(3); //adds black in column 4
		gBoard.addDisc(2); //adds red in column 3
		gBoard.addDisc(3); //adds black in column 4
		gBoard.addDisc(2); //adds red in column 3
		gBoard.addDisc(3); //adds black in column 4
		gBoard.addDisc(3); //adds red in column 4
		gBoard.addDisc(2); //adds black to column 3
		gBoard.addDisc(3); //adds red in column 4
		gBoard.addDisc(2); //adds black to column 3 
		gBoard.addDisc(3); //adds red in column 4
		gBoard.addDisc(2); //adds black in column 3
		
		gBoard.addDisc(4); //adds red in column 5
		gBoard.addDisc(5); //adds black in column 6
		gBoard.addDisc(4); //adds red in column 5
		gBoard.addDisc(5); //adds black in column 6
		gBoard.addDisc(4); //adds red in column 5
		gBoard.addDisc(5); //adds black in column 6
		gBoard.addDisc(5); //adds red in column 6
		gBoard.addDisc(4); //adds black to column 5
		gBoard.addDisc(5); //adds red in column 6
		gBoard.addDisc(4); //adds black to column 5 
		gBoard.addDisc(5); //adds red in column 6
		gBoard.addDisc(4); //adds black in column 5
		
		gBoard.addDisc(6); //adds red in column 7
		gBoard.addDisc(6); //adds black in column 7
		gBoard.addDisc(6); //adds red in column 7
		gBoard.addDisc(6); //adds black in column 7
		gBoard.addDisc(6); //adds red in column 7
		gBoard.addDisc(6); //adds black in column 7
		
		assertEquals(gBoard.getWinner(), 0);
		assertTrue(gBoard.isFull());
		/* [2, 1, 2, 1, 2, 1, 2]
		 * [2, 1, 2, 1, 2, 1, 1]
		 * [2, 1, 2, 1, 2, 1, 2]
		 * [1, 2, 1, 2, 1, 2, 1]
		 * [1, 2, 1, 2, 1, 2, 2]
		 * [1, 2, 1, 2, 1, 2, 1] 
		 */
	}
	
	@Test
	public void testUndoPlayer1(){
		JLabel testLabel = new JLabel();
		GameBoard gBoard = new GameBoard(testLabel);
		gBoard.disableHighScores();
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(1); //adds red in column 2
		gBoard.undo(); //undos red's last move
		gBoard.addDisc(0); //adds red in column 1
		assertEquals(gBoard.getWinner(), 1);
		
		/* [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [1, 0, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0] 
		 */
	}
	
	@Test
	public void testUndoPlayer2(){
		JLabel testLabel = new JLabel();
		GameBoard gBoard = new GameBoard(testLabel);
		gBoard.disableHighScores();
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(3); //adds red in column 4
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(0); //adds black in column 1
		gBoard.undo(); //undos black's last move
		gBoard.addDisc(1); //adds black in column 2
		assertEquals(gBoard.getWinner(), 2);
		/* [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [0, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 1, 0, 0, 0] 
		 */
	}
	
	@Test
	public void testMultipleUndosPlayer1(){
		JLabel testLabel = new JLabel();
		GameBoard gBoard = new GameBoard(testLabel);
		gBoard.disableHighScores();
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(1); //adds red in column 2
		gBoard.undo(); //undos red's move
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(3); //adds red in column 4
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.undo(); //tries to undo red's last move but red has used their undo
		gBoard.addDisc(1); //adds black in column 2
		assertEquals(gBoard.getWinner(), 2);
		/* [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [0, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 1, 0, 0, 0] 
		 */
	}
	
	@Test
	public void testMultipleUndosPlayer2(){
		JLabel testLabel = new JLabel();
		GameBoard gBoard = new GameBoard(testLabel);
		gBoard.disableHighScores();
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(0); //adds black in column 2
		gBoard.undo(); //undos black's move
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.addDisc(0); //adds red in column 1
		gBoard.addDisc(1); //adds black in column 2
		gBoard.undo(); //tries to undo black's last move but black has used their undo
		gBoard.addDisc(0); //adds red in column 1
		assertEquals(gBoard.getWinner(), 1);
		
		/* [0, 0, 0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0, 0, 0]
		 * [1, 0, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0]
		 * [1, 2, 0, 0, 0, 0, 0] 
		 */
	}
	
	
	
	
	
	
	
	
	
}
   