import java.awt.*;

import javax.swing.*;
 
/*Hangman Midterm
 * 
 * 4/5/15
 * 
 * Project by:  Qaisha Closeil, Tyler Dresslehouse, and Jim Webb
 * 
 */
 
public class HangmanShape extends JPanel {
     
  //The amount of guesses corresponds to the selection the user makes in the slider

	private static int length = OptionPanel.num3;
    public static final int maximumWrongGuesses = length;
     
    private int baseWidth = 200;
    private int baseHeight = 20;
    private int poleWidth = 20;
     
    private HangmanModel model;
     
    public HangmanShape(HangmanModel model) {
        this.model = model;
        this.setPreferredSize(new Dimension(300, 400)); 
        
    }
    /*
        Whenever the users guesses a letter wrong, each part
        of the hangman shape is drawn accordingly starting
        with the base of the stand and ening with right leg
        of the hangman figure. Once the right leg is drawn,
        the game is over.    
    */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
         
        Color color1 = Color.BLUE;
        Color color2 = Color.YELLOW;
        g.setColor(color1);
         
        switch (model.getWrongGuesses()) {
        case 9:
            drawRightLeg(g, color2);
        case 8:
            drawLeftLeg(g, color2);
        case 7:
            drawRightArm(g, color2);
        case 6:
            drawLeftArm(g, color2);
        case 5:
            drawBody(g, color2);
        case 4:
            drawHead(g, color2);
        case 3:
            drawHeader(g, color1);
        case 2:
            drawPole(g, color1);
        case 1:
            drawBase(g, color1);
        }
    }
       
    //Sets the locations and sizes of the different shapes
       
    private void drawRightLeg(Graphics g, Color color) {
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        int x = getWidth() / 2;
        int y = 240;
        g2d.drawLine(x, y, x + 50, y + 50);
    }
 
    private void drawLeftLeg(Graphics g, Color color) {
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        int x = getWidth() / 2;
        int y = 240;
        g2d.drawLine(x, y, x - 50, y + 50);
    }
         
    private void drawRightArm(Graphics g, Color color) {
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        int x = getWidth() / 2;
        int y = 200;
        g2d.drawLine(x, y, x + 50, y - 50);
    }
 
    private void drawLeftArm(Graphics g, Color color) {
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        int x = getWidth() / 2;
        int y = 200;
        g2d.drawLine(x, y, x - 50, y - 50);
    }
     
    private void drawBody(Graphics g, Color color) {
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        int x = getWidth() / 2;
        int y = 140;
        g2d.drawLine(x, y, x, y + 100);
    }
     
    private void drawHead(Graphics g, Color color) {
        int width = 40;
        int x = (getWidth() - baseWidth) / 2 + baseWidth / 2 - width;
        int y = 100 - width;
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        g2d.drawOval(x, y, width + width, width + width);
    }
     
    private void drawHeader(Graphics g, Color color) {
        int width = baseWidth / 2 + 20;
        int x = (getWidth() - baseWidth) / 2 + baseWidth - width;
        int y = 10;
        g.setColor(color);

        g.fill3DRect(x, y, width, baseHeight, true);
       g.drawLine(x, y, x, y + 40);
    }
     
    private void drawPole(Graphics g, Color color) {
        int height = getHeight() - 20;
        int x = (getWidth() - baseWidth) / 2 + baseWidth;
        int y = 10;
        g.setColor(color);
        g.fill3DRect(x, y, poleWidth, height, true);
    }
     
    private void drawBase(Graphics g, Color color) {
        int x = (getWidth() - baseWidth) / 2;
        int y = getHeight() - baseHeight - 10;
        g.setColor(color);
        g.fill3DRect(x, y, baseWidth, baseHeight, true);
    }
 
}









