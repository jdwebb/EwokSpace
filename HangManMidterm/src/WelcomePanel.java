import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*Hangman Midterm
 * 
 * 4/5/15
 * 
 * Project by:  Qaisha Closeil, Tyler Dresslehouse, and Jim Webb
 * 
 */

public class WelcomePanel extends JPanel{

	private ImageIcon hang;
  private JLabel sign;
  private JButton start, option;


	public WelcomePanel(){
    setLayout(new BorderLayout());
	hang = new ImageIcon("hang1.jpg");
    sign = new JLabel(hang);
    add(sign, BorderLayout.NORTH);

    JButton start = new JButton("Start");
    start.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         new HangmanFrame(new HangmanModel());
         //HangmanPanel hp = new HangmanPanel();
         //hp.setVisible(true);
         //hp.pack();
        
       }
     });

    add(start, BorderLayout.WEST);


     JButton option = new JButton("Options");
      option.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         
         OptionPanel op = new OptionPanel();
         op.setVisible(true);
         op.pack();
        
       }
     });
      add(option, BorderLayout.EAST);
    }




}