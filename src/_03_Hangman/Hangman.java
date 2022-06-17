package _03_Hangman;

import java.awt.Component;
import java.awt.Dimension;
import java.io.IOException;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {
	

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
	
	static void createDisplay(String word) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		JPanel panel = new JPanel();
		JLabel image = new JLabel();
		JLabel label = new JLabel();
		JLabel space = new JLabel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		frame.add(panel);
		panel.add(image);
		panel.add(space);
		panel.add(label);
		
		frame.setSize(new Dimension(250, 170));
		
		String text = "";
		
		for(int i = 0; i< word.length(); i++) {
			text = text + "_ ";
		}
		//add images
		/*if() {
			
		}*/
		image.setIcon(loadImage(0));
		image.setAlignmentX(Component.CENTER_ALIGNMENT);
		//frame.pack();
		
		label.setText(text);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		space.setText("  ");
		//frame.pack();
	}

	
	public static ImageIcon loadImage(int num) {
		String hangmanfile = "Hangman_" + num + ".jpg";
		try {
			return new ImageIcon(ImageIO.read(new Hangman().getClass().getResourceAsStream(hangmanfile)));
		} catch (IOException e) {

			return null;
		}
	}
	
}
