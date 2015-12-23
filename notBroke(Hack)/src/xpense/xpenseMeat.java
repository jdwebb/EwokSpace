package xpense;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.lang.Math;

public class xpenseMeat {
	//this is the meat of the program that will control most if not all of the information input
	Scanner sc = new Scanner(System.in);
	public ArrayList<String> expenseArrayS;
	public ArrayList<String> incomeArrayS;
	public ArrayList<String> expenseArrayI;
	public ArrayList<String> incomeArrayI;
	
	private int totalIncome = 0;
	private int totalExpense = 0;
	private int netRev;
	
	public ArrayList expenseArrayS(int i){	//creates an expense array with strings and one with integers and initializes them
		//System.out.println("Create an expense array of "+ i +" values");
		ArrayList<String> expenseArrayS = new ArrayList(i);
		for (int j = 0 ; j < i ; j++) {
			expenseArrayS.add(j, "hello");
			//System.out.println("String expense array has been initialized");
		}
		return expenseArrayS;
	}
	
	
	public ArrayList<Integer> expenseArrayI(int i){
		ArrayList<Integer> expenseArrayI = new ArrayList<Integer>(i);
		for (int j = 0 ; j < i  ; j++) {
			expenseArrayI.add(j, 32);
		}
		//System.out.println("int expense array has been initialized");
		return expenseArrayI;

	}
	
	public void addExpenses(ArrayList a, ArrayList b){	//adds expenses to the array of expenses
		//System.out.println("I dont understand the problem");
		//System.out.println(b.size());
		for (int i = 0; i < b.size(); i++) {
			System.out.println("Please input the type of expense followed by the amount");
			String exp = sc.next();
			a.set(i, exp);
			String value1 = sc.next();
			b.set(i, value1);
			System.out.println("Expense is "+ exp + " with a value of $"+ value1);		
		}
	}
	
	public ArrayList incomeArrayS(int i){	//creates an expense array with strings and one with integers and initializes them
		//System.out.println("Create an expense array of "+ i +" values");
		ArrayList<String> expenseArrayS = new ArrayList(i);
		for (int j = 0 ; j < i ; j++) {
			expenseArrayS.add(j, "hello");
			//System.out.println("String expense array has been initialized");
		}
		return expenseArrayS;
	}
	
	
	public ArrayList<Integer> incomeArrayI(int i){
		ArrayList<Integer> expenseArrayI = new ArrayList<Integer>(i);
		for (int j = 0 ; j < i  ; j++) {
			expenseArrayI.add(j, 32);
		}
		//System.out.println("int expense array has been initialized");
		return expenseArrayI;

	}
	
	public void addIncome(ArrayList a, ArrayList b){	//adds expenses to the array of expenses
		//System.out.println("I dont understand the problem");
		//System.out.println(b.size());
		for (int i = 0; i < b.size(); i++) {
			System.out.println("Please input the type of income followed by the amount");
			String exp = sc.next();
			a.set(i, exp);
			String value1 = sc.next();
			b.set(i, value1);
			System.out.println("Income is "+ exp + " with a value of $"+ value1);		
		}
	}
	
	
	public void netExpense(ArrayList c){
		for(int i = 0; i < c.size(); i++){
			totalExpense += Integer.parseInt((String) c.get(i));	
		}
		System.out.println("Total monthly expenses $" + totalExpense);	
	}
	
	public void showExpense(ArrayList g, ArrayList h){
		for(int i = 0; i < g.size(); i++){
			System.out.println(g.get(i) + " " + h.get(i));
		}
	}
	
	public void showIncome(ArrayList g, ArrayList h){
		for(int i = 0; i < g.size(); i++){
			System.out.println(g.get(i) + " " + h.get(i));
		}
	}
	
	public void netIncome(ArrayList c){
		for(int i = 0; i < c.size(); i++){
			totalIncome += Integer.parseInt((String) c.get(i));	
		}
		System.out.println("Total monthly income $" + totalIncome);	
	}
	
	public void netRev(){
		netRev = totalIncome - totalExpense;
		System.out.println("Your monthly cashflow is $" + netRev);
	}
	public int getNetRev(){
		return netRev;
	}
}
