import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class mainPage {

	
		public static int j = 1;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		ArrayList secretSanta = new ArrayList();
		
		
		System.out.println("How many people are participating?");
		String tempNum = scanner.next();
		int participantNum = Integer.parseInt(tempNum);
		
		for(int i = 0; i< participantNum; i++){
			System.out.println("Please enter the alias of number: " + j + " participant");
			String tempName = scanner.next();
			j++;
			secretSanta.add(tempName);
		}
		
		long seed = System.nanoTime();
		Collections.shuffle(secretSanta, new Random(seed));
		Collections.shuffle(secretSanta, new Random(seed));	
		
	    for (int i = 0; i < secretSanta.size(); i++)
	    {
	      System.out.print( secretSanta.get(i) + " ");
	    }
	    System.out.println();
	  }

}
