package _03_Hangman;

public class HangmanRunner {
	public static void main(String[] args) {
		Hangman hm = new Hangman();
		Utilities utilities = new Utilities();
		hm.setup(utilities);
	}
}
