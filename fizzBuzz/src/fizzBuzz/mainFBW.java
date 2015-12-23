package fizzBuzz;

public class mainFBW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j = 32;
		
		
		for (int i = 1; i<j;i++){
			if(i%3 == 0 && i%5 == 0 && i%7 == 0){
				System.out.println("FizzBuzzWoof");
			}
			else if(i%3 == 0 && i%5 == 0){
				System.out.println("FizzBuzz");
			}
			else if(i%3 == 0 && i%7 == 0){
				System.out.println("FizzWoof");
			}
			else if(i%7 == 0 && i%5 == 0){
				System.out.println("BuzzWoof");
			}
			else if(i%3 == 0){
				System.out.println("Fizz");
			}
			else if(i%5 == 0){
				System.out.println("Buzz");
			}
			else if(i%7 == 0){
				System.out.println("Woof");
			}
			else{
				System.out.println(i);
			}
		
		}

	}
}
