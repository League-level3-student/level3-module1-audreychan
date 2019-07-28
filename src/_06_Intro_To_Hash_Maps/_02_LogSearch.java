package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */

public class _02_LogSearch implements ActionListener {
	
	HashMap<Integer, String> log = new HashMap<Integer, String>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton("Add Entry");
	JButton remove = new JButton("Remove Entry");
	JButton search = new JButton("Search by ID");
	JButton	view = new JButton("View List");
	
	public static void main(String[] args) {
		_02_LogSearch logSearch = new _02_LogSearch();
		//logSearch.setup();
	}
	
	public _02_LogSearch() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add.addActionListener(this);
		remove.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		
		frame.add(panel);
		panel.add(add);
		panel.add(remove);
		panel.add(search);
		panel.add(view);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton pressed = (JButton) e.getSource();
		if(pressed.equals(add)) {
			String idString = JOptionPane.showInputDialog("Enter an ID.");
			int id = Integer.parseInt(idString);
			String name = JOptionPane.showInputDialog("Enter their name.");
			log.put(id, name);
		}
		else if(pressed.equals(remove)) {
			String idString = JOptionPane.showInputDialog("Enter an ID.");
			int id = Integer.parseInt(idString);
			String name = log.get(id);
			if(name == null) {
				JOptionPane.showMessageDialog(null, "Sorry, that user does not exist.");
			}
			else {
				JOptionPane.showMessageDialog(null, name + " has been removed.");
				log.remove(id);
			}
		}
		else if(pressed.equals(search)) {
			String idString = JOptionPane.showInputDialog("Enter an ID.");
			int id = Integer.parseInt(idString);
			String name = log.get(id);
			if(name == null) {
				JOptionPane.showMessageDialog(null, "Sorry, that user does not exist.");
			} 
			else {
				JOptionPane.showMessageDialog(null, "ID #" + id + ": " + name);
			}
		}
		else if(pressed.equals(view)) {
			Object[] idList = log.keySet().toArray();
			String list = "";
			for(int i = 0; i < idList.length; i++) {
				list += "ID #" + idList[i] + ": " + log.get(idList[i]) + "\n";
			}
			JOptionPane.showMessageDialog(null, list);
		}
	}
	
}
