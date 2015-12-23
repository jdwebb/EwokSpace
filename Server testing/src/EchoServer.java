import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(4321);
		System.out.println("(... expecting connection ...)");
		
		Socket connectionSocket = server.accept();
		System.out.println("(...connection established...)");
		
		PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		
		//BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String inLine;
		
		while (!((inLine = in.readLine()).equals("Bye"))){
			System.out.println("Wife says" + inLine);
			out.println(inLine);
			out.flush();
		}
		
		connectionSocket.close();
		server.close();
		out.close();
		//stdIn.close();
	}

}
