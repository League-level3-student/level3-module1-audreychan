package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addName = new JButton("Add Name");
	JButton viewNames = new JButton("View Names");
	
	ArrayList<String> names = new ArrayList<String>();
	
	public static void main (String[] args) {
		_02_GuestBook guestBook = new _02_GuestBook();
		guestBook.setup();
	}
	
	void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		panel.add(addName);
		panel.add(viewNames);
		
		addName.addActionListener(this);
		viewNames.addActionListener(this);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton pressed = (JButton) e.getSource();
		if(pressed.equals(addName)) {
			String name = JOptionPane.showInputDialog("Add name to guest book:");
			names.add("Guest #" + (names.size() + 1) + ": " + name);
		}
		else if(pressed.equals(viewNames)) {
			String s = "";
			for(String t: names) {
				s += t + "\n";
			}
			JOptionPane.showMessageDialog(null, s);
		}
	}
}
