
public class fibonacciMain {
	private int first = 0;
	private int second = 1;
	private int third = 0;
	
	
	
	public int fibonacciSeq(int n){
		if(n < 2){
			return 2;
		}
		for(int i = 0; i < n-1; i++){
			third = first + second;
			first = second;
			second = third;
			
			System.out.println(first + "+" + second + "=" + third);
			
//			for(){
//				System.out.println(third);
//			}
//			
		}
		
		
		
		return 100;
	}

	public static void main(String[] args) {
		fibonacciMain fib = new fibonacciMain();
		//fib.fibonacciSeq(4000000);
		fib.fibonacciSeq(15);

	}

}
