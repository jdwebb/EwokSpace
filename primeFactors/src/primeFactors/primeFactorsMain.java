//
//	Jim Webb
//
//	Cryptography Test Help
//	Built for Question 6a
//
//	Reason:  I did not know how to solve it the traditional way
//
//  December 15, 2015

package primeFactors;

import java.util.Scanner;

public class primeFactorsMain {
	
    public static void main(String[] args) {
    	
        System.out.print("Enter Number: ");
        Scanner sc = new Scanner (System.in);			//scanner to read user input because reading from args is annoying to do
        
        int number = sc.nextInt();
        int count;
        
        
        for (int i = 2; i<=(number); i++) {			//outer loop goes through all numbers less than the input number
            count = 0;								//count is effectively 
            
            while (number % i == 0) {				//inner loop checks each number 
                number /= i;
                count++;
                
            }	//end while inner loop
            
            if (count == 1) {
            	System.out.println(i + "**" + count);
            	
            }	//close if statement
            
        }	//end for outer loop
        
    }	//end main
    
}	//end program