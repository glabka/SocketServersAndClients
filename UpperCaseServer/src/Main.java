import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) {
		int portNumber = Integer.parseInt(args[0]);
		try ( 
			    ServerSocket serverSocket = new ServerSocket(portNumber);
			    Socket clientSocket = serverSocket.accept();
			    PrintWriter out =
			        new PrintWriter(clientSocket.getOutputStream(), true);
			    BufferedReader in = new BufferedReader(
			        new InputStreamReader(clientSocket.getInputStream()));
			) {
			
			String inputLine, outputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println("received: " + inputLine);
		        outputLine = inputLine.toUpperCase();
		        System.out.println("sent: " + outputLine);
		        out.println(outputLine);
		        if (outputLine.equals("STOP"))
		            break;
		    }
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
