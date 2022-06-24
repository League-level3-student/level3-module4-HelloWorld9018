package _03_Hangman;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hangman implements KeyListener {
	

	public void setup(Utilities utilities) {
		
		String rounds = JOptionPane.showInputDialog("Enter the number of rounds you would like to attempt (1-266): ");
		int r = Integer.parseInt(rounds);
		Stack<String> words = new Stack<String>();
		
		for(int i = 0; i<r; i++) {
			String random = utilities.readRandomLineFromFile("dictionary.txt");
			
			while(words.contains(random)) {
				random = utilities.readRandomLineFromFile("dictionary.txt");
			}
			
			words.add(random);
		}
	
		createDisplay(words.pop());
	}
	
	 void createDisplay(String word) {
		 
		 int strikes = 0;
		 String incorrectLetters = "";
		 
		JFrame frame = new JFrame();
		frame.setVisible(true);
		JPanel masterPanel = new JPanel();
		JPanel middlePanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JLabel image = new JLabel();
		JLabel letters = new JLabel();
		JLabel incorrect = new JLabel();
		JPanel topPanel = new JPanel();
		JLabel blanks = new JLabel();
		JLabel space = new JLabel();
		JLabel guess = new JLabel();
		JTextField textfield = new JTextField();
		textfield.addKeyListener(this);
		
		incorrect.setText(" Strikes: " + strikes);
		letters.setText("<html> Incorrect: <br/>" + incorrectLetters + "</html>");
		guess.setText("Guess: ");
		textfield.setPreferredSize(new Dimension(25, 25));
		
		frame.add(masterPanel);
		masterPanel.add(topPanel);
		masterPanel.add(middlePanel);
		masterPanel.add(bottomPanel);
		masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.PAGE_AXIS));

		addAll(topPanel, letters, image, incorrect);
		addAll(middlePanel, space, blanks);
		addAll(bottomPanel, guess, textfield);

		
		frame.setSize(new Dimension(250, 200));
		
		String text = "";
		
		for(int i = 0; i< word.length(); i++) {
			text = text + "_ ";
		}
		//add images
		/*if() {
			
		}*/
		image.setIcon(loadImage(0));
		image.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		blanks.setText(text);
		blanks.setAlignmentX(Component.CENTER_ALIGNMENT);
		space.setText("  ");

	}

	
	public ImageIcon loadImage(int num) {
		String hangmanfile = "Hangman_" + num + ".jpg";
		try {
			return new ImageIcon(ImageIO.read(new Hangman().getClass().getResourceAsStream(hangmanfile)));
		} catch (IOException e) {

			return null;
		}
	}
	
	public void updateScores () {
		
	}
	
	public void addAll (Container container, Component... components) {
		for(int i  = 0; i <components.length; i++) {
			container.add(components[i]);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
