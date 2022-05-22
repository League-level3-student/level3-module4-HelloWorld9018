package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
	
	JFrame frame;
	JPanel panel;
	JLabel label;
	boolean ctrHeld;
	boolean undoing;
	
	Stack<Character> deleted = new Stack<Character>();
	
	
	_02_TextUndoRedo(){
		frame = new JFrame();
		frame.setVisible(true);
		panel = new JPanel();
		label = new JLabel();
		frame.add(panel.add(label));
		frame.addKeyListener(this);
		ctrHeld = false;
		undoing = false;
	}
	
	
	
	public static void main(String[] args) {
		_02_TextUndoRedo object = new _02_TextUndoRedo();
		
	}
	
	void deleteKey() {
		String subText = label.getText().substring(0,label.getText().length()-1);
		label.setText(subText);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//String text  = e.getKeyChar() + "";
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode() == 8 & label.getText().length() >= 1) {
			deleted.push(label.getText().charAt(label.getText().length()-1));
			deleteKey();
		}
		else {
			if(e.getKeyCode() != 8 & e.getKeyCode() != 17) {
				
			String text = label.getText() + e.getKeyChar();
			label.setText(text);
	
			}
		}
		
		//System.out.println(label.getText());
		//System.out.println(deleted);
		frame.pack();
		
		if(e.getKeyCode() == 17) {
			ctrHeld = true;
		}
		if(ctrHeld & e.getKeyCode() == 90) {
			//System.out.println();
			System.out.println(e.getKeyCode());
			System.out.println("Undo");
		}
	//HERE: UNDO WORKS, BUT ADDS BLANK CHARACTER ON LABEL FOR SOME REASON
		//MAKE ADD KEY METHOD FOR WHEN UNDOING
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	
}
