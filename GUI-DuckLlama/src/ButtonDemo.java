import java.awt.event.*;
import javax.swing.*;

/** 
 * This Demo is adabted from Sun's Demo tutorial in 
 * http://docs.oracle.com/javase/tutorial/uiswing/examples/components/ButtonDemoProject/src/components/ButtonDemo.java
 * ButtonDemo.java requires the following files:
 *   images/duck.gif
 *   images/lama.gif
 */
public class ButtonDemo extends JFrame {
	   // Class constructor creates the frame and sets the frame main operations. 
	    public ButtonDemo() {
	       super("Llama/Duck Buttons");
	       
	       //create the ButtonDemoPanel and add it to the frame
	        this.add(new ButtonDemoPanel2());
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       //Display the window.
	        this.pack();
	        this.setVisible(true);
	    }
	
	    public static void main(String[] args) {
	                new ButtonDemo();
	    }
	}