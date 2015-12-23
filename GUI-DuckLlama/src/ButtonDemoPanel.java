import java.awt.event.*;
import javax.swing.*;



public class ButtonDemoPanel extends JPanel{
	
	private JButton bDuck,bImage, bLlama;

 /**
  * Class constructor creates and defines the buttons.
  */
   public ButtonDemoPanel(){
	   ImageIcon duckButtonIcon = createImageIcon("images/duck.gif");
       ImageIcon lammaButtonIcon = createImageIcon("images/lamma.gif");
   

       bDuck = new JButton("Duck"); //create a button for duck
       bDuck.setVerticalTextPosition(AbstractButton.CENTER);
       bDuck.setMnemonic(KeyEvent.VK_D); //??
       bDuck.setActionCommand("disable");

       bImage = new JButton(duckButtonIcon);
       bImage.setVerticalTextPosition(AbstractButton.BOTTOM);
       bImage.setHorizontalTextPosition(AbstractButton.CENTER);
     

       bLlama = new JButton("Llama");
       //Use the default text position of CENTER, TRAILING (RIGHT).
       bLlama.setActionCommand("enable");
       bLlama.setMnemonic(KeyEvent.VK_L);
      
       //Listen for actions on buttons 1 and 3.
       bDuck.addActionListener(createImageButtonListener(duckButtonIcon,bImage));
       bLlama.addActionListener(createImageButtonListener(lammaButtonIcon,bImage));

       
       //Add Components to this container, using the default FlowLayout.
       add(bDuck);
       add(bImage);
       add(bLlama);
   }
   /** Returns an ImageIcon, or null if the path was invalid. 
    * A good encapsulation for the validation and retrival of the image file. error */
   private static ImageIcon createImageIcon(String path) {
       java.net.URL imgURL = ButtonDemo.class.getResource(path);
       if (imgURL != null) {
           return new ImageIcon(imgURL);
       } else {
           System.err.println("Couldn't find file: " + path);
           return null;
       }
   }
   /**
    * Returns an ActionListener anonymous object that is used to display the specific image on 
    * @param image : image to be displayed on the imageButton
    * @param imageButton : JButton used for display
    * @return ActionListener object
    */
   public  ActionListener createImageButtonListener(final ImageIcon image, final JButton imageButton){
	   return new
			   ActionListener(){
		   public void actionPerformed(ActionEvent event){
			   
			   imageButton.setIcon(image);
		   }
	   };
   }

}
