/*

James Webb

February 27, 2015

Lab 4 homework

duck llama game
*/


import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Random;



public class llamaDuck extends JPanel{
	
	private JButton bDuck,bImage, bLlama, bScore, bGameOver, bRestart;
  private final JLabel label;
  private final JLabel countDownLabel;
  private final JLabel scoreLabel;

  public int randomIntCounter;
  public final int tempInt;

  private Timer timer = new Timer(60000, null);
  private int timerCount = 59;
  private int score;

 /**
  * Class constructor creates and defines the buttons.
  */
   public llamaDuck(){
      super();
      
      ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();   //array list of image icons
      for (int i = 1; i < 7; i++){
        ImageIcon duckButtonIcon1 = createImageIcon("images/duck" + i + ".jpg", "duck");
        images.add(duckButtonIcon1);
        ImageIcon llamaButtonIcon1 = createImageIcon("images/llama" + i + ".jpg", "llama");
        images.add(llamaButtonIcon1);
      }


      int randomIntCounter = 0;
      Random randomNo = new Random();                       //gets a random integer and uses it to select the index of a random picture form the array
      randomIntCounter = randomNo.nextInt(images.size());
      tempInt = randomIntCounter;


      label = new JLabel("Select the duck or the llama button depending on what appears", SwingConstants.CENTER);
      countDownLabel = new JLabel("Time", SwingConstants.CENTER);

      JPanel main = new JPanel(new BorderLayout());    //makes a main panel using borderLayout

      JPanel grid = new JPanel(new GridLayout(0,2));    //makes a seconday panel with a grid layout
    

      bDuck = new JButton("Duck");                            //create a button for duck
      bDuck.setVerticalTextPosition(AbstractButton.CENTER);
      bDuck.setMnemonic(KeyEvent.VK_D);
      bDuck.setActionCommand("disable");

      bImage = new JButton(images.get(randomIntCounter));                  //creates a button for llama
      bImage.setVerticalTextPosition(AbstractButton.BOTTOM);
      bImage.setHorizontalTextPosition(AbstractButton.CENTER);
    

      bLlama = new JButton("Llama");
      bLlama.setActionCommand("enable");
      bLlama.setMnemonic(KeyEvent.VK_L);

      timer = new Timer(1000, new ActionListener(){           //a basic timer
          @Override
          public void actionPerformed(ActionEvent e) {
              timerCount--;
              if (timerCount == 0) {
                timer.stop();
                bDuck.setEnabled(false);                      //sets the buttons on or off depending on what you can do when the game ends
                bLlama.setEnabled(false);
                bRestart.setEnabled(true);
                bGameOver.setText("Game Over!");
              }

              countDownLabel.setText("Time: " + String.valueOf(timerCount));        //updates the timer
          }
      });
      timer.start();

      score = 0;
      scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);

      bGameOver = new JButton("Begin!");

      bRestart = new JButton("Want to Restart?");
      bRestart.setEnabled(false);

      bRestart.addActionListener(new ActionListener(){       //restarts the score and the timer
        public void actionPerformed(ActionEvent event){
          bRestart.setEnabled(false);

          timerCount = 59;
          timer.start();

          score = 0;
          scoreLabel.setText("Score: " + String.valueOf(score));
          bDuck.setEnabled(true);
          bLlama.setEnabled(true);
          bGameOver.setText("Begin!");
        }
      });
      
      //Listen for actions on buttons 1 and 3.
      bDuck.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent event){
       
         if (images.get(tempInt).getDescription() == "duck"){
            score = score + 1;
          }else if (images.get(tempInt).getDescription() == "llama"){
            score = score - 1;
          }
          else{
            System.out.println("That was not a llama or a duck");
          }

          scoreLabel.setText("Score: " + String.valueOf(score));        //prints out the current score after click
		      int i = 0;
          Random randomNo = new Random();                  //gets a random integer and uses it to select the index of a random picture form the array
          i = randomNo.nextInt(images.size());
          bImage.setIcon(images.get(i));
        }
		  });
       
      bLlama.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent event){
			    int i = 0;
          Random randomNo = new Random();                  //gets a random integer and uses it to select the index of a random picture form the array
          i = randomNo.nextInt(images.size());
          bImage.setIcon(images.get(i));
          if (i >= 7){                                    //picture is of a llama
            score = score + 1;
            System.out.println("it was a llama");
          } else {
            score = score - 1;
            System.out.println("it wasnt a llama");
          }

          scoreLabel.setText("Score: " + String.valueOf(score));      //prints out the current score after click
		    }
		  });

      //Adds Components to the various panels being used

      this.add(main);
      main.add(label, BorderLayout.PAGE_START);
      main.add(bDuck, BorderLayout.LINE_START);
      main.add(bImage, BorderLayout.CENTER);
      main.add(bLlama, BorderLayout.LINE_END);
      main.add(grid, BorderLayout.PAGE_END);


      grid.add(scoreLabel);
      grid.add(bGameOver);
      grid.add(bRestart);
      grid.add(countDownLabel);

   }




   /** Returns an ImageIcon, or null if the path was invalid. 
    * A good encapsulation for the validation and retrival of the image file. error */
   private static ImageIcon createImageIcon(String path, String desc) {
       java.net.URL imgURL = appLlamaDuck.class.getResource(path);
       if (imgURL != null) {
           return new ImageIcon(imgURL);
       } else {
           System.err.println("Couldn't find file: " + path);
           return null;
       }
   }


}
