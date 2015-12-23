import java.util.Scanner;


public class SequenceAnalyzerDriver {

	public static void main (String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first sequence (no white space between sequences is allowed).");
		String s1 = scanner.nextLine();
		System.out.println("Enter second sequence (no white space between sequences is allowed).");
		String s2 = scanner.nextLine();
		
		ISequenceAnalyzer seqAnalyzer = new ISequenceAnalyzer();
		int[][] lengths = new int[s1.length()+1][s2.length()+1];
		char[][] pointers = new char[s1.length()+1][s2.length()+1];
		System.out.println("The LCS has length: " + seqAnalyzer.lengthLCS(s1, s2, lengths, pointers));
		System.out.print("The LCS is: ");
		seqAnalyzer.printLCS(pointers, s1, s1.length(), s2.length());
		
		scanner.close();
	}

}
