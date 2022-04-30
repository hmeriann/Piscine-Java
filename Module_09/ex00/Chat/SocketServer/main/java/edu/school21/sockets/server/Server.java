package edu.school21.sockets.server;

import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.services.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static Socket clientSocket = null; //сокет для общения
	private static ServerSocket server = null; // серверсокет
	private static BufferedReader in = null; // поток чтения из сокета
	private static BufferedReader reader = null;// writes to client
	private static BufferedWriter out = null; // поток записи в сокет
	private Integer port;

	public Server(String port) {
		this.port = Integer.parseInt(port);
	}

	public void startServer() {
		try {
			try {
				server = new ServerSocket(port);
				System.out.println("Server started!");

				clientSocket = server.accept();
				try {
					in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
					reader = new BufferedReader(new InputStreamReader(System.in));

					out.write("Hello from server!\n");
					out.flush();

					String methodName = in.readLine();
					System.out.println(methodName);

					out.write("Enter username:\n");
					out.flush();
					String login = in.readLine();

					out.write("Enter password:\n");
					out.flush();
					String password = in.readLine();

					ApplicationContext context = new AnnotationConfigApplicationContext(SocketsApplicationConfig.class);
					UsersService userService = context.getBean(UsersService.class);
					if (userService.signUp(login, password)) {
						out.write("Successful!\n");
					} else {
						out.write("There is already user with such login\n");
					}
					out.flush();
				} finally {
					clientSocket.close();
					in.close();
					out.close();
				}
			} finally {
				System.out.println("Server is stopped!");
				server.close();
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
