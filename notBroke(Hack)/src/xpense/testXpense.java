package xpense;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;


public class testXpense {
	

	public static void main(String[] args) {
        
        JFrame frame = new JFrame("Manage Finances Like A Boss");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 700);

        xpenseFrame demo = new xpenseFrame();
        demo.addComponentToPane(frame.getContentPane());

	    frame.setVisible(true);
		
		System.out.println("Welcome to your financial management application");
		System.out.println("Please specify how many expenses you have during a month.");
		Scanner sc = new Scanner(System.in);
		
	    int i = sc.nextInt();
		xpenseMeat meat = new xpenseMeat();
		ArrayList oneExp = meat.expenseArrayS(i);
		ArrayList oneVal = meat.expenseArrayI(i);
		
		meat.addExpenses(oneExp, oneVal);
			
		meat.netExpense(oneVal);
		

		
		System.out.println("Please specify how many sources of income you have during a month.");
		int j = sc.nextInt();
		ArrayList oneIncome = meat.incomeArrayS(j);
		ArrayList twoIncome = meat.incomeArrayI(j);
		
		meat.addIncome(oneIncome, twoIncome);
		meat.netIncome(twoIncome);
		meat.netRev();
		
		if(meat.getNetRev() < 0){
			System.out.println("Would you like some suggestions to help you save money  (yes/no)");
			String o = sc.next();
			//System.out.println(o);
			if(o.equalsIgnoreCase("no")){
				System.out.println("Well fine then");
			}else{
				System.out.println("Start using coupons");
			}
		}
		System.out.println("Would you like to see a list of your revenue   (yes/no)");
		String u = sc.next();
		
		if(u.equalsIgnoreCase("yes")){
			System.out.println("Expenses:");
			meat.showExpense(oneExp, oneVal);
			System.out.println("");
			System.out.println("Income:");
			meat.showIncome(oneIncome, twoIncome);
		}
	}

}
