package _03_Hangman;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
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
	
	Stack<String> words = new Stack<String>();
	StringBuilder text;
	String word = "";
	JTextField textfield;
	JLabel incorrect;
	String incorrectLetters;
	JLabel letters;
	JLabel image;
	JFrame frame;
	int hp;
	
	
	public void setup(Utilities utilities) {
		
		String rounds = JOptionPane.showInputDialog("Enter the number of rounds you would like to attempt (1-266): ");
		int r = Integer.parseInt(rounds);
		
		
		for(int i = 0; i<r; i++) {
			String random = utilities.readRandomLineFromFile("dictionary.txt");
			
			while(words.contains(random)) {
				random = utilities.readRandomLineFromFile("dictionary.txt");
			}
			//System.out.println(random);
			words.add(random);
			
		}
		System.out.println(words);
		word = words.pop();
		createDisplay(word);
	}
	
	JLabel blanks = new JLabel();
	
	 void createDisplay(String word) {
		 
		 text = new StringBuilder("");
		 
		 System.out.println(word);
		 hp = 6;
		 incorrectLetters = "";
		 
		frame = new JFrame();
		frame.setVisible(true);
		JPanel masterPanel = new JPanel();
		JPanel middlePanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		image = new JLabel();
		letters = new JLabel();
		incorrect = new JLabel();
		JPanel topPanel = new JPanel();
		
		JLabel space = new JLabel();
		JLabel guess = new JLabel();
		textfield = new JTextField();
		textfield.addKeyListener(this);
		
		incorrect.setText(" HP: " + hp);
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
		
		
		System.out.println("brown word: "+ word);
		for(int i = 0; i< word.length(); i++) {
			
			text = text.append("_ ");
					//+ "_ ";
		}
		
		image.setIcon(loadImage(6));
		image.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		blanks.setText(text.toString());
		blanks.setAlignmentX(Component.CENTER_ALIGNMENT);
		space.setText("  ");

	}

	
	public ImageIcon loadImage(int num) {
		String hangmanfile = "Hangman_" + num + ".jpg";
		//System.out.println(hangmanfile);
		try {
			return new ImageIcon(ImageIO.read(new Hangman().getClass().getResourceAsStream(hangmanfile)));
		} catch (IOException e) {

			return null;
		}
	}
	
	public void updateDisplay() {
		textfield.setText("");
		blanks.setText(text.toString());
		incorrect.setText(" HP: " + hp);
		letters.setText("<html> Incorrect: <br/>" + incorrectLetters + "</html>");
		image.setIcon(loadImage(hp));
		if(hp == 0) {
			System.out.println("GAME OVER DEAD");
		
		  int response = JOptionPane.showOptionDialog(frame, "Would you like to play again?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, loadImage(hp), null, 0);
		  if(response == 0) {
			  //yes
			  frame.dispose();
			  Utilities utilities = new Utilities();
			  setup(utilities);
			  
		  }
		  else {
			  //no
			  frame.dispose();
		  }
		}
		else if(!text.toString().contains("_ ")) {
			
			
			frame.dispose();
			if(words.size()>0) {
				JOptionPane.showMessageDialog(frame, "GREAT JOB!  \nWord: " + word + " \nClick OK to proceed to the next round");
				System.out.println(words);
				word = words.pop();
				System.out.println("word:  " + word);
				createDisplay(word);
			}
			else {
				JOptionPane.showMessageDialog(frame, "CONGRATULATIONS! You won all the rounds.");
				//System.out.println("NO MORE WORDS!!!!");
			}
			//System.out.println("NEXT ACTION");
		}
	}
	

	
	public void addAll (Container container, Component... components) {
		for(int i  = 0; i <components.length; i++) {
			container.add(components[i]);
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		boolean correct = false;
		//System.out.println("yes1: " + e.getKeyChar());
		char[] wordChar = word.toCharArray();
		
		//System.out.println(wordChar.length);
		for(int i = 0; i<wordChar.length; i++) {
			//System.out.println("hi: "+ wordChar[i]);
			String c = "" + e.getKeyChar();
		if(e.getKeyChar()==(wordChar[i])){
			correct = true;
			//System.out.println("yes2");
			
			//System.out.println("letter: " + e.getKeyChar());
			
			
			text.replace(i*2, (i*2)+1, c);

			//System.out.println("text: " + text);
	
		}
	
		}
		
			if(!correct) {
				System.out.println("INCORRECT LETTER!!!");
				hp -= 1 ;
				incorrectLetters += e.getKeyChar() + ", ";
			}
		
		updateDisplay();
		
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
