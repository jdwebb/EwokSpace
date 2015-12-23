import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;


public class checkBookMain {

	public static void main(String[] args) throws FileNotFoundException {
		
		JFrame frame = new JFrame("The virtual check book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(700, 550);

        CheckBookGUI demo = new CheckBookGUI();
        demo.addComponentToPane(frame.getContentPane());

	    frame.setVisible(true);

		
	}

}
