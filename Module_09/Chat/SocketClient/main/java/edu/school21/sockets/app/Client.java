package edu.school21.sockets.app;

import java.io.BufferedReader;
import java.net.Socket;
import java.io.*;
import java.net.UnknownHostException;

public class Client {

	private static Socket clientSocket = null;
	private static BufferedReader reader = null;
	private static BufferedReader in = null;
	private static BufferedWriter out = null;

	public static void main(String[] args) {
		try {
			clientSocket = new Socket("localhost", Integer.parseInt(args[0].substring(14)));
			reader = new BufferedReader(new InputStreamReader(System.in));
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

			String hello = in.readLine();
			System.out.print(hello + "\n> ");

			String methodN = reader.readLine();
			out.write(methodN + "\n> ");
			out.flush();

			String messageUname = in.readLine();
			System.out.println(messageUname);

			String login = reader.readLine();
			out.write(login + "\n> ");
			out.flush();

			String messagePword = in.readLine();
			System.out.println(messagePword);

			String password = reader.readLine();
			System.out.println(password);
			out.write(password + "\n> ");
			out.flush();

			String finalMessage = in.readLine();
			System.out.println(finalMessage);

			} catch (IOException e) {
				System.err.println(e);
			} finally {
				try {
					clientSocket.close();
					System.out.println("Client has stopped");
					in.close();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
