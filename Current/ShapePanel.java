package animation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class ShapePanel extends javax.swing.JPanel {
	
	
	private final spaceShape shape; //Spaceshape is polymorphically  declared of interface type MoveableShape.
	private final spaceShape shapeDuo;
	private final int DELAY = 20; // Milliseconds between timer ticks
	private static final int SHIP_WIDTH = 100,PANEL_WIDTH = 1000, PANEL_HEIGHT=1000;
    
	public ShapePanel() {
		   super();	   
		   this.setBackground(java.awt.Color.white);
		   this.setPreferredSize(new java.awt.Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		   this.setSize(new java.awt.Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		   
		   shape = new spaceShape(50, 50, SHIP_WIDTH,this); 
		   shapeDuo = new spaceShape(200, 200, SHIP_WIDTH, this);
		  
		   
		    
		    /** Create a timer object and create an Anonymous class that implements the AcitonListener interface and
		     * the actionPerformed method.Each time the timer ticks, the actionPerformed method is called.
		     **/
		    Timer t = new Timer(DELAY, new
		    ActionListener()
		     {
		       public void actionPerformed(ActionEvent event)
		       {
		    	shape.translate(5, 0);
		    	shapeDuo.translate(8, 0);
		    	 
		          repaint();
		       }
		     });
		    
		     t.start();
		    //if (shape.x > PANEL_WIDTH) shape.goRight = false;
		 	//if (shape.x < 0 ) shape.goRight = true;

	}
	public void paintComponent(Graphics g) {
		   super.paintComponent(g);
		   Graphics2D brush = (Graphics2D) g;
		   
		   shape.draw(brush, Color.BLACK, Color.BLUE, Color.GRAY);
		   brush.setColor(getBackground());
		   shapeDuo.draw(brush, Color.RED, Color.CYAN, Color.MAGENTA);
	}
	
	
	   
}
