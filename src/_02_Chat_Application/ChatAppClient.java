package _02_Chat_Application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ChatAppClient {
	public static void main(String[] args) {
		String ipAddress = JOptionPane.showInputDialog("Enter ip address: ");
	    //2. Create an integer for the server's port number
	    int port = Integer.parseInt(JOptionPane.showInputDialog("Enter desired port: "));
	    //3. Surround steps 4-9 in a try-catch block that catches any IOExceptions.
	    try {
	  	 //4. Create an object of the Socket class. When initializing the object, pass in the ip address and the port number
	    	Socket socks = new Socket(ipAddress, port);
		  	for (int i = 0; i < 10; i++) {
				DataInputStream input = new DataInputStream(socks.getInputStream());
				DataOutputStream output = new DataOutputStream(socks.getOutputStream());
				String outputText = JOptionPane.showInputDialog(input.readUTF());
				output.writeUTF(outputText);	
			}
		  	socks.close();
	    }catch(IOException ex) {
			  System.out.println(ex);
	  	  System.out.println("crikey");
	    }
    }
}
