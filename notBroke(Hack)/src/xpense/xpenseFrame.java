package xpense;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class xpenseFrame extends JPanel implements ActionListener {	
	
    final static String incomeButtons = "Income page";
    final static String expenseButtons = "Expense page";
    final static String overview = "Overview page";
    final static int extraWindowWidth = 100;
    
    private JButton c1b1;

    private JButton c2b1;

    private JLabel label1;
  
    public void addComponentToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();
 
        //Create the "cards".
        JPanel card1 = new JPanel() {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };
        card1.add(c1b1 = new JButton("Submit Information"));

        
        JPanel card2 = new JPanel();
        
        card2.add(c2b1 = new JButton("Submit Information"));

        
        JPanel card0 = new JPanel();
        label1 = new JLabel("This will contain your updated JTable");
        
        card0.add(label1, BorderLayout.NORTH);
        
        JTable table = new JTable();
        JScrollPane tableContainer = new JScrollPane(table);
        
        card0.add(tableContainer, BorderLayout.CENTER);
        
        
        
        tabbedPane.addTab(overview, card0);
        tabbedPane.addTab(incomeButtons, card1);
        tabbedPane.addTab(expenseButtons, card2);
        
        c1b1.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) { 
        	System.out.println("Generation Graph");
        	
        	}
        });

        c2b1.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) { 
        	System.out.println("Generation Graph");
        	}
        });
        
        pane.add(tabbedPane, BorderLayout.CENTER);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
