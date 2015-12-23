import javax.swing.*;

/*Hangman Midterm
 * 
 * 4/5/15
 * 
 * Project by:  Qaisha Closeil, Tyler Dresslehouse, and Jim Webb
 * 
 */

public class HangmanDriver extends JFrame {

	public HangmanDriver(String title) {
		super(title);
		this.add(new WelcomePanel());
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public static void main(String[] args){
		new HangmanDriver("Hangman");
	}

}