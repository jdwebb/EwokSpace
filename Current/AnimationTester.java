package animation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This program displays an animation of a moving spacehip on a jpanel. 
 * Main concepts : painting graphics and using a timer
 * @author Ruby El Kharboulty 
 * @version 1.0
 * @date 11/15/2013
 **/
@SuppressWarnings("serial")
public class AnimationTester extends JFrame
{
  /**
    Construct an AnimationTester object.
    @param title is the title of the JFrame
  */
   public AnimationTester(String title){
	   super(title);
	   
	   /**Create a ShapePanel object and add it to the frame.
	    */
	   this.add(new ShapePanel());
	    
	    /** Standard code for all graphical apps. 
	     */
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.pack();
	    this.setVisible(true);
              

   }
   
   public static void main(String[] args)
    {
        new AnimationTester("Watch the birdies!");
 
    }
 
 
}