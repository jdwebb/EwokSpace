//	James Webb
//
//	SER 210
//
//	Lab 4 Testing class



import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import javax.swing.JFrame;

public class FindTheLadyTest extends JFrame{
	

	public FindTheLadyTest(){		//implements and creates the frame where the panel will go
		super("Find The Lady");
		
		this.add(new FindTheLadyPanel());
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}


	public static void main(String[] args) {

    	new FindTheLadyTest();


	} //end of main

}