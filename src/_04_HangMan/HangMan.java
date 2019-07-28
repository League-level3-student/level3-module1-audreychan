package _04_HangMan;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel winAndLose = new JLabel();
	
	int lives;
	char typed;
	int wins = 0;
	int losses = 0;
	String previousWord;
	
	Stack<String> words = new Stack<String>();
	ArrayList<Character> letters = new ArrayList<Character>();
	ArrayList<String> blanks = new ArrayList<String>();
	
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
		
		label.setPreferredSize(new Dimension(250, 30));
		winAndLose.setPreferredSize(new Dimension(250, 30));
		frame.setPreferredSize(new Dimension(300, 100));
		
		frame.add(panel);
		panel.add(label);
		panel.add(winAndLose);
		frame.pack();
		
		frame.addKeyListener(this);
		
		play();
	}
	
	void play() {
		previousWord = "";
		for(int i = 0; i < letters.size(); i++) {
			previousWord += letters.get(i) + "";
		}
	
		blanks.clear();
		letters.clear();
		
		if(words.size() > 0) {
			
			String word = words.pop();
			lives = 6;
			
			for(int i = 0; i < word.length(); i++) {
				blanks.add("_");
				letters.add(word.charAt(i));
			}
			
			updateBlanks();
		}
	}
	
	void updateBlanks() {
		String displayBlanks = "";
		for(int i = 0; i < blanks.size(); i++) {
			displayBlanks += blanks.get(i) + " ";
		}
		label.setText(displayBlanks + " | " + previousWord);
		frame.pack();
		updateWinAndLose();
	}
	
	void updateWinAndLose() {
		if(checkWinner() == true) {
			wins++;
			play();
		}
		winAndLose.setText("Wins: " + wins + "   Losses: " + losses + "   Lives: " + lives);
		frame.pack();
	}
	
	boolean checkWinner() {
		for(int i = 0; i < blanks.size(); i++) {
			if(blanks.get(i).equals("_")) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		typed = e.getKeyChar();
		boolean gotLetter = false;
		
		for(int i = 0; i < letters.size(); i++) {
			if(letters.get(i) == typed) {
				blanks.set(i, letters.get(i) + "");
				gotLetter = true;
			}
		}
		
		updateBlanks();
		
		if(gotLetter == false) {
			lives --;
			updateWinAndLose();
		}
		if(lives == 0) {
			losses ++;
			updateWinAndLose();
			play();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
