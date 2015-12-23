import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckBookGUI extends JPanel implements ActionListener {

	final static String incomeButtons = "Transaction Form";

    final static String overview = "Overview page";
    final static int extraWindowWidth = 100;
    
    private JButton submitBut;
    private JButton loadData;  //load data from a text file
    
    private JLabel OverviewLabel;
    private JLabel name;
    private JLabel firstField;
    private JTextField firstName;
  
    private JLabel lastField;
    private JTextField lastName;
    
    private JLabel type;		//radio buttons for withdraw/ deposit
    private JRadioButton withdrawBut;
    private JRadioButton depositBut;
    
    private JLabel amountField;
    private JTextField amountText;
    
    private JLabel dateField;
    private JTextField dateText;
    
    private JLabel userIDField;
    private JTextField userIDText;
    
    private JButton removeRow;
    private JLabel totalBalance;
    
    private JPanel c0p1;    //card 0 panel 1
    private JPanel c0p2;
    private JPanel c0p3;     //skipped 2 for the jtable
    
    private JPanel p1;		//card 1 panels
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JPanel p5;
    private JPanel p6;
    private JPanel p7;
    
    public String fname;
    public String lname;
    public String typeTran;  //type of transaction
    public String date;
    public String id;
    
    public Double amnt;
    public String amntString;

    private int balance = 0;
    
    private static int HEADER_HEIGHT = 10;
    
    
    
    public void addComponentToPane(Container pane) throws FileNotFoundException {
    	
    	GridLayout experimentLayout = new GridLayout(0,1);
    	
        JTabbedPane tabbedPane = new JTabbedPane();
        
        DefaultTableModel model = new DefaultTableModel();
        
        JTable table = new JTable(model);    
        model.addColumn("First Name");			//ruby check this for me
        model.addColumn("Last Name");
        model.addColumn("Type");
        model.addColumn("Amount");
        model.addColumn("Date");
        model.addColumn("ID");
        TableColumn column = null;
        
        for (int i = 0; i < 6; i++){
        	column = table.getColumnModel().getColumn(i);
        		column.setPreferredWidth(150);
        }
        
        JTableHeader header = table.getTableHeader();				//this is the problem area
        table.setPreferredScrollableViewportSize(new Dimension(500, 50));
        table.setAutoCreateRowSorter(true);
        
        JScrollPane tableContainer = new JScrollPane(table);
        //table.setFillsViewportHeight(true);
        
 
        JPanel card1 = new JPanel() {
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };
        
        JPanel card0 = new JPanel();
        
        card1.add(p1 = new JPanel());	//adding all the panels within the main panel to get desired look
        card1.add(p2 = new JPanel());
        card1.add(p3 = new JPanel());
        card1.add(p4 = new JPanel());
        card1.add(p5 = new JPanel());
        card1.add(p6 = new JPanel());
        card1.add(p7 = new JPanel());
        
              
        OverviewLabel = new JLabel("This will contain a graph of income/ expenses");
        
        
        card0.add(header);
        
        card0.add(table, BorderLayout.SOUTH);
        
        card0.add(c0p1 = new JPanel());
        c0p1.add(OverviewLabel, BorderLayout.NORTH);
        card0.add(c0p3 = new JPanel());
        
        c0p3.add(totalBalance = new JLabel("Balance: $" + Integer.toString(balance)),BorderLayout.SOUTH);
        
        c0p3.add(loadData = new JButton("Load Data"), BorderLayout.SOUTH);
        c0p3.add(removeRow = new JButton("Remove Entree"), BorderLayout.SOUTH);
        
        card0.setLayout(experimentLayout);
        card1.setLayout(experimentLayout);
        
        
        tabbedPane.addTab(overview, card0);
        tabbedPane.addTab(incomeButtons, card1);
        
        p1.add(name = new JLabel("Name:"));
        p2.add(firstField = new JLabel("First:"));
        p2.add(firstName = new JTextField(8));
        
        p2.add(lastField = new JLabel("Last:"));
        p2.add(lastName = new JTextField(8));
        
        p3.add(type = new JLabel("Transaction type:"));
        ButtonGroup group = new ButtonGroup();
        p4.add(withdrawBut = new JRadioButton("Withdraw"));
        p4.add(depositBut = new JRadioButton("Deposit"));
        group.add(withdrawBut);
        group.add(depositBut);
        
        
        p5.add(amountField = new JLabel("Amount:"));
        p5.add(amountText = new JTextField(8));
        
        p6.add(dateField = new JLabel("Date (dd/mm/yy):"));
        p6.add(dateText = new JTextField(8));
        
        p7.add(userIDField = new JLabel("User ID:"));
        p7.add(userIDText = new JTextField(8));
        
        card1.add(submitBut = new JButton("Submit Information"));
        
        String readFName = null,readLName = null, readType = null, readAmnt = null, readDate = null, readID = null;
        
        
        removeRow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) { 			// remove selected row from the model
		            model.removeRow(table.getSelectedRow());
		            totalBalance.setText("Balance: $" + Integer.toString(balance));  
				}	
			}
        });
        
        
        loadData.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent j){

        			try {
        			       File file = new File("abstractData.txt");
        			       Scanner scanner = new Scanner(file);
        			       while (scanner.hasNext()) {
        			    	 
        			         //System.out.println(scanner.next());
        	        			String one = scanner.next();
        	        			String two = scanner.next();
        	        			String three = scanner.next();
        	        			String four = scanner.next();
        	        			String five = scanner.next();
        	        			String six = scanner.next();
        	        			
        	        			amnt = Double.parseDouble(four);
        	        			
        	        			if(three.equals("withdrawal")){
        	        				amnt *= -1;
        	        			}
        	        			
        	        			balance += amnt;
        	        			totalBalance.setText("Balance: $" + Integer.toString(balance));        	        			
        	        			System.out.println(balance);
        			         
        			        	Vector<String> readVector = new Vector();
        			        	readVector.add(one);
        			        	readVector.add(two);
        			        	readVector.add(three);
        			        	readVector.add(four);
        			        	readVector.add(five);
        			        	readVector.add(six);
        			        	model.addRow(readVector);
        			        	
        	        			//System.out.println(one +" "+ two +" "+three+" "+four+" "+five+" "+six);

        			       }
        			       scanner.close();
        			     } catch (FileNotFoundException e) {
        			       e.printStackTrace();
        			     }
        			
        		}
        });
        	
        
        submitBut.addActionListener(new ActionListener(){  			//action listener for the submit button (adds all expenses everywhere)
        	public void actionPerformed(ActionEvent e) { 
	        	//System.out.println("Generating Table");
	        	try{
	        		
		        	fname = firstName.getText();
		        	firstName.setText("");
		        	lname = lastName.getText();
		        	lastName.setText("");
		        	amnt = Double.parseDouble(amountText.getText());  //get double not string
		        	amntString = amnt.toString();
		        	amountText.setText("");
		        	
		        	if(withdrawBut.isSelected()){
		        		amnt *= -1;
		        		typeTran = "withdrawal";
		        		group.clearSelection();
		        	}else{
		        		typeTran = "deposit";
		        		group.clearSelection();
		        	}
		        	
		        	date = dateText.getText();
		        	dateText.setText("");
		        	id = userIDText.getText();
		        	userIDText.setText("");
		        	
		        	balance += amnt;
		        	totalBalance.setText("Balance: $" + Integer.toString(balance));
		        	
		        	System.out.println(balance);
		        	
		        	//System.out.println(fname + lname + typeTran + amntString + date + id);
		        	
		        	Vector<String> victor = new Vector();		//victor the vector
		        	victor.add(fname);
		        	victor.add(lname);
		        	victor.add(typeTran);
		        	victor.add(amntString);
		        	victor.add(date);
		        	victor.add(id);
		        	model.addRow(victor);
		        										//writes to a specific file
		    			try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("abstractData.txt", true)))) {
		    			    out.println(fname + " " + lname + " " + typeTran + " " + amntString + " " + date + " " + id);

		    			}catch (IOException e1) {
		    				System.out.println("Error writting to the file");
		    				System.exit(0);
		    			}
		    			
		        	
	        	}catch(NumberFormatException n){	
	        		System.out.println("Value entered in amount text field threw an exception!");
	        		System.exit(0);
	        	}
	        }
        });
        
        
        pane.add(tabbedPane, BorderLayout.CENTER);
    }
    

    public boolean isCellEditable(int row, int column) {			//trying to stop the cells from being edited in the JTable
        return false;
    }
    
    public void updateBalance(){
    	//while()
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

}
