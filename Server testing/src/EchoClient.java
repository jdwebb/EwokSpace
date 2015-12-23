import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class EchoClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String hostName = "10.111.108.191";
		int portNumber = 4321;
		Socket echoSocket = new Socket(hostName, portNumber);
		
		PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		
		String userInput;
		do{
			userInput = stdIn.readLine();
			out.println(userInput);
			out.flush();
			System.out.println("Husband says : "+in.readLine());
		} 
		while (!userInput.equals("Bye")); {
			echoSocket.close();
			in.close();
			out.close();
			stdIn.close();
		}
	}

}
