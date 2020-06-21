package _02_Chat_Application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;
/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp extends Thread{
	ServerSocket server;
	public ChatApp() throws IOException {
		int port = Integer.parseInt(JOptionPane.showInputDialog("Enter desired port: "));
		server = new ServerSocket(port); 
	}
	public void run() {
		System.out.println("server is waiting for a client to connect");
		try {
			Socket socks = server.accept();
			System.out.println("connected!");
			DataInputStream input = new DataInputStream(socks.getInputStream());
			DataOutputStream output = new DataOutputStream(socks.getOutputStream());
			output.writeUTF("hey");
			for (int i = 0; i < 10; i++) {
				String outputText = JOptionPane.showInputDialog(input.readUTF());
				output.writeUTF(outputText);	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			ChatApp chatters = new ChatApp();
			chatters.start();
		}catch (Exception e) {
			System.out.println("uhohohohoh");
			System.out.println(e);
		}
	}
}


