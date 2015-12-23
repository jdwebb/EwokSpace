import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

public class FindTheLadyPanel extends JPanel{
	   
  private final JLabel label;
  public int score = 0;
 /**
  * Class constructor creates and defines the buttons.
  */
   public FindTheLadyPanel(){
    super();

    ImageIcon cardBack = new ImageIcon("images/back.png");    //creates the images of each card
    ImageIcon four = new ImageIcon("images/4.png");
    ImageIcon ace = new ImageIcon("images/18.png");
    ImageIcon theQueen = new ImageIcon("images/queen.png");

    label = new JLabel("Choose a card", SwingConstants.CENTER);
    
    setLayout(new BorderLayout());

    JPanel cardTable = new JPanel(new BorderLayout());   //main panel holds shuffle and inCenter
    JPanel inCenter = new JPanel();       //sub panel that holds the cards

    JButton joker = new JButton(four);   //creates buttons that act as playing cards
    joker.setActionCommand("disable");
    joker.setEnabled(false);  //  .setEnabled makes it so the card cannot be clicked (false)


    JButton king = new JButton(ace);
    king.setActionCommand("disable");
    king.setEnabled(false);


    JButton queen = new JButton(theQueen);
    queen.setActionCommand("disable");
    queen.setEnabled(false);


    JButton shuffle = new JButton("Shuffle");
    queen.setActionCommand("enable");

    final ArrayList<JButton> threeCards = new ArrayList<JButton>();  //puts the JButton cards into an array

    threeCards.add(joker);
    threeCards.add(king);
    threeCards.add(queen);

    for (JButton jb: threeCards){   //adds the JButton cards in a different order using Collections.shuffle
      inCenter.add(jb);
    }

    this.add(inCenter, java.awt.BorderLayout.CENTER);

    //shuffles the cards from the start  
    Collections.shuffle(threeCards);    //adds the JButton cards in a different order using Collections.shuffle
    for(JButton jb : threeCards){
           inCenter.add(jb);
    }
    System.out.println("Shuffle");

    this.add(shuffle, java.awt.BorderLayout.SOUTH);       //places the shuffle button in the south
    this.add(label, java.awt.BorderLayout.NORTH);       //puts the label in the north


    shuffle.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent event){     //shuffles the cards and flips them over

      Collections.shuffle(threeCards);
        for(JButton jb : threeCards){       //adds the JButton cards in a different order using Collections.shuffle
          inCenter.add(jb);   
        }
         
        joker.setIcon(cardBack);
        joker.setActionCommand("enable");
        joker.setEnabled(true);

        king.setIcon(cardBack);
        king.setActionCommand("enable");
        king.setEnabled(true);

        queen.setIcon(cardBack);
        queen.setActionCommand("enable");
        queen.setEnabled(true);

        shuffle.setText("shuffle");
        System.out.println("Score: " + score);
       }
     });


    queen.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent event){   //if queen is selected score+3
         
        queen.setIcon(theQueen);

        joker.setIcon(cardBack);
        joker.setActionCommand("disable");
        joker.setEnabled(false);

        king.setIcon(cardBack);
        king.setActionCommand("disable");
        king.setEnabled(false);

        shuffle.setText("You win, Play Again?");
        score += 3;
       }
     });

    joker.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent event){  //if not queen score -1 and shows the queen card

        king.setIcon(cardBack);
        king.setActionCommand("disable");
        king.setEnabled(false);

        queen.setIcon(theQueen);
        queen.setActionCommand("disable");
        queen.setEnabled(false);

        joker.setIcon(four);
        shuffle.setText("You LOSE! Play Again?");
        score -= 1;
      }
    });

    king.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent event){     //if not queen score -1 and shows the queen card
        king.setIcon(ace);

        joker.setIcon(cardBack);
        joker.setActionCommand("disable");
        joker.setEnabled(false);

        queen.setIcon(theQueen);
        queen.setActionCommand("disable");
        queen.setEnabled(false);

        shuffle.setText("You LOSE! Play Again?");
        score -= 1;
      }
    });

          
   }
   /** Returns an ImageIcon, or null if the path was invalid. 
    * A good encapsulation for the validation and retrival of the image file. error */
   private static ImageIcon createImageIcon(String path, String desc) {
       java.net.URL imgURL = FindTheLadyPanel.class.getResource(path);
       if (imgURL != null) {
           return new ImageIcon(imgURL,desc);
       } else {
           System.err.println("Couldn't find file: " + path);
           return null;
       }
   }
  
}//end of FindTheLadyPanel
