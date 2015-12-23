import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*Hangman Midterm
 * 
 * 4/5/15
 * 
 * Project by:  Qaisha Closeil, Tyler Dresslehouse, and Jim Webb
 * 
 */

public class OptionPanel extends JFrame{
	
  private JLabel title, difficulty, letter, guesses, value1, value2, value3;
  private JSlider slider1, slider2, slider3;
  public static int num1, num2, num3;


	public OptionPanel(){
    setLayout(new GridLayout(10,1));
	//hang = new ImageIcon(getClass().getResource("hang1.jpg"));
   // sign = new JLabel(hang);
   // add(sign, BorderLayout.NORTH);


    title = new JLabel("Options");
    title.setHorizontalAlignment(JLabel.CENTER);
    add(title);


    difficulty = new JLabel("Difficulty");
    add(difficulty);

   
    //slider for difficulty
    slider1 = new JSlider(JSlider.HORIZONTAL,0,3,0);
    slider1.setMajorTickSpacing(5);
    add(slider1);
    event e = new event();
    slider1.addChangeListener(e);
     //displays value for difficulty
    value1 = new JLabel("");
    value1.setHorizontalAlignment(JLabel.RIGHT);
    add(value1);


    letter = new JLabel("Letters");
    add(letter);
    //slider for difficulty
    slider2 = new JSlider(JSlider.HORIZONTAL,0,28,0);
    slider2.setMajorTickSpacing(5);
    //slider1.setPaintTicks(true);
    add(slider2);
    event e1 = new event();
    slider2.addChangeListener(e1);

     //displays value for difficulty
    value2 = new JLabel("");
    value2.setHorizontalAlignment(JLabel.RIGHT);
    add(value2);


    guesses = new JLabel("Guesses");
    add(guesses);

    //slider for difficulty
    slider3 = new JSlider(JSlider.HORIZONTAL,0,20,0);
    slider3.setMajorTickSpacing(5);
    add(slider3);
    event e2 = new event();
    slider3.addChangeListener(e2);

     //displays value for difficulty
    value3 = new JLabel("");
    value3.setHorizontalAlignment(JLabel.RIGHT);
    add(value3);
   
}
 
  public class event implements ChangeListener{
    public void stateChanged(ChangeEvent e1){
      num1 = slider1.getValue();
      value1.setText(" " + num1);   //difficulty

       num2 = slider2.getValue();
      value2.setText(" " + num2);	//length of word

       num3 = slider3.getValue();
      value3.setText(" " + num3);	//number of guesses
    }


  }

}