package _03_Hangman;

import java.awt.Dimension;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {
	

	public void setup(Utilities utilities) {
		
		String rounds = JOptionPane.showInputDialog("Enter the number of rounds you would like to play (1-266): ");
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
	
	static void createDisplay(String word) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		
		frame.add(panel);
		panel.add(label);
		frame.setSize(new Dimension(300, 400));
		
		String text = "";
		for(int i = 0; i< word.length(); i++) {
			text = text + "_ ";
		}
		//add images
		label.setText(text);
	}

	
	
}
