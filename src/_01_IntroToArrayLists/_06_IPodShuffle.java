package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015
// 1. Use the Song class the play the demo.mp3 file.
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */


public class _06_IPodShuffle implements ActionListener{
	
	ArrayList<Song> songs = new ArrayList<Song>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton playRandom = new JButton("Play Random");
	Random rand = new Random();
	int num = 0;
	
	public static void main(String[] args) {
		_06_IPodShuffle iPod = new _06_IPodShuffle();
		iPod.setup();
	}
	
	public _06_IPodShuffle() {
		songs.add(new Song("Death of a Bachelor.mp3"));
		songs.add(new Song("Thnks fr th Mmrs.mp3"));
		songs.add(new Song("Helena.mp3"));
		songs.add(new Song("Thank You for the Venom.mp3"));
		songs.add(new Song("To the End.mp3"));
		songs.add(new Song("Dead!.mp3"));
		songs.add(new Song("Welcome to the Black Parade.mp3"));
		songs.add(new Song("Na Na Na"));
		
	}

	void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		panel.add(playRandom);
		frame.pack();
		
		playRandom.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		songs.get(num).stop();
		num = rand.nextInt(songs.size() - 1);
		songs.get(num).play();
	}
}