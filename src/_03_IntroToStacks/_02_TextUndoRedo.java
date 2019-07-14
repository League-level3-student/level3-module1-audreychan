package _03_IntroToStacks;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */

public class _02_TextUndoRedo implements KeyListener{
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<Character> deleted = new Stack<Character>();
	ArrayList<Character> charText = new ArrayList<Character>();
	String text = "";
	
	public static void main(String [] args) {
		_02_TextUndoRedo undoRedo = new _02_TextUndoRedo();
	}
	
	public _02_TextUndoRedo() {
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		panel.add(label);
		frame.pack();
		
		frame.addKeyListener(this);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int i = e.getKeyCode();
		char c = e.getKeyChar();
		String t = "";
		
		if(i == 8) {
			deleted.push(charText.get(charText.size() - 1));
			charText.remove(charText.size() - 1);
		} 
		else if(i == 92) {
			charText.add(deleted.pop());
		} 
		else {
			charText.add(c);
		}
		
		for(int m = 0; m < charText.size(); m++) {
			t += charText.get(m);
		}
		text = t;
		label.setText(text);
		frame.pack();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
