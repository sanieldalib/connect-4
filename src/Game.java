/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
public class Game implements Runnable {
    public void run() {
        // NOTE : recall that the 'final' keyword notes immutability even for local variables.
    	
        final JFrame frame = new JFrame("Daniel Salib's Connect 4");
        frame.setLocation(300, 300);
        
     // Status panel
        final JPanel status_panel = new JPanel();
        frame.add(status_panel, BorderLayout.SOUTH);
        JLabel status = new JLabel("It's your turn, Player 1");
        status_panel.add(status);
        
    	//GameBoard
        final GameBoard gBoard = new GameBoard(status);
        frame.add(gBoard, BorderLayout.CENTER);
        
        //Menu Bar
        JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem help = new JMenuItem("How to Play");
		help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, 
            			"Hello and welcome to Connect - 4, by Daniel Salib.\n\n"
            			+ "Use the buttons to drop pieces in the row you want.\n\n"
            			+ "This game also allows for one undo per player per game."
            			+ "These are found at File > Undo.\n\n"
            			+ "This game also implements high scores based on the lowest number of "
            			+ "moves needed to win.\nHowever, if you use an undo, your score will not "
            			+ "be counted towards high scores.\n\n"
            			+ "High Scores can be found at File > High Scores.",
            			"How to Play", JOptionPane.INFORMATION_MESSAGE);
            }
        });
		JMenuItem highScores = new JMenuItem("High Scores");
		highScores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					JOptionPane.showMessageDialog(null,gBoard.getHighScores(), "High Scores",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					System.out.println("High Scores failed to launch.");
				}
            }
        });
		JMenuItem newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gBoard.newGame();
            }
        });
		JMenuItem undo= new JMenuItem("Undo");
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				gBoard.undo();
				frame.paint(frame.getGraphics());
			}
		});
		
		JMenuItem quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gBoard.quit();
            }
        });
		
		file.add(highScores);
		file.add(newGame);
		file.add(undo);
		file.add(quit);
		menuBar.add(file);
		menuBar.add(help);
		frame.setJMenuBar(menuBar);
       
        
        //Image for row button
        final String IMG_FILE = "files/Triangle.png";
        BufferedImage arrow_img = null;
        
        try{
        	arrow_img = ImageIO.read(new File(IMG_FILE));
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        
        
        //Buttons
        final JPanel button_panel = new JPanel();
        frame.add(button_panel, BorderLayout.NORTH);
        
        final JButton row1 = new JButton();
        row1.setIcon(new ImageIcon(arrow_img));
        button_panel.add(row1);
        row1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gBoard.addDisc(0);
                frame.paint(frame.getGraphics());
            }
        });
        
        final JButton row2 = new JButton();
        row2.setIcon(new ImageIcon(arrow_img));
        button_panel.add(row2);
        row2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gBoard.addDisc(1);
                frame.paint(frame.getGraphics());
            }
        });
        
        final JButton row3 = new JButton();
        row3.setIcon(new ImageIcon(arrow_img));
        button_panel.add(row3);
        row3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gBoard.addDisc(2);
                frame.paint(frame.getGraphics());
            }
        });
        
        final JButton row4 = new JButton();
        row4.setIcon(new ImageIcon(arrow_img));
        button_panel.add(row4);
        row4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gBoard.addDisc(3);
                frame.paint(frame.getGraphics());
            }
        });
        
        final JButton row5 = new JButton();
        row5.setIcon(new ImageIcon(arrow_img));
        button_panel.add(row5);
        row5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gBoard.addDisc(4);
                frame.paint(frame.getGraphics());
            }
        });
        
        final JButton row6 = new JButton();
        row6.setIcon(new ImageIcon(arrow_img));
        button_panel.add(row6);
        row6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gBoard.addDisc(5);
                frame.paint(frame.getGraphics());
            }
        });
        
        final JButton row7 = new JButton();
        row7.setIcon(new ImageIcon(arrow_img));
        button_panel.add(row7);
        row7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gBoard.addDisc(6);
                frame.paint(frame.getGraphics());
            }
        });
        

        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    

    /**
     * Main method run to start and run the game. Initializes the GUI elements specified in Game and
     * runs it. IMPORTANT: Do NOT delete! You MUST include this in your final submission.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}