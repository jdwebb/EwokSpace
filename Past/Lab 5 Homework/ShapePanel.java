

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class ShapePanel extends javax.swing.JPanel {
	
	
	private  MoveableShape shape; //CarShape is polymorphically  declared of interface type MoveableShape. 
	
	private static final int CAR_WIDTH = 100, PANEL_WIDTH = 400, PANEL_HEIGHT=200;
    
	public ShapePanel() {
		   super();	   
		   this.setBackground(java.awt.Color.white);
		   this.setPreferredSize(new java.awt.Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		   this.setSize(new java.awt.Dimension(PANEL_WIDTH, PANEL_HEIGHT));
           
		   shape = new CarShape(50,100,CAR_WIDTH);
   
		   javax.swing.Timer timer = new javax.swing.Timer(10, null);
		  
		   
		   timer.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				   shape.translate(3, 0);
				   repaint();
			   }
		   });
		   
		   timer.start();
	}
	public void paintComponent(Graphics g) {
		   super.paintComponent(g);
		   shape.draw(g);
		 
	}
	
	
	public void translateCar(int dx,int  dy){
		shape.translate(dx, dy);
  }   
}
