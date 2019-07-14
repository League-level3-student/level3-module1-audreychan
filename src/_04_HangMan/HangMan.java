package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<String> words = new Stack<String>();
	int lives = 6;
	
	public static void main(String[] args) {
		HangMan hangman = new HangMan();
		hangman.setup();
	}
	
	void setup() {
		String numWordsString = JOptionPane.showInputDialog("Enter the number of words (up to " + Utilities.getTotalWordsInFile("dictionary.txt") + ")");
		int numWords = Integer.parseInt(numWordsString);
		String word = "";
		
		for(int i = 0; i < numWords; i++) {
			word = Utilities.readRandomLineFromFile("dictionary.txt");
			if(words.contains(word)) {
				word = Utilities.readRandomLineFromFile("dictionary.txt");
			} else {
				words.push(word);
			}
		}
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		panel.add(label);
		frame.pack();
		
		frame.addKeyListener(this);
		
		newWord();
	}
	
	void newWord() {
		String word = words.pop();
		String blanks = "";
		
		for(int i = 0; i < word.length(); i++) {
			blanks += "_";
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
