package animation;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
   A car that can be moved around.
* @author Ruby El Kharboulty 
 * @version 1.0
 * @date 11/15/2013
 */ 
//Edited and adapted by Brian Gill for the spaceship program, Lab5
//The goal is to create a ufo abducting a man that will bounce off the walls of a java frame.
public class spaceShape 
{
   
	
    public int x; //the left of the bounding rectangle of the shape
	public int y; //the top of the bounding rectangle  
    private int width; //the width of the bounding rectangle
	
   Boolean goRight = new Boolean(false); //a variable that indicates the direction the shape shall move in, false being left


    
    Ellipse2D.Double body; //the main ufo
    Ellipse2D.Double dome; //the top of the ufo
    Rectangle2D.Double tractor; // the tractor beam
    Line2D.Double triangle1; //forms the triangle
    Line2D.Double triangle2; //forms the triangle
    Line2D.Double antenna;
    Ellipse2D.Double guyHead; //the head of the abductee
    Line2D.Double guyBody;
    Line2D.Double guyArms;
    ShapePanel panel;
   
    public spaceShape(int x, int y, int width,ShapePanel panel) //creates the bounding rectangle of the entire shape.
   {
      this.x = x;
      this.y = y;
      this.width = width;
      this.panel = panel;
      
     body = new Ellipse2D.Double(x, y, width, width / 3);
     dome = new Ellipse2D.Double(x + width/3 , y - width/3, width/3, width/3 );
     guyHead = new Ellipse2D.Double(x + width/3, y + width*2/3, width/6, width/6);
     tractor = new Rectangle2D.Double(x +width*5/12, y+width/3, width/6, width/6);
     this.makeBottom();
   }
 
   public void makeBottom(){
	// Creates two lines that meet at the same point, at the abductee's head.
	      Point2D.Double r1
	            = new Point2D.Double(x+ width / 3, y + width / 3);
	      Point2D.Double r2
	            = new Point2D.Double(x + width / 2, y+ width*2 /3);
	      Point2D.Double r3
	            = new Point2D.Double( x+ width *2 / 3, y + width / 3);

	      Point2D.Double neck = new Point2D.Double(x+ width*14.5/30, y + width*5/6);
	      Point2D.Double waist = new Point2D.Double(x+ width*14.5/30, y + width);
	      
	      Point2D.Double leftHand = new Point2D.Double(x + width/3, y+ width *11/12);
	      Point2D.Double rightHand = new Point2D.Double(x + width*2/3, y+ width *11/12);

	     guyArms = new Line2D.Double(leftHand, rightHand);
	     guyBody = new Line2D.Double(neck, waist);
	     triangle1 = new Line2D.Double(r1, r2);
	     triangle2 = new Line2D.Double(r3, r2);
	       
   }
   /**
    *  causes the spaceship to move by advancing the x and y location of the seperate shapes.
    */
   public void translate(int dx, int dy)
   {
	  if (goRight == true) { //move right
	x = x + dx;
	y = y + dy;}
	  if (goRight == false){ //move left
		  x = x- dx;
	      y = y + dy;
	  }
	  body.setFrame(x, y, width, width / 3);
      dome.setFrame(x + width/3 , y-width/6, width/3, width/3);     
      guyHead.setFrame(x + width* 2/5, y + width*2/3, width/6, width/6);
      tractor.setFrame(x +width*5/12, y+width/3, width/6, width/6);
      this.makeBottom();
      if (x < 0){ //if this move has gone too far left, bring it back in and get it going right.
    	  goRight = true;
    	  x = 1;
      }
      if (x + width > panel.getWidth()){ //if this move has gone too far right, bring it back and get it going left.
    	  goRight = false;
    	  x = panel.getWidth() - 1 - width;
      }
   }
   
   

   /**
    * Display all spacehip parts. 
    * */
   public void draw(Graphics2D g2, Color top, Color bottom, Color guy)
   { 
	  g2.setColor(top);
      g2.draw(body);
      g2.fill(body);
      g2.draw(dome);
      g2.fill(dome);
      g2.setColor(bottom);
      g2.draw(triangle1);
      g2.draw(triangle2);
      g2.draw(tractor);
      g2.fill(tractor);
      g2.setColor(guy);
      g2.draw(guyHead);
      g2.draw(guyBody);
      g2.draw(guyArms);
   }
  
  
   
 
}
